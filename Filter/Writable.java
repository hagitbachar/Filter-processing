package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class Writable implements FileFilter {

    private boolean isNo, isNot;

    /**
     * constructor of Filter.Writable filter object
     *
     * @param isNo  true if we want to filter regularly ,false if we want it to be filtered in opposite way
     * @param isNot true if we want to filter regularly ,false if we want it to be filtered in
     *              opposite way
     */
    public Writable(boolean isNo, boolean isNot) {
        this.isNo = isNo;
        this.isNot = isNot;

    }

    /**
     * check whether or not the file is writable
     *
     * @param pathname certain file that is checked
     * @return true if the file is writable or false if else
     */
    @Override
    public boolean accept(java.io.File pathname) {
        if (pathname.canWrite() && !this.isNot && !this.isNo) {
            return true;
        }
        return false;
    }
}
