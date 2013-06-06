/** 
 * Represents a "link" that is used in a GPX file.
 */

public class GPXlink {

    // the href field (where the link goes to)
    private String _href;
    // the text field (text to display for the link)
    private String _text;

    public GPXlink(String href, String text) {
	_href = href;
	_text = text;
    }

    /* Accessors */
    public String href() { return _href; }
    public String text() { return _text; }


}