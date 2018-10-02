package Filter;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by hagitba on 5/29/17.
 */
public class SmallerThan implements FileFilter {

    private final int CONVERTION_FACTOR = 1024;
    private double upperLimit;
    private boolean isNot;

    /**
     * constructor of Filter.SmallerThan filter object
     *
     * @param upperLimit the value that the file's size is checked in relation to.
     * @param isNot      true if we want to filter regularly ,false if we want it to be filtered in
     *                   opposite way
     */
    public SmallerThan(double upperLimit, boolean isNot) {
        this.upperLimit = upperLimit;
        this.isNot = isNot;
    }

    /**
     * check whether or not the file's size is smaller than the value
     *
     * @param pathname certain file that is checked
     * @return true if the file is smaller or false if else
     */
    @Override
    public boolean accept(File pathname) {
        if (pathname.length() / CONVERTION_FACTOR < upperLimit) {
            if (this.isNot) {
                return false;
            } else {
                return true;
            }
        } else {
            if (this.isNot) {
                return true;
            }
            return false;
        }

    }
}
