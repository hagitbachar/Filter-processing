package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class FileName implements FileFilter {
    private String value;
    private boolean isNot;

    public FileName(String value, boolean isNot) {
        this.value = value;
        this.isNot = isNot;
    }

    @Override
    public boolean accept(java.io.File pathname) {
        if (pathname.getName().equals(this.value) && !this.isNot) {
            return true;
        } else {
            return false;
        }
    }
}
