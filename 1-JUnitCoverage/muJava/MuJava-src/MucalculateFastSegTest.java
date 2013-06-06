
import java.util.ArrayList;

public class MucalculateFastSegTest {
	
public String test1()
{
	GPXtrk trk;
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
	
	if (trk!=null)
		return (Integer.toString(GPXcalculator.calculateFastestSegment(trk))) ;
	else
		return "null";
}

public String test2()
{
	GPXtrk trk;
	trk = null;
	
	if (trk!=null)
		return (Integer.toString(GPXcalculator.calculateFastestSegment(trk))) ;
	else
		return "null";
}

public String test3() {
	
	GPXtrk trk;
GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:21Z"));
GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));				
ArrayList trkpts0 = new ArrayList();
trkpts0.add(trkpt1);
trkpts0.add(trkpt2);		
GPXtrkseg trkseg0 = new GPXtrkseg(trkpts0);

GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
GPXtrkpt trkpt4 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));	
ArrayList trkpts1 = new ArrayList();
trkpts1.add(trkpt3);
trkpts1.add(trkpt4);
GPXtrkseg trkseg1 = new GPXtrkseg(trkpts1);

ArrayList trksegs = new ArrayList();
trksegs.add(trkseg0);
trksegs.add(trkseg1);		
GPXtrkpt trkpt5 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:35Z"));
GPXtrkpt trkpt6 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:36Z"));		
ArrayList trkpts2 = new ArrayList();
trkpts2.add(trkpt5);
trkpts2.add(trkpt6);		
GPXtrkseg trkseg2 = new GPXtrkseg(trkpts2);

trk = new GPXtrk("Walking up a hill. Straight up!",trksegs);
if (trk!=null)
	return (Integer.toString(GPXcalculator.calculateFastestSegment(trk))) ;
else
	return "null";
}

public String test4()
{
	GPXtrk trk;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.94,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
	GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-17T18:37:55Z"));
	
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
	
	if (trk!=null)
		return (Integer.toString(GPXcalculator.calculateFastestSegment(trk))) ;
	else
		return "null";
}

}
