import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class GPXparserTest {
	private String filename = "D\\p1.txt"; 
	private String filename_bad1 = "D\\p2.txt";
	private String filename_bad2 = "D\\p3.txt";
	private String filename_bad3 = "D\\p4.txt";	
	private String filename2 = "D\\p5.txt";
	private GPXobject result_object;

	private GPXlink link ;
	private GPXtime time ;
	private GPXtime time_trkpt1 ;
	private GPXtime time_trkpt2 ;
	private GPXmetadata metadata ;
	private GPXtrkpt trkpt1 ;
	private GPXtrkpt trkpt2 ;
	private GPXtrkseg trkseg ;
	private ArrayList trkpts ;
	private ArrayList trksegs;
	private GPXtrk trk;
	private GPXobject object;
    
	/* void input */
	@Test
	public final void test0() {		
	                                              
			GPXparser parser=new GPXparser();			
			GPXformat format= new GPXformat();
			GPXchecker checker= new GPXchecker();	
			GPXobject o=new GPXobject(null, null);
			 o = parser.parse(filename_bad1, checker.checkFormat(filename_bad1));			
			assertEquals(null, o);
	}
		
	
	
	/* longitude plus-minus problem  */
	@Test
	public final void test1() {
		link = new GPXlink("http://www.garmin.com","Garmin International");  //construct a standard object
		time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		metadata = new GPXmetadata(link,time) ; 
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		object = new GPXobject(metadata,trk);		                                              
			GPXparser parser=new GPXparser();
			GPXchecker checker=new GPXchecker();
			result_object = parser.parse(filename,checker.checkFormat(filename));	
			assertEquals(-122.326897,result_object.trk().trkseg(0).trkpt(1).lon(),0.01);
	}
	
	
	
	
	@Test  //Confusion of < in the name attribute
	public final void test2() {
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename_bad1,checker.checkFormat(filename_bad1));	
		assertEquals("Walking up a hill.<> Straight up!",result_object.trk().name());
		
	}
	
	@Test  // examine the attribute of trk
	public final void test3() {
		link = new GPXlink("http://www.garmin.com","Garmin International");    
		time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		metadata = new GPXmetadata(link,time) ; 
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename,checker.checkFormat(filename));			
		assertEquals(object.trk().toString(),result_object.trk().toString());
		
	}
	
	@Test  //when there are more than one seg
	public final void test4() {
		link = new GPXlink("http://www.garmin.com","Garmin International");
		time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		metadata = new GPXmetadata(link,time) ; 
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);           
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename_bad2,checker.checkFormat(filename_bad2));			
		assertEquals(object.trk().toString(),result_object.trk().toString());	
	}
	
	
	
	@Test  //examine the atrributes of metadata
	public final void test5() {
		link = new GPXlink("http://www.garmin.com","Garmin International");
		time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		metadata = new GPXmetadata(link,time) ; 
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);           
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename,checker.checkFormat(filename));			
		assertEquals(object.metadata(),result_object.metadata());	
	}
	

	@Test  //compare the two complete object.toString()
	public final void test6() {
		link = new GPXlink("http://www.garmin.com","Garmin International");
		time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		metadata = new GPXmetadata(link,time) ; 
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);           
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename,checker.checkFormat(filename));			
		assertEquals(object.toString(),result_object.toString());	
	}
	
	
	
	
	@Test  //If there isn't tag <name> .
	       //There is a problem with GPXchecker. GPXchecker doesn't consider it invalid without name attribute. 
	public final void test7() {
		link = new GPXlink("http://www.garmin.com","Garmin International");
		time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
		metadata = new GPXmetadata(link,time) ; 
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		trk = new GPXtrk(null,trksegs);           
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename_bad3,checker.checkFormat(filename_bad3));			
		assertEquals(object.trk().toString(),result_object.trk().toString());	
	}
	
	@Test  //if there is no metadata
	public final void test8() {		
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);           
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename2,checker.checkFormat(filename2));			
		assertEquals(object.metadata(),result_object.metadata());	
	}
	
	@Test  // wrong file name
	public final void test9() {		
		time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
		trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
		time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
		trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
		trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkseg = new GPXtrkseg(trkpts);
		trksegs = new ArrayList();
		trksegs.add(trkseg);
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);           
		object = new GPXobject(metadata,trk);
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse("D:/blablabla",checker.checkFormat("D:/blablabla"));			
		assertEquals(object.trk().toString(),result_object.trk().toString());	
	}
	
	
}
