package Exception;

/**
 * Created by hagitba on 5/29/17.
 */
public class Type2Error extends FileException {

    /**
     * constructor of class which creates specific kind of exception in which a massage
     * (which inform about the error) printed and the program stops
     * @param msg the massage that is printed
     */
    public Type2Error(String msg) {
        super(msg);
    }
}
