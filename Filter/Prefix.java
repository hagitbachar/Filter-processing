package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class Prefix implements FileFilter {

    private String value;
    private boolean isNot;

    /**
     * constructor of Filter.Prefix filter object
     *
     * @param value the value to check if he equal to the prefix
     * @param isNot true if we want to filter regularly ,false if we want it to be filtered in
     *              opposite way
     */
    public Prefix(String value, boolean isNot) {
        this.value = value;
        this.isNot = isNot;
    }

    /**
     * check whether or not the value equal to the prefix
     *
     * @param pathname certain file that is checked
     * @return true if the value equal to the prefix or false if else
     */
    @Override
    public boolean accept(java.io.File pathname) {
        String filePrefix = pathname.getName().substring(0, pathname.getName().lastIndexOf("."));
        String slice = filePrefix.substring(0, value.length());
        if (slice.startsWith(value) && !this.isNot)
            return true;
        else {
            return false;
        }
    }
}
