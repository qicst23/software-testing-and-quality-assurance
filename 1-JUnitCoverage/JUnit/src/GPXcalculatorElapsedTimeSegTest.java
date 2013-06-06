import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorElapsedTimeSegTest {

	private GPXtrkseg trkseg;
	private long expected_time;
	

	@Test
	public final void testElapsedTime0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		trkseg = new GPXtrkseg(trkpts);
		
		expected_time = 1000*8;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}
	
	@Test //track segment is null.
	public final void testElapsedTime1() {
		trkseg = null;
		
		expected_time = -1;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}
	
	@Test //time difference is negative.
	public final void testElapsedTime2() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:28Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:20Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		expected_time = -1;
		
		trkseg = new GPXtrkseg(trkpts);
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}
	
	@Test //track segment is non-sense.
	public final void testElapsedTime3() {
		long result_exception = -1;
		try {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-29T18:37:25Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		trkseg = new GPXtrkseg(trkpts);
		
		if (trkseg != null) throw new Exception();
		}
		catch (Exception e){
			result_exception = 0;
		}
		
		expected_time = -1;
		
		assertEquals(expected_time,result_exception);
		
	}
	
	@Test // Time difference is one year. The result is wrong.
	public final void testElapsedTime4() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2010-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		trkseg = new GPXtrkseg(trkpts);
		
		expected_time = 365*24*3600*1000;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}
	
	@Test // only one track point.
	public final void testElapsedTime5() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
			
		trkseg = new GPXtrkseg(trkpts);
		
		expected_time = 0;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}

}
