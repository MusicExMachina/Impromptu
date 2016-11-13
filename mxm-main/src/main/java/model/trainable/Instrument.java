package model.trainable;

import model.basic.Pitch;
import model.basic.Technique;

import java.util.Set;

/**
 * A class for storing information about
 * a specific instrument. Note that this
 * is specific enough to be "Horn in F"
 * instead of just "Horn" given that different
 * transpositions of the "same" instrument
 * have different tendencies.
 */
public class Instrument {

    public static final Instrument DEFAULT = new Instrument("Default Instrument");
    public static final Instrument ACOUSTICGRANDPIANO = new Instrument("Acoustic Grand Piano");
    public static final Instrument BRIGHTACOUSTICPIANO = new Instrument("Bright Acoustic Piano");
    public static final Instrument ELECTRICGRANDPIANO = new Instrument("Electric Grand Piano");
    public static final Instrument HONKYTONKPIANO = new Instrument("Honky-Tonk Piano");
    public static final Instrument ELECTRICPIANO1 = new Instrument("Electric Piano 1");
    public static final Instrument ELECTRICPIANO2 = new Instrument("Electric Piano 2");
    public static final Instrument HARPSICHORD = new Instrument("Harpsichord");
    public static final Instrument CLAVI = new Instrument("Clavichord");
    public static final Instrument CELESTA = new Instrument("Celesta");
    public static final Instrument GLOCKENSPIEL = new Instrument("Glockenspiel");
    public static final Instrument MUSICBOX = new Instrument("Music Box");
    public static final Instrument VIBES = new Instrument("Vibraphone");
    public static final Instrument MARIMBA = new Instrument("Marimba");
    public static final Instrument XYLOPHONE = new Instrument("Xylophone");
    public static final Instrument TUBULARBELLS = new Instrument("Tubular Bells");
    public static final Instrument DULCIMER = new Instrument("Dulcimer");
    public static final Instrument DRAWBARORGAN = new Instrument("Drawbar Organ");
    public static final Instrument PERCUSSIVEORGAN = new Instrument("Percussive Organ");
    public static final Instrument ROCKORGAN = new Instrument("Rock Organ");
    public static final Instrument CHURCHORGAN = new Instrument("Churh Organ");
    public static final Instrument REEDORGAN = new Instrument("Reed Organ");
    public static final Instrument ACCORDION = new Instrument("Accordion");
    public static final Instrument HARMONICA = new Instrument("Harmonica");
    public static final Instrument TANGOACCORDION = new Instrument("Tango Accordion");
    public static final Instrument ACOUSTICNYLONGUITAR = new Instrument("Acoustic Guitar (Nylon)");
    public static final Instrument ACOUSTICSTEELGUITAR = new Instrument("Acoustic Guitar (Steel)");
    public static final Instrument ELECTRICJAZZGUITAR = new Instrument("Electric Guitar (Jazz)");
    public static final Instrument ELECTRICCLEANGUITAR = new Instrument("Electric Guitar (Clean)");
    public static final Instrument ELECTRICMUTEDGUITAR = new Instrument("Electric Guitar (Muted)");
    public static final Instrument OVERDRIVENGUITAR = new Instrument("Overdriven Guitar");
    public static final Instrument DISTORTIONGUITAR = new Instrument("Distortion Guitar ");
    public static final Instrument GUITARHARMONICS = new Instrument("Guitar Harmonics");
    public static final Instrument ACOUSTICBASS = new Instrument("Acoustic Bass");
    public static final Instrument ELECTRICFINGERBASS = new Instrument("Electric Bass (Finger)");
    public static final Instrument ELECTRICPICKEDBASS = new Instrument("Electric Bass (Picked)");
    public static final Instrument FRETLESSBASS = new Instrument("Fretless Bass");
    public static final Instrument SLAPBASS1 = new Instrument("Slap Bass 1");
    public static final Instrument SLAPBASS2 = new Instrument("Slap Bass 2");
    public static final Instrument SYNTHBASS1 = new Instrument("Synth Bass 1");
    public static final Instrument SYNTHBASS2 = new Instrument("Synth Bass 2");
    public static final Instrument VIOLIN = new Instrument("Violin");
    public static final Instrument VIOLA = new Instrument("Viola");
    public static final Instrument CELLO = new Instrument("Cello");
    public static final Instrument CONTRABASS = new Instrument("Contrabass");
    public static final Instrument TREMOLOSTRINGS = new Instrument("Tremolo Strings");
    public static final Instrument PIZZICATOSTRINGS = new Instrument("Pizzicato Strings");
    public static final Instrument ORCHESTRALHARP = new Instrument("Orchestral Harp");
    public static final Instrument TIMPANI = new Instrument("Timpani");
    public static final Instrument STRINGENSEMBLE1 = new Instrument("String Ensemble 1");
    public static final Instrument STRINGENSEMBLE2 = new Instrument("String Ensemble 2");
    public static final Instrument SYNTHSTRINGS1 = new Instrument("Synth Strings 1");
    public static final Instrument SYNTHSTRINGS2 = new Instrument("Synth Strings 2");
    public static final Instrument AAHS = new Instrument("Choral Aahs");
    public static final Instrument OOHS = new Instrument("Voice Oohs");
    public static final Instrument SYNTHVOICE = new Instrument("Synth Voice");
    public static final Instrument ORCHESTRAHIT = new Instrument("Marimba");
    public static final Instrument TRUMPET = new Instrument("Marimba");
    public static final Instrument TROMBONE = new Instrument("Marimba");
    public static final Instrument TUBA = new Instrument("Marimba");
    public static final Instrument MUTEDTRUMPET = new Instrument("Marimba");
    public static final Instrument FRENCHORN = new Instrument("Marimba");
    public static final Instrument BRASSSECTION = new Instrument("Marimba");
    public static final Instrument SYNTHBRASS1 = new Instrument("Marimba");
    public static final Instrument SYNTHBRASS2 = new Instrument("Marimba");
    public static final Instrument SOPRANOSAX = new Instrument("Marimba");
    public static final Instrument ALTOSAX = new Instrument("Marimba");
    public static final Instrument TENORSAX = new Instrument("Marimba");
    public static final Instrument BARISAX = new Instrument("Marimba");
    public static final Instrument OBOE = new Instrument("Marimba");
    public static final Instrument ENGLISHHORN = new Instrument("Marimba");
    public static final Instrument BASSOON = new Instrument("Marimba");
    public static final Instrument CLARINET = new Instrument("Marimba");
    public static final Instrument PICCOLO = new Instrument("Marimba");
    public static final Instrument FLUTE = new Instrument("Marimba");
    public static final Instrument RECORDER = new Instrument("Marimba");
    public static final Instrument PANFLUTE = new Instrument("Marimba");
    public static final Instrument BLOWNBOTTLE = new Instrument("Marimba");
    public static final Instrument SHAKUHACHI = new Instrument("Marimba");
    public static final Instrument WHISTLE = new Instrument("Marimba");
    public static final Instrument OCARINA = new Instrument("Marimba");
    public static final Instrument SQUARELEAD1 = new Instrument("Marimba");
    public static final Instrument SAWTOOTHLEAD2 = new Instrument("Marimba");
    public static final Instrument CALLIOPELEAD3 = new Instrument("Marimba");
    public static final Instrument CHIFFLEAD4 = new Instrument("Marimba");
    public static final Instrument CHARANGLEAD5 = new Instrument("Marimba");
    public static final Instrument VOICELEAD6 = new Instrument("Marimba");
    public static final Instrument FIFTHSLEAD7 = new Instrument("Marimba");
    public static final Instrument BASSLEAD8 = new Instrument("Marimba");
    public static final Instrument NEWAGEPAD1 = new Instrument("Marimba");
    public static final Instrument WARMPAD2 = new Instrument("Marimba");
    public static final Instrument POLYSYNTHPAD3 = new Instrument("Marimba");
    public static final Instrument CHOIRPAD4 = new Instrument("Marimba");
    public static final Instrument BOWEDPAD5 = new Instrument("Marimba");
    public static final Instrument METALLICPAD6 = new Instrument("Marimba");
    public static final Instrument HALOPAD7 = new Instrument("Marimba");
    public static final Instrument SWEEPPAD8 = new Instrument("Marimba");
    public static final Instrument RAINFX1 = new Instrument("Marimba");
    public static final Instrument SOUNDTRACKFX2 = new Instrument("Marimba");
    public static final Instrument CRYSTALFX3 = new Instrument("Marimba");
    public static final Instrument ATMOSPHEREFX4 = new Instrument("Marimba");
    public static final Instrument BRIGHTNSSFX5 = new Instrument("Marimba");
    public static final Instrument GOBLINSFX6 = new Instrument("Marimba");
    public static final Instrument ECHOESFX7 = new Instrument("Marimba");
    public static final Instrument SCIFIFX8 = new Instrument("Marimba");
    public static final Instrument SITAR = new Instrument("Marimba");
    public static final Instrument BANJO = new Instrument("Marimba");
    public static final Instrument SHAMISEN = new Instrument("Marimba");
    public static final Instrument KOTO = new Instrument("Marimba");
    public static final Instrument KALIMBA = new Instrument("Marimba");
    public static final Instrument BAGPIPE = new Instrument("Marimba");
    public static final Instrument FIDDLE = new Instrument("Marimba");
    public static final Instrument SHANAI = new Instrument("Marimba");
    public static final Instrument TINKLEBELL = new Instrument("Marimba");
    public static final Instrument AGOGO = new Instrument("Marimba");
    public static final Instrument STEELDRUMS = new Instrument("Marimba");
    public static final Instrument WOODBLOCK = new Instrument("Marimba");
    public static final Instrument TAIKODRUM = new Instrument("Marimba");
    public static final Instrument MELODICTOM = new Instrument("Marimba");
    public static final Instrument SYNTHDRUM = new Instrument("Marimba");
    public static final Instrument REVERSECYMBAL = new Instrument("Marimba");
    public static final Instrument GUITARFRETNOISE = new Instrument("Marimba");
    public static final Instrument BREATHNOISE = new Instrument("Marimba");
    public static final Instrument SEASHORE = new Instrument("Marimba");
    public static final Instrument BIRDTWEET = new Instrument("Marimba");

    private String name;
    private Set<Pitch> possiblePitches;
    private Set<Technique> possibleTechniques;

    public Instrument(String name) {
        this.name = name;
    }

    public static Instrument getGeneralMIDIInstrument(int number) {return DEFAULT;}

    @Override
    public String toString() {
        return name;
    }
}
