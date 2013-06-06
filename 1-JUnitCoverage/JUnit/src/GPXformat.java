/**
 * Represents the result of running the GPXchecker.checkFormat method.
 */

import java.util.ArrayList;

public class GPXformat {

    // indicates whether or not the format is valid
    private boolean _valid = false;
    // any error message that is to be shown
    private String _message;
    // set of XML tags
    private ArrayList _tags;
    
    public GPXformat() { }

    /* Accessors */
    public boolean isValid() { return _valid; }
    public String message() { return _message; }
    public ArrayList tags() { return _tags; }

    /* Mutators */
    public void setValid(boolean valid) { _valid = valid; }
    public void setMessage(String message) { _message = message; }
    public void setTags(ArrayList tags) { _tags = tags; }
}