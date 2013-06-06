/**
 * Contains a static method to parse a well-formed GPX file and create
 * a GPXobject.
 */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class GPXparser {

    /**
     * This method takes a file in GPX format and converts it into a GPXobject,
     * using the GPXformat to determine what needs to be read.
     * It assumes that the file has already been checked and that the format
     * is valid.
     *
     * @param filename The file to be read
     * @param format A GPXformat object that would be created as the result of calling GPXchecker.checkFormat
     * @returns a GPXobject that holds all the data in the file
     */
    public static GPXobject parse(String filename, GPXformat format) {
	// make sure the format is valid before proceeding
	if (format.isValid() == false) return null;

	// return value
	GPXobject object = null;
	GPXmetadata metadata = null;

	try {
	    // create a scanner to read the file and set its delimeter
	    Scanner in = new Scanner(new File(filename));
	    in.useDelimiter(">");

	    // get the list of tags
	    ArrayList tags = format.tags();
	    // index for reading the list
	    int index = 0;

	    // read the <gpx> tag
	    in.next();
	    index++;

	    // if there is <metadata> it will be here
	    if (tags.get(index).equals("<metadata")) {

		// read the <metadata> tag
		in.next();

		// now we have the <link>
		String link = in.next().trim();
		link = link.substring(link.indexOf('"')+1, link.length()-1);

		// now we have the <text>
		in.next();

		// now we have the content and </text> 
		String text = in.next();
		text = text.substring(0, text.indexOf('<'));

		// now </link>
		in.next();

		// next is <time>
		in.next();

		// now the content and </time>
		String time = in.next();
		time = time.substring(0, time.indexOf('<'));

		// then </metadata>
		in.next();

		// to account for the four tags that were read
		index += 8;

		// create the metadata object
		metadata = new GPXmetadata(new GPXlink(link, text), GPXtime.createGPXtime(time));
	    }

	    
	    // now we're on <trk>
	    in.next();
	    index++;

	    // next is <name>
	    in.next();
	    index++;
	    
	    // then the content and </name>
	    String name = in.next();
	    name = name.substring(0, name.indexOf('<'));
	    index++;

	    // to hold the GPXtrk objects
	    ArrayList trksegs = new ArrayList();

	    // now we have some number of <trkseg> tags
	    while (tags.get(index++).equals("<trkseg")) {
		// consume the token
		in.next();
		
		// to hold the GPXtrkpt objects
		ArrayList trkpts = new ArrayList();

		// now we have some number of <trkpt> tags
		while (tags.get(index++).equals("<trkpt")) {
		    // get the latitude and longitude
		    String latlon = in.next().trim();

		    // the latitude will be something like lat="xx.xxxx"
		    String lat = latlon.split(" ")[1];
		    lat = lat.substring(5, lat.length()-1);

		    // same for longitude
		    String lon = latlon.split(" ")[2];
		    lon = lon.substring(6, lon.length()-1);
		    

		    // read <ele>
		    in.next();
		    index++;

		    // read elevation and </ele>
		    String ele = in.next();
		    // the elevation will be a number then the </ele tag
		    ele = ele.substring(0, ele.indexOf('<'));
		    index++;

		    // read <time>
		    in.next();
		    index++;

		    // read time and </time>
		    String time = in.next();
		    // the time will be the time string followed by </time
		    time = time.substring(0, time.indexOf('<'));
		    index++;

		    // read </trkpt>
		    in.next();
		    index++;

		    // create a GPXtrkpt object
		    GPXtrkpt trkpt = new GPXtrkpt(Double.parseDouble(lat), Double.parseDouble(lon), Double.parseDouble(ele), GPXtime.createGPXtime(time));
		    
		    // put it into the list
		    trkpts.add(trkpt);
		}

		// read </trkseg>
		in.next();

		// create a GPXtrkseg object
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);

		// add it to the list
		trksegs.add(trkseg);

	    }
	    
	    // don't care about </trk> and </gpx>
	    in.next();
	    in.next();

	    // create the GPXobject
	    object = new GPXobject(new GPXmetadata(), new GPXtrk(name, trksegs));

	}
	catch (Exception e) {
	    e.printStackTrace();

	}
       
	return object;
    }


}