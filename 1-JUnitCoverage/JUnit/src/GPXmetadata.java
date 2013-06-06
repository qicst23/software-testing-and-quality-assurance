/**
 * Represents the data held in the GXP metadata field.
 */

public class GPXmetadata {

    // the link to display for this GPX file
    private GPXlink _link;
    // the time at which the file was created
    private GPXtime _time;

    public GPXmetadata(GPXlink link, GPXtime time) {
	_link = link;
	_time = time;
    }

    public GPXmetadata() { }

    /* Accessors */
    public GPXlink link() { return _link; }
    public GPXtime time() { return _time; }

}