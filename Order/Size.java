package Order;

import java.util.Comparator;
import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class Size implements Comparator<java.io.File> {

    public final int FIRST_SMALLER = -1;
    public final int FIRST_LARGER = 1;
    public final int BOTH_EQUAL = 0;
    public boolean isReversed;

    File[] filteredFiles;

    /**
     * constructor of Order.Abs Order.Size object
     * @param isReversed true if we want to order regularly ,false if we want it to be ordered in
     * opposite way
     */
    public Size(boolean isReversed) {
        this.isReversed = isReversed;

    }

    /**
     * compare between 2 given objects
     * @param o1 the 1st value to compare
     * @param o2 the 2st value to compare
     * @return negative number if the 1st smaller than the 2st, positive number if the 1st bigger than the
     * 2st, zero if they equal.
     */
    @Override
    public int compare(File o1, File o2) {
        int returnValue=0;
        if (o1.length() < o2.length()) {
            if (!this.isReversed){
                returnValue = FIRST_SMALLER;
            } else {
                returnValue = FIRST_LARGER;
            }
        } else if (o1.length() > o2.length()) {
            if (!this.isReversed){
                returnValue= FIRST_LARGER;
            } else {
                returnValue = FIRST_SMALLER;
            }
        }
        else if (o1.length() == o2.length()) {
            returnValue= BOTH_EQUAL;
        }return returnValue;
    }
}
