package Exception;

/**
 * Created by hagitba on 5/29/17.
 */
public class BadNameException extends Type1Error{

    /**
     * constructor to exception that throws when the filter description is wrong
     * @param msg the massage that is printed
     */
    public BadNameException(String msg){
        super(msg);
    }
}
