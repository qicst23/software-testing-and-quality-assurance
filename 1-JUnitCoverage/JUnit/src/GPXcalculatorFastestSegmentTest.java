import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorFastestSegmentTest {

	private int expected_index;
	private GPXtrk trk;

	@Test //normal case.
	public final void testFastest0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts0 = new ArrayList();
		trkpts0.add(trkpt1);
		trkpts0.add(trkpt2);
		trkpts0.add(trkpt3);
		
		GPXtrkseg trkseg0 = new GPXtrkseg(trkpts0);
		
		GPXtrkpt trkpt4 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		GPXtrkpt trkpt5 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:35Z"));
		GPXtrkpt trkpt6 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-18T18:37:55Z"));
		
		ArrayList trkpts1 = new ArrayList();
		trkpts1.add(trkpt4);
		trkpts1.add(trkpt5);
		trkpts1.add(trkpt6);
		
		GPXtrkseg trkseg1 = new GPXtrkseg(trkpts1);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg0);
		trksegs.add(trkseg1);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_index = 0;
		
		assertEquals(expected_index,GPXcalculator.calculateFastestSegment(trk));
	}
	
	@Test // trk is null. there is also case that trkseg or trk is nonsense.
	public final void testFastest1() {
		
		trk = null;
		
		expected_index = -1;
		
		assertEquals(expected_index,GPXcalculator.calculateFastestSegment(trk));
	}

}
