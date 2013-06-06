import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class GPXcalculatorTest {
	
	private long expected_time;
	private GPXtrk trk;
	private GPXtrkseg trkseg;
	private double expected_distance = 0;	
	private double expected_average_speed = 0;
	private double expected_bearing;
	private int expected_index;
	

	
	
	/*elapsed time trk*/
	@Test
	public final void testElapsedTrkTime0() {
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
	public final void testElapsedTrkTime1() {
		
		trk = null;
		
		expected_time = -1;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trk));
	}
	
	@Test // Trkseg is non-sense or the time difference is negative; 
	public final void testElapsedTrkTime2() {
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
	public final void testElapsedTrkTime3() {
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
	
	
	
	
	
	
	
	/*elapsed time seg*/
	@Test
	public final void testElapsedSegTime0() {
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
	public final void testElapsedSegTime1() {
		trkseg = null;
		
		expected_time = -1;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}
	
	@Test //time difference is negative.
	public final void testElapsedSegTime2() {
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
	public final void testElapsedSegTime3() {
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
	public final void testElapsedSegTime4() {
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
	public final void testElapsedSegTime5() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
			
		trkseg = new GPXtrkseg(trkpts);
		
		expected_time = 0;
		
		assertEquals(expected_time,GPXcalculator.calculateElapsedTime(trkseg));
		
	}
	
	
	
	
	
	
	
	
	/*test Distance trk*/
	@Test
	public final void testTrkDistance0() {
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
	public final void testTrkDistance1() {
		
		trk = null;
		
		expected_distance = -1;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trk),0.001);
	}
	
	@Test // boundary.
	public final void testTrkDistance2() {
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
	public final void testTrkDistance3() {
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
	
	
	
	
	/*distance traveled Seg*/
	@Test // normal.
	public final void testSegDistance0() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		
		trkseg = new GPXtrkseg(trkpts);
		
		expected_distance = 0;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trkseg),0.001);
	}
	
	@Test // trkseg is null.
	public final void testSegDistance1() {
		
		trkseg = null;
		
		expected_distance = -1;
		
		assertEquals(expected_distance,GPXcalculator.calculateDistanceTraveled(trkseg),0.001);
	}
	
	@Test // normal.
	public final void testSegDistance2() {
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
	public final void testSegDistance3() {
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
	
	
	
	
	
	
	
	/*Average Speed*/
	@Test // normal case.
	public final void testCalculateAverageSpeed() {
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
		
		expected_average_speed = ((4.94-4.46)+(6.87-4.94))/(1000*8);
		
		assertEquals(expected_average_speed,GPXcalculator.calculateAverageSpeed(trk),0.001);
	}
	
	@Test // trk = null.
	public final void testAverage1() {
		
		trk = null;
		
		expected_average_speed = -1;
		
		assertEquals(expected_average_speed,GPXcalculator.calculateAverageSpeed(trk),0.001);
	}
	
	@Test // trk has only one point.
	public final void testAverage2() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
	//	trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_average_speed = 0;
		
		assertEquals(expected_average_speed,GPXcalculator.calculateAverageSpeed(trk),0.001);
		
	}
	
	@Test // time difference is one year.
	public final void testAverage3() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(0,10,4.46,GPXtime.createGPXtime("2010-10-17T18:37:26Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
	//	trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_average_speed = 13010/(365*24*3600*1000);
		
		assertEquals(expected_average_speed,GPXcalculator.calculateAverageSpeed(trk),10);
	}
	
	@Test // time segment is descend.
	public final void testAverage4() {
		GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
		GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
		GPXtrkpt trkpt3 = new GPXtrkpt(0,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:20Z"));
		
		ArrayList trkpts = new ArrayList();
		trkpts.add(trkpt1);
		trkpts.add(trkpt2);
		trkpts.add(trkpt3);
		
		GPXtrkseg trkseg = new GPXtrkseg(trkpts);
		
		ArrayList trksegs = new ArrayList();
		trksegs.add(trkseg);
	//	trksegs.add(trkseg);
		
		trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
		
		expected_average_speed = 13010/(6*1000);
		
		assertEquals(expected_average_speed,GPXcalculator.calculateAverageSpeed(trk),0.001);
	}

	
	
	
	
	
	/*bearing*/
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
	
	
	
	
	
	
	
	
	/*fastest segment*/
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
