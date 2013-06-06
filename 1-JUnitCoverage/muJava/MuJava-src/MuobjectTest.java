import java.util.ArrayList;

public class MuobjectTest {
	private GPXlink link ;
	private GPXtime time ;
	private GPXtime time_trkpt1 ;
	private GPXtime time_trkpt2 ;
	private GPXmetadata metadata ;
	private GPXtrkpt trkpt1 ;
	private GPXtrkpt trkpt2 ;
	private GPXtrkseg trkseg ; private GPXtrkseg trkseg2 ;
	private ArrayList trkpts ; private ArrayList trkpts2 ;
	private ArrayList trksegs; private ArrayList trksegs2;
	private GPXtrk trk;
	private GPXobject object;	
	

public String test1()
{
	link = new GPXlink("http://www.garmin.com","Garmin International");  //construct an object
	  time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
	  metadata = new GPXmetadata(link,time) ; 
	  time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
	  trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
	  time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
	  trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
	  trkpts = new ArrayList<GPXtrkpt>();
	  trkpts.add(trkpt1);
	  trkpts.add(trkpt2);
	  trkseg = new GPXtrkseg(trkpts);
	  trksegs = new ArrayList<GPXtrkseg>();
	  trksegs.add(trkseg);
	  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
	  object = new GPXobject(metadata,trk); 
	  return(object.toString());
}

public String test2()
{
	metadata = null;
	  time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
	  trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
	  time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
	  trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
	  trkpts = new ArrayList<GPXtrkpt>();
	  trkpts.add(trkpt1);
	  trkpts.add(trkpt2);
	  trkseg = new GPXtrkseg(trkpts);
	  trksegs = new ArrayList<GPXtrkseg>();
	  trksegs.add(trkseg);
	  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
	  object = new GPXobject(metadata,trk); 
	  return(object.toString());
}

public String test3()
{
	link = new GPXlink("http://www.garmin.com","Garmin International");  //construct an object
	  time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
	  metadata = new GPXmetadata(link,time) ; 		 
	  trksegs = null;		 
	  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
	  object = new GPXobject(metadata,trk);  
	  return(object.toString());
}

public String test4()
{
	link = new GPXlink("http://www.garmin.com","Garmin International");  //construct an object		 	  
	  trkpts = new ArrayList<GPXtrkpt>();
	  trkpts.add(null);		
	  trkseg = new GPXtrkseg(trkpts);
	  trksegs = new ArrayList<GPXtrkseg>();
	  trksegs.add(trkseg);
	  trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
	  object = new GPXobject(metadata,trk); 
	  return(object.toString());
}

public String test5()
{
	link = new GPXlink("http://www.garmin.com","Garmin International");   //construct an object
    time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
    metadata = new GPXmetadata(link,time) ; 
    time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
    trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
    time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
    trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
    trkpts = new ArrayList<GPXtrkpt>();
    trkpts.add(trkpt1);
    trkpts.add(trkpt2);
    trkseg = new GPXtrkseg(trkpts);
    trksegs = new ArrayList<GPXtrkseg>();
    trksegs.add(trkseg);
    trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
    object = new GPXobject(metadata,trk); 
	  return(object.toString());
}

public String test6()
{
	link = new GPXlink("http://www.garmin.com","Garmin International");   //construct an object
    time = GPXtime.createGPXtime("2009-10-17T22:58:43Z");
    metadata = new GPXmetadata(link,time) ; 
    
    time_trkpt1 = GPXtime.createGPXtime("2009-10-17T18:37:31Z") ;
    trkpt1 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt1);
    trkpts= new ArrayList<GPXtrkpt>();
    trkpts.add(trkpt1);
    trkseg = new GPXtrkseg(trkpts);
    
    time_trkpt2 = GPXtime.createGPXtime("2009-10-17T18:37:26Z") ;
    trkpt2 = new GPXtrkpt(47.644548,-122.326897,4.46,time_trkpt2);
    trkpts2= new ArrayList<GPXtrkpt>();
    trkpts2.add(trkpt2);
    trkseg2 = new GPXtrkseg(trkpts2);
    
    trksegs= new ArrayList<GPXtrkseg>();
    trksegs.add(trkseg);
    trksegs.add(trkseg2);		    
    
    trk = new GPXtrk("Walking up a hill.Straight up!",trksegs);
    object = new GPXobject(metadata,trk);  
	  return(object.toString());
}
}