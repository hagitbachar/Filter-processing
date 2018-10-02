package Order;

import java.io.File;
import java.util.Comparator;

/**
 * Created by hagitba on 5/28/17.
 */
public class Abs implements Comparator<File> {

    private boolean isReversed;

    /**
     * constructor of Order.Abs order object
     * @param isReversed true if we want to order regularly ,false if we want it to be ordered in
     * opposite way
     */
    public Abs(boolean isReversed){
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
        if (this.isReversed) {
            return o1.getAbsolutePath().compareTo(o2.getAbsolutePath()) * (-1);
        }else{
            return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
        }
    }
}
