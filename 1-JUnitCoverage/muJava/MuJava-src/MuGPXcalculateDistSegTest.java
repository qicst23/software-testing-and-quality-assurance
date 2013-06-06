import java.util.ArrayList;

public class MuGPXcalculateDistSegTest {
	
public String test1()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Double.toString(GPXcalculator.calculateDistanceTraveled(trkseg))) ;
	else
		return "null";
}

public String test2()
{
	GPXtrkseg trkseg;
	trkseg = null;
	
	if (trkseg!=null)
		return (Double.toString(GPXcalculator.calculateDistanceTraveled(trkseg))) ;
	else
		return "null";
}

public String test3()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(0,0,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(180,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	trkpts.add(trkpt2);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Double.toString(GPXcalculator.calculateDistanceTraveled(trkseg))) ;
	else
		return "null";
}

public String test4()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(0,0,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(180,10,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
	GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,6.87,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	trkpts.add(trkpt2);
	trkpts.add(trkpt3);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Double.toString(GPXcalculator.calculateDistanceTraveled(trkseg))) ;
	else
		return "null";
}

}