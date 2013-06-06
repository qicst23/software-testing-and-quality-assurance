import java.util.ArrayList;

public class MucalculateElapSegTest {
	
public String test1()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
	GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:34Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	trkpts.add(trkpt2);
	trkpts.add(trkpt3);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trkseg))) ;
	else
		return "null";
}

public String test2()
{
	GPXtrkseg trkseg;
	trkseg = null;
	
	if (trkseg!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trkseg))) ;
	else
		return "null";
}

public String test3()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:28Z"));
	GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:20Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	trkpts.add(trkpt2);
	trkpts.add(trkpt3);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trkseg))) ;
	else
		return "null";
}

public String test4()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:31Z"));
	GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2010-10-17T18:37:26Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	trkpts.add(trkpt2);
	trkpts.add(trkpt3);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trkseg))) ;
	else
		return "null";
}

public String test5()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2009-10-17T18:37:26Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
		
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trkseg))) ;
	else
		return "null";
}

public String test6()
{
	GPXtrkseg trkseg;
	GPXtrkpt trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:26Z"));
	GPXtrkpt trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-29T18:37:25Z"));
	GPXtrkpt trkpt3 = new GPXtrkpt(47.644548,-122.326897,4.46,GPXtime.createGPXtime("2000-02-28T18:37:26Z"));
	
	ArrayList trkpts = new ArrayList();
	trkpts.add(trkpt1);
	trkpts.add(trkpt2);
	trkpts.add(trkpt3);
	
	trkseg = new GPXtrkseg(trkpts);
	
	if (trkseg!=null)
		return (Long.toString(GPXcalculator.calculateElapsedTime(trkseg))) ;
	else
		return "null";
}

}