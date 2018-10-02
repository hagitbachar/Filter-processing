package Exception;

/**
 * Created by hagitba on 6/1/17.
 */
public class SubSectionException extends Type2Error {


    /**
     * constructor of class which creates specific kind of exception in which a massage
     * (which inform about the error) printed and the program stops.
     * it's created when there is problem with the subsection name or format
     * @param msg the massage that is printed
     */
    public SubSectionException(String msg){
        super(msg);
    }
}
