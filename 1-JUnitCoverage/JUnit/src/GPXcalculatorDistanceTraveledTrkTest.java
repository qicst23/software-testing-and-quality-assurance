import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorDistanceTraveledTrkTest {

	private double expected_distance = 0;
	private GPXtrk trk;

	@Test
	public final void testDistance0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_distance = 2*((4.94-4.46)+(6.87-4.94));
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trk),0.001);
	}
	
	@Test // null.
	public final void testDistance1() {
		
		trk = null;
		
		expected_distance = -1;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trk),0.001);
	}
	
	@Test // boundary.
	public final void testDistance2() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
		trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_distance = 0;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trk),0.001);
	}
	
	@Test // normal.
	public final void testDistance3() {
		// segment 1
		GPXtrkpt trkpt1 = new GPXtrkpt(0,0,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(180,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts0 = new ArrayList();
		trkpts0.add(trkpt1);
		trkpts0.add(trkpt2);
		trkpts0.add(trkpt3);
		
		GPXtrkseg trkseg0 = new GPXtrkseg(trkpts0);
		
		// segment 2
		GPXtrkpt trkpt4 = new GPXtrkpt(0,0,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt5 = new GPXtrkpt(180,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		
		ArrayList trkpts1 = new ArrayList();
		trkpts1.add(trkpt4);
		trkpts1.add(trkpt5);
		
		GPXtrkseg trkseg1 = new GPXtrkseg(trkpts1);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg0);
		trksegs.add(trkseg1);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_distance = 18900+18900+7008+(6.87-4.46);
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trk),10);
	}

}
