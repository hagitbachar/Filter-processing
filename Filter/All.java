
package Filter;

import java.io.*;

/**
 * Created by hagitba on 5/28/17.
 */
public class All implements FileFilter {

    /**
     * return every file
     * @param pathname certain file that is checked
     * @return true always
     */
    @Override
    public boolean accept(java.io.File pathname) {
        return true;
    }
}
