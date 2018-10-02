package Filter;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by hagitba on 5/29/17.
 */
public class GreaterThan implements FileFilter {

    private final int CONVERTION_FACTOR = 1024;
    private double downLimit;
    private boolean isNot;

    /**
     * constructor of Filter.GreaterThan filter object
     *
     * @param downLower the value that the file's size is checked in relation to.
     * @param isNot     true if we want to filter regularly ,false if we want it to be filtered in
     *                  opposite way
     */
    public GreaterThan(double downLower, boolean isNot) {
        this.downLimit = downLower;
        this.isNot = isNot;
    }

    /**
     * check whether or not the file's size is greater than the value
     *
     * @param pathname certain file that is checked
     * @return true if the file is bigger or false if else
     */
    @Override
    public boolean accept(File pathname) {

        if (pathname.length() / CONVERTION_FACTOR > downLimit) {
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
