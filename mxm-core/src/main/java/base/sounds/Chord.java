package base.sounds;

import base.relative.HarmonyClass;
import base.relative.IntervalClass;
import base.relative.PitchClass;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Chord implements ISound, Iterable<PitchClass> {

    private HashSet<PitchClass> factors;
    private HarmonyClass harmonyClass;

    public Chord(Set<PitchClass> pitchClasses){
        this.factors = (HashSet<PitchClass>) pitchClasses;
    }

    public Chord(PitchClass root, HarmonyClass harmonyClass) {
        /* For every interval in the HarmonyClass (which holds all intervals above
            the root, add a chord factor that is also that high above the root */
        for(IntervalClass intervalClass : harmonyClass) {
            factors.add(root.transpose(intervalClass));
        }
        this.harmonyClass = harmonyClass;
    }

    @Override
    public Iterator<PitchClass> iterator() {
        return factors.iterator();
    }
}