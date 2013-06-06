import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXobjectTest {

	private GPXlink link ;
	private GPXtime time ;
	private GPXtime time_trkpt1 ;
	private GPXtime time_trkpt2 ;
	private GPXmetadata metadata ;
	private GPXtrkpt trkpt1 ;
	private GPXtrkpt trkpt2 ;
	private GPXtrkseg trkseg ; private GPXtrkseg trkseg2 ;
	private ArrayList trkpts ; private ArrayList trkpts2 ;
	private ArrayList trksegs; private ArrayList trksegs2;
	private GPXtrk trk;
	private GPXobject object;                     //Announce an object. Afterwards, use toSring() to create a GPX file string. 
	StringBuffer expected;   //A string buffer for testing. Then, MANUALLY create a string. Lastly, compare.
	
	/*Standard One*/
	@Test
	public final void testGPXobject1() {			    
		  link = new GPXlink("http://www.garmin.com","Garmin International");  //construct an object
		  time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		  metadata = new GPXmetadata(link,time) ; 
		  time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		  trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		  time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		  trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		  trkpts = new ArrayList<GPXtrkpt>();
		  trkpts.add(trkpt1);
		  trkpts.add(trkpt2);
		  trkseg = new GPXtrkseg(trkpts);
		  trksegs = new ArrayList<GPXtrkseg>();
		  trksegs.add(trkseg);
		  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
		  object = new GPXobject(metadata,trk);      
		  
		    expected = new StringBuffer();   
		    expected.append("<gpx>\n");                                   //Manually construct a GPX string
		    expected.append("\t<metadata>\n");
	        expected.append("\t\t<link href=" + link.href() + ">\n");
	        expected.append("\t\t\t<text>" + link.text() + "</text>\n");
	        expected.append("\t\t</link>\n");
	        expected.append("\t\t<time>" + time.toString() + "</time>\n");
	        expected.append("\t</metadata>\n");
	        expected.append("\t<trk>\n");
	          expected.append("\t\t<name>" + trk.name() + "</name>\n");	
			  expected.append("\t\t<trkseg>\n");
				expected.append("\t\t\t<trkpt lat=" + trkpt1.lat() + " lon=" + trkpt1.lon() + ">\n");
			    expected.append("\t\t\t\t<ele>" + trkpt1.ele() + "</ele>\n");
			    expected.append("\t\t\t\t<time>" + trkpt1.time() + "</time>\n");
			    expected.append("\t\t\t</trkpt>\n");
			    expected.append("\t\t\t<trkpt lat=" + trkpt2.lat() + " lon=" + trkpt2.lon() + ">\n");
			    expected.append("\t\t\t\t<ele>" + trkpt2.ele() + "</ele>\n");
			    expected.append("\t\t\t\t<time>" + trkpt2.time() + "</time>\n");
			    expected.append("\t\t\t</trkpt>\n");			    
			  expected.append("\t\t</trkseg>\n");
			expected.append("\t</trk>\n");
			expected.append("</gpx>\n");
			//System.out.println(expected.toString());	 
			
			assertEquals(expected.toString(),object.toString());
	}
	
	/*Without metadata*/
	@Test
	public final void testGPXobject2() {			    
		 
		  metadata = null;
		  time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		  trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		  time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		  trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		  trkpts = new ArrayList<GPXtrkpt>();
		  trkpts.add(trkpt1);
		  trkpts.add(trkpt2);
		  trkseg = new GPXtrkseg(trkpts);
		  trksegs = new ArrayList<GPXtrkseg>();
		  trksegs.add(trkseg);
		  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
		  object = new GPXobject(metadata,trk);      
		  
		    expected = new StringBuffer();   
		    expected.append("<gpx>\n");                                   //Manually construct a GPX string
	        expected.append("\t<trk>\n");
	          expected.append("\t\t<name>" + trk.name() + "</name>\n");	
			  expected.append("\t\t<trkseg>\n");
				expected.append("\t\t\t<trkpt lat=" + trkpt1.lat() + " lon=" + trkpt1.lon() + ">\n");
			    expected.append("\t\t\t\t<ele>" + trkpt1.ele() + "</ele>\n");
			    expected.append("\t\t\t\t<time>" + trkpt1.time() + "</time>\n");
			    expected.append("\t\t\t</trkpt>\n");
			    expected.append("\t\t\t<trkpt lat=" + trkpt2.lat() + " lon=" + trkpt2.lon() + ">\n");
			    expected.append("\t\t\t\t<ele>" + trkpt2.ele() + "</ele>\n");
			    expected.append("\t\t\t\t<time>" + trkpt2.time() + "</time>\n");
			    expected.append("\t\t\t</trkpt>\n");			    
			  expected.append("\t\t</trkseg>\n");
			expected.append("\t</trk>\n");
			expected.append("</gpx>\n");
			//System.out.println(expected.toString());	 
			
			assertEquals(expected.toString(),object.toString());
	}

	
	/*with no trgsegs  (due to the error of trksegs)  */
	@Test
	public final void testGPXobject3() {	
		int isValid=1;
		try{	
		  link = new GPXlink("http://www.garmin.com","Garmin International");  //construct an object
		  time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		  metadata = new GPXmetadata(link,time) ; 		 
		  trksegs = null;		 
		  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
		  object = new GPXobject(metadata,trk);    
		 // System.out.println(object.toString());
		    expected = new StringBuffer();   
		    expected.append("<gpx>\n");                                   //Manually construct a GPX string
		    expected.append("\t<metadata>\n");
	        expected.append("\t\t<link href=" + link.href() + ">\n");
	        expected.append("\t\t\t<text>" + link.text() + "</text>\n");
	        expected.append("\t\t</link>\n");
	        expected.append("\t\t<time>" + time.toString() + "</time>\n");
	        expected.append("\t</metadata>\n");
	        expected.append("\t<trk>\n");
	        expected.append("\t\t<name>" + trk.name() + "</name>\n");	
			expected.append("\t</trk>\n");
			expected.append("</gpx>\n");
			//System.out.println(expected.toString());					
			assertEquals(expected.toString(),object.toString());
		  }
	     catch (Exception e){
	    	 isValid=0; 	    	     	 
	     }
		assertEquals(1,isValid);	
			
	}
	
	

	/*construct object with no trkpt*/
	@Test
	public final void testGPXobject4() {		
		int isValid=1;		
		try{	
		  
		link = new GPXlink("http://www.garmin.com","Garmin International");  //construct an object		 	  
		  trkpts = new ArrayList<GPXtrkpt>();
		  trkpts.add(null);		
		  trkseg = new GPXtrkseg(trkpts);
		  trksegs = new ArrayList<GPXtrkseg>();
		  trksegs.add(trkseg);
		  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
		  object = new GPXobject(metadata,trk);    	  
		    expected = new StringBuffer();       
		    expected.append("<gpx>\n");                                   //Manually construct a GPX string
		    expected.append("\t<metadata>\n");
	        expected.append("\t\t<link href=" + link.href() + ">\n");
	        expected.append("\t\t\t<text>" + link.text() + "</text>\n");
	        expected.append("\t\t</link>\n");
	        expected.append("\t\t<time>" + time.toString() + "</time>\n");
	        
	        expected.append("\t</metadata>\n");
	        expected.append("\t<trk>\n");
	          expected.append("\t\t<name>" + trk.name() + "</name>\n");	
			  expected.append("\t\t<trkseg>\n");						    
			  expected.append("\t\t</trkseg>\n");
			expected.append("\t</trk>\n");
			expected.append("</gpx>\n");
			System.out.println(expected.toString());	 
		 }
	     catch (Exception e){
	    	 isValid=0; 	    		 
	     }
		 assertEquals(1,isValid);	    
					
		assertEquals(expected.toString(),object.toString());
	}
	
	

	/*trkpts time with reversed order*/
	@Test
	public final void testGPXobject5() {	
		
		int isValid=1;
	    try{	    
		    link = new GPXlink("http://www.garmin.com","Garmin International");   //construct an object
		    time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		    metadata = new GPXmetadata(link,time) ; 
		    time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		    trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		    time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		    trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		    trkpts = new ArrayList<GPXtrkpt>();
		    trkpts.add(trkpt1);
		    trkpts.add(trkpt2);
		    trkseg = new GPXtrkseg(trkpts);
		    trksegs = new ArrayList<GPXtrkseg>();
		    trksegs.add(trkseg);
		    trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
		    object = new GPXobject(metadata,trk);                     
	    	if(trkseg!=null)throw new Exception("time must be sequential");   //time must be sequential
	       }
	     catch (Exception e){
	    	 isValid=0; 	    	 
	     }
	    assertEquals(1,isValid);
	}
	
	
	/*trksegs time with reversed order*/
	@Test
	public final void testGPXobject6() {	
		
		int isValid=1;
	    try{	    
		    link = new GPXlink("http://www.garmin.com","Garmin International");   //construct an object
		    time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		    metadata = new GPXmetadata(link,time) ; 
		    
		    time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		    trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		    trkpts= new ArrayList<GPXtrkpt>();
		    trkpts.add(trkpt1);
		    trkseg = new GPXtrkseg(trkpts);
		    
		    time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		    trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		    trkpts2= new ArrayList<GPXtrkpt>();
		    trkpts2.add(trkpt2);
		    trkseg2 = new GPXtrkseg(trkpts2);
		    
		    trksegs= new ArrayList<GPXtrkseg>();
		    trksegs.add(trkseg);
		    trksegs.add(trkseg2);		    
		    
		    trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
		    object = new GPXobject(metadata,trk);    
		    //System.out.println(object.toString());
	    	if(trkseg!=null)throw new Exception("time must be sequential");   //time must be sequential
	       }
	     catch (Exception e){
	    	 isValid=0; 	    	 
	     }
	    assertEquals(1,isValid);
	}
	
	
}
	


