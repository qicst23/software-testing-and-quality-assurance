import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorDistanceTraveledSegTest {

	private GPXtrkseg trkseg;
	private double expected_distance = 0;

	@Test // normal.
	public final void testDistance0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		
		trkseg = new GPXtrkseg(trkpts);
		
		expected_distance = 0;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trkseg),0.001);
	}
	
	@Test // trkseg is null.
	public final void testDistance1() {
		
		trkseg = null;
		
		expected_distance = -1;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trkseg),0.001);
	}
	
	@Test // normal.
	public final void testDistance2() {
		GPXtrkpt trkpt1 = new GPXtrkpt(0,0,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(180,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		
		trkseg = new GPXtrkseg(trkpts);
		
		expected_distance = 18900;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trkseg),10);
	}
	
	@Test // normal.
	public final void testDistance3() {
		GPXtrkpt trkpt1 = new GPXtrkpt(0,0,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(180,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		trkseg = new GPXtrkseg(trkpts);
		
		expected_distance = 18900+7008+(6.87-4.46);
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trkseg),10);
	}
	
	

}
