import java.util.ArrayList;

public class MucalculateElapTrkTest {
	
public String test1()
{
	GPXtrk trk;
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
	
	if (trk!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trk))) ;
	else
		return "null";
}

public String test2()
{
	GPXtrk trk;
	trk = null;
	
	if (trk!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trk))) ;
	else
		return "null";
}

public String test3()
{
	GPXtrk trk;
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
	
	if (trk!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trk))) ;
	else
		return "null";
}

public String test4()
{
	GPXtrk trk;
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
	
	if (trk!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trk))) ;
	else
		return "null";
}

}