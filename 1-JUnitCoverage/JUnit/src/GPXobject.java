	/**
 * Represents all the data in a GPX file.
 */

public class GPXobject {

    // the metadata for this file
    private GPXmetadata _metadata;
    // holds all the information about the track
    private GPXtrk _trk;

    public GPXobject(GPXmetadata metadata, GPXtrk trk) {
	_metadata = metadata;
	_trk = trk;
    }

    /* Accessors */
    public GPXmetadata metadata() { return _metadata; }
    public GPXtrk trk() { return _trk; }


    /**
     * This method writes out the XML for this GPX object.
     * It should primarily be used for debugging purposes.
     *
     * @return a well-formatted (according to the GPX file specification provided for this assignment) string representation of the object
     */
    public String toString() {

	StringBuffer out = new StringBuffer();

	// always start with <gpx>
	out.append("<gpx>\n");

	// if there is metadata, it goes next
	if (_metadata != null) {
	    out.append("\t<metadata>\n");
	    out.append("\t\t<link href=" + _metadata.link().href() + ">\n");
	    out.append("\t\t\t<text>" + _metadata.link().text() + "</text>\n");
	    out.append("\t\t</link>\n");
	    out.append("\t\t<time>" + _metadata.time() + "</time>\n");
	    out.append("\t</metadata>\n");
	}

	out.append("\t<trk>\n");

	out.append("\t\t<name>" + _trk.name() + "</name>\n");

	// get all the trkseg obejcts
	GPXtrkseg trksegs[] = _trk.trksegs();

	if (trksegs != null) {

	    // iterate over the trksegs
	    for (int i = 0; i < trksegs.length; i++) {
		
		out.append("\t\t<trkseg>\n");
		
		// get all the trkpt objects
		GPXtrkpt trkpts[] = trksegs[i].trkpts();

		// iterate over the trkpts
		for (int j = 0; j < trkpts.length; j++) {
		    
		    out.append("\t\t\t<trkpt lat=" + trkpts[j].lat() + " lon=" + trkpts[j].lon() + ">\n");
		    out.append("\t\t\t\t<ele>" + trkpts[j].ele() + "</ele>\n");
		    out.append("\t\t\t\t<time>" + trkpts[j].time() + "</time>\n");
		    out.append("\t\t\t</trkpt>\n");

		}

		out.append("\t\t</trkseg>\n");
	    }

	}

	out.append("\t</trk>\n");

	out.append("</gpx>\n");

	return out.toString();

    }

}