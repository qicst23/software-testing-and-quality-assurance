import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorBearingTest {

	private double expected_bearing;
	private GPXtrk trk;

	@Test // normal case. the math symbol of "+" should be "-".
	public final void testBearing0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(0,20,6.87,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_bearing = 104.617;
		assertEquals(expected_bearing,GPXcalculator.calculateBearing(trk),0.001);
		
		
	}
	
	@Test // trk is null, there is also the case that trk or trkseg is nonsense.
	public final void testBearing1() {
		
		trk = null;
		
		expected_bearing = -1;
		assertEquals(expected_bearing,GPXcalculator.calculateBearing(trk),0.001);
		
		
	}
	
	@Test // boundary case.
	public final void testBearing2() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_bearing = 0;
		assertEquals(expected_bearing,GPXcalculator.calculateBearing(trk),0.001);
		
		
	}

}
