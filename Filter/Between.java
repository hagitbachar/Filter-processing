package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class Between implements FileFilter {

    private final int CONVERTION_FACTOR = 1024;
    private double upperLimit, downLimit;
    private boolean isNot;


    /**
     * constructor of between filter object
     *
     * @param upperLimit the value that the file's size is checked in relation to.
     * @param downLimit  the other value that the file's size is checked in relation to.
     * @param isNot      true if we want to filter regularly ,false if we want it to be filtered in
     *                   opposite way
     */
    public Between(double upperLimit, double downLimit, boolean isNot) {
        this.upperLimit = upperLimit;
        this.downLimit = downLimit;
        this.isNot = isNot;
    }


    /**
     * check whether or not the file's size is between the two values
     *
     * @param pathname certain file that is checked
     * @return true if the file is between or false if else
     */
    @Override
    public boolean accept(java.io.File pathname) {

        if (pathname.length() / CONVERTION_FACTOR < upperLimit && pathname.length() /
                CONVERTION_FACTOR > downLimit) {
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
