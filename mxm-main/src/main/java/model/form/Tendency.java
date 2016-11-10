package model.form;

import learning.noutputs.Distribution;
import model.pitch.IntervalClass;
import model.pitch.Pitch;
import model.pitch.PitchClass;
import model.time.Count;

import java.util.TreeMap;

/**
 * Created by celenp on 11/9/2016.
 */
public class Tendency {

    TreeMap<Count,Distribution<Pitch>> pitchesOverTime;
    TreeMap<Count,Distribution<Pitch>> intervalsOverTime;
    TreeMap<Count,Distribution<PitchClass>> pitchClassesOverTime;
    TreeMap<Count,Distribution<IntervalClass>> intervalClassesOverTime;

}
