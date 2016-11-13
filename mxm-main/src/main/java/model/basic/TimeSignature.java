package model.basic;

/**
 * TimeSignatures are exactly what they sound like in the Western music theory
 * sense. These are useful as they define how RhythmTrees divide on the first few
 * levels (3/4 versus 6/8) and will eventually  be useful in determining how
 * transitions between TimeSignatures work.
 *
 * Note: These are in many ways structurally similar to Counts. The major difference
 * is that there's no reason to ever reduce a TimeSignature from say, 4/4 to 2/2.
 */
public class TimeSignature {

    /** The fractional numerator of this TimeSignature */
    private int numerator;

    /** The fractional denominator of this TimeSignature */
    private int denominator;

    /**
     * A constructor for TimeSignature taking in a numerator and
     * denominator. Note that these do not need to be reduced,
     * as TimeSignatures can be almost anything you want them
     * to be.
     * @param numerator The desired numerator.
     * @param denominator The desired denominator.
     */
    public TimeSignature(int numerator, int denominator) {
        if(numerator > 0 && denominator > 0) {
            this.numerator   = numerator;
            this.denominator = denominator;
        }
        else {
            throw new Error("Cannot create a TimeSignature with a numerator or denominator below or equal to zero.");
        }
    }

    /**
     * Gets the denominator of this TimeSignature.
     * @return This TimeSignature's denominator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Gets the denominator of this TimeSignature.
     * @return This TimeSignature's denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * The preferred subdivision at each given subdivision level.
     * @return The prefered number of subdivisions at each level.
     */
    public int getPreferredSubdivision(int level) {
        switch(level) {
            case 0:
                // 2/2, 3/2
                if(denominator == 2) {
                    return numerator;
                }
                // 2/4, 3/4, 4/4, 5/4, 6/4
                else if(denominator == 4) {
                    return numerator;
                }
                // 3/8, 6/8, 9/8, 12/8
                if(numerator % 3 == 0 && denominator == 8) {
                    return 2;
                }
                // 2/8, 4/8, 8/8
                else if(numerator % 2 == 0 && denominator == 8) {
                    return 2;
                }
                // 5/8, 7/8
                else {
                    return numerator;
                }
            case 1:
                // 2/2, 3/2
                if(denominator == 2) {
                    return numerator;
                }
                // 2/4, 3/4, 4/4, 5/4, 6/4
                if(denominator == 4) {
                    return 2;
                }
                // 3/8, 6/8, 9/8, 12/8
                else if(numerator % 3 == 0 && denominator == 8) {
                    return 3;
                }
                // 2/8, 4/8, 8/8
                else if(numerator % 2 == 0 && denominator == 8) {
                    return 2;
                }
                // 5/8, 7/8
                else {
                    return 2;
                }
        }
        return 2;
    }

    /**
     * Returns a nicely-formatted String
     * of this TimeSignature (for debug).
     * @return This TimeSignature's String representation.
     */
    public String toString() {
        return getNumerator() + "/" + getDenominator() + " time ";
    }

    /**
     * A noteQualities (generated) equals() method for TimeSignature.
     * @param o The Object to compare this to.
     * @return If these two Objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSignature timeSignature = (TimeSignature) o;

        return numerator == timeSignature.numerator && denominator == timeSignature.denominator;
    }

    /**
     * A simple hash code in order to allow storage
     * in certain Collections, like HashSets.
     * @return The hash code for this TimeSignature.
     */
    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }
}
