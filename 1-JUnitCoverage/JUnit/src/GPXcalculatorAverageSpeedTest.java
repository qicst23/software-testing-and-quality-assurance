import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GPXcalculatorAverageSpeedTest {

	private double expected_average_speed = 0;
	private GPXtrk trk;
	
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
}
