package Exception;

/**
 * Created by hagitba on 5/29/17.
 */
public class Type1Error extends FileException {
    /**
     * constructor of class which creates specific kind of exception in which only a massage
     * (which inform about the problematic line) printed and the program continues.
     * @param msg the massage that is printed
     */
    public Type1Error(String msg) {
        super(msg);
    }
}
