package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class Contains implements FileFilter {
    private String value;
    private boolean isNot;


    /**
     * constructor of Filter.Contains filter object
     *
     * @param value the value to check if he contains or not in the file name
     * @param isNot true if we want to filter regularly ,false if we want it to be filtered in
     *              opposite way
     */
    public Contains(String value, boolean isNot) {
        this.value = value;
        this.isNot = isNot;
    }

    /**
     * check whether or not the value contains in the file name
     *
     * @param pathname certain file that is checked
     * @return true if the value contains or false if else
     */
    @Override
    public boolean accept(java.io.File pathname) {
        String baseName = pathname.getName().substring(0, pathname.getName().lastIndexOf("."));
        if (baseName.contains(value) && !this.isNot) {
            return true;
        } else {
            return false;
        }
    }


}
