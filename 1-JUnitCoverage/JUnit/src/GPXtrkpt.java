/**
 * Represents a track point in a GPX file.
 */

public class GPXtrkpt {

    // latitude
    private double _lat;
    // longitude
    private double _lon;
    // elevation
    private double _ele;
    // time
    private GPXtime _time;

    public GPXtrkpt(double lat, double lon, double ele, GPXtime time) {
	_lat = lat;
	_lon = lon;
	_ele = ele;
	_time = time;
    }

    /* Accessors */
    public double lat() { return _lat; }
    public double lon() { return _lon; }
    public double ele() { return _ele; }
    public GPXtime time() { return _time; }

}
