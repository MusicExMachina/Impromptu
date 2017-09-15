package form.timelines;

import events.sound.Note;
import events.time.TempoChange;
import events.time.TimeSigChange;
import properties.sound.Chord;
import properties.sound.Noise;
import properties.sound.Pitch;
import form.IPassage;
import form.ISerialTimeline;
import org.jetbrains.annotations.NotNull;
import properties.time.Tempo;
import properties.time.TimeSig;
import properties.time.*;

import java.util.*;

/**
 * We store the public interfaces of such
 */
public abstract class AbstractScore implements IPassage {

    private String title;
    private Set<AbstractPart> parts;

    // Timing Information
    private SerialTimeline<TimeSigChange> timeSigChanges;
    private SerialTimeline<TempoChange> tempoChanges;

    // Other music events
    private ParallelTimeline<Note> allNotes;
    private ParallelTimeline<Note<Pitch>> allPitchedNotes;
    private ParallelTimeline<Note<Noise>> allUnpitchedNotes;
    private ParallelTimeline<Note<Chord>> allChordNotes;

    /**
     *
     * @param title a
     */
    protected AbstractScore(String title) {
        this.title = title;
        this.parts = new HashSet<>();

        // Initialize timing timelines
        this.timeSigChanges = new SerialTimeline<>();
        this.tempoChanges = new SerialTimeline<>();

        this.allNotes = new ParallelTimeline<>();
        this.allPitchedNotes = new ParallelTimeline<>();
        this.allUnpitchedNotes = new ParallelTimeline<>();
        this.allChordNotes = new ParallelTimeline<>();
    }

    //////////////////
    // AbstractScore Adders //
    //////////////////

    // Adds a part
    public @NotNull AbstractScore add(AbstractPart part) {
        parts.add(part);
        return this;
    }
    // Adds a time signature change
    public @NotNull AbstractScore add(@NotNull TimeSig timeSig, @NotNull IMeasure time) {
        timeSigChanges.addEvent(new TimeSigChange(this, time, timeSig));
        return this;
    }
    // Adds a tempo change
    public @NotNull AbstractScore add(@NotNull Tempo tempo, @NotNull ITime time) {
        tempoChanges.addEvent(new TempoChange(this, time, tempo));
        return this;
    }

    @Override
    public final @NotNull ISerialTimeline<TimeSigChange> getTimeSigChanges() { return timeSigChanges; }
    @Override
    public final @NotNull ISerialTimeline<TempoChange> getTempoChanges() { return tempoChanges; }

    @NotNull
    public Iterator<Note> noteItrAt(ITime time) { return allNotes.getFrameBefore(time).eventsNotEndedItr(); }
    @NotNull
    @Override
    public Iterator<Note<Pitch>> pitchedNoteItrAt(ITime time) { return allPitchedNotes.getFrameBefore(time).eventsNotEndedItr(); }
    @Override
    public Iterator<Note<Noise>> unpitchedNoteItrAt(ITime time) { return allUnpitchedNotes.getFrameBefore(time).eventsNotEndedItr(); }
    @Override
    public Iterator<Note<Chord>> chordNoteItrAt(ITime time) { return allChordNotes.getFrameBefore(time).eventsNotEndedItr(); }

    @Override
    public @NotNull Tempo getTempoAt(ITime time) { return tempoChanges.getEventBefore(time).getTempo(); }
    @Override
    public @NotNull TimeSig getTimeSigAt(ITime time) { return timeSigChanges.getEventBefore(time).getTimeSig(); }
}
