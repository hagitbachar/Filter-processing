package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class Suffix implements FileFilter {

    private String value;
    private boolean isNot;
    private final String FILE_EXTENSION = "";


    /**
     * constructor of Filter.Suffix filter object
     *
     * @param value the value to check if he equal to the suffix
     * @param isNot true if we want to filter regularly ,false if we want it to be filtered in
     *              opposite way
     */
    public Suffix(String value, boolean isNot) {
        this.value = value;
        this.isNot = isNot;
    }

    /**
     * check whether or not the value equal to the suffix
     *
     * @param pathname certain file that is checked
     * @return true if the value equal to the suffix or false if else
     */
    @Override
    public boolean accept(java.io.File pathname) {
        if (pathname.getName().endsWith(value) && !this.isNot) {
            return true;
        } else {
            return false;
        }
    }
}
