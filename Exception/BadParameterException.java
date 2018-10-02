package Exception;

/**
 * Created by hagitba on 5/29/17.
 */
public class BadParameterException extends Type1Error {

    /**
     * constructor to exception that throws when the one or more of the filter object parameter in
     * the description is wrong
     * @param msg the massage that is printed
     */
    public  BadParameterException(String msg){
        super(msg);
    }
}
