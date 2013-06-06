import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorElapsedTimeTrkTest {

	private long expected_time;
	private GPXtrk trk;

	@Test
	public final void testElapsedTime0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_time = 1000*8*2;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trk));
	}
	
	@Test // trk is null.
	public final void testElapsedTime1() {
		
		trk = null;
		
		expected_time = -1;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trk));
	}
	
	@Test // Trkseg is non-sense or the time difference is negative; 
	public final void testElapsedTime2() {
		long result = -1;
		try {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-16T18:37:34Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		if(trk!=null) throw new Exception();
		}
		
		catch(Exception e){
			result = 0;
		}
		
		expected_time = -1;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trk));
		//assertEquals(expected_time,result);
	}
	
	@Test // time difference is one year.
	public final void testElapsedTime3() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2010-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_time = 2*365*24*3600*1000;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trk));
	}

}
