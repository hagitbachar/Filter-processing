package Order;

import java.io.File;
import java.util.Comparator;
import java.lang.Math;

/**
 * Created by hagitba on 5/28/17.
 */
public class Type implements Comparator<java.io.File> {


    public final int FIRST_SMALLER = -1;
    public final int FIRST_LARGER = 1;
    public final int BOTH_EQUAL = 0;
    public boolean isReversed;

    /**
     * constructor of Order.Type order object
     * @param isReversed true if we want to order regularly ,false if we want it to be ordered in
     * opposite way
     */
    public Type(boolean isReversed){
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

        String fileExtension1 = o1.getName().substring(o1.getName().lastIndexOf(".") + 1);
        String fileExtension2 = o2.getName().substring(o2.getName().lastIndexOf(".") + 1);
        char[] fileExtension1Array = fileExtension1.toCharArray();
        char[] fileExtension2Array = fileExtension2.toCharArray();
        for (int i = 0; i < Math.min(fileExtension1Array.length, fileExtension2Array.length); i++) {
            if (fileExtension1Array[i] == fileExtension2Array[i]) {
                continue;
            } else if (fileExtension1Array[i] > fileExtension2Array[i]) {
                if (!this.isReversed){
                    return FIRST_LARGER;
                } else {
                    return FIRST_SMALLER;
                }
            } else if (fileExtension1Array[i] < fileExtension2Array[i]) {
                if (!this.isReversed){
                    return FIRST_SMALLER;
                } else {
                    return FIRST_LARGER;
                }
            }
        } return BOTH_EQUAL;

    }
}
