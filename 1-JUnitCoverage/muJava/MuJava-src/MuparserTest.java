import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MuparserTest {
	private String filename = "D:\\p1.txt"; 
	private String filename_bad1 = "D:\\p2.txt";
	private String filename_bad2 = "D:\\p3.txt";
	private String filename_bad3 = "D:\\parser3.txt";
	private GPXobject result_object;

	private GPXlink link ;
	private GPXtime time ;
	private GPXtime time_trkpt1 ;
	private GPXtime time_trkpt2 ;
	private GPXmetadata metadata ;
	private GPXtrkpt trkpt1 ;
	private GPXtrkpt trkpt2 ;
	private GPXtrkseg trkseg ;
	private ArrayList trkpts ;
	private ArrayList trksegs;
	private GPXtrk trk;
	private GPXobject object;
	
	public String test1()
	{
		GPXparser parser=new GPXparser();			
		GPXformat format= new GPXformat();
		GPXchecker checker= new GPXchecker();	
		GPXobject o=new GPXobject(null, null);
		 o = parser.parse(filename_bad1, checker.checkFormat(filename_bad1));
		 return(o.toString());
	}
	
	public String test2()
	{
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename,checker.checkFormat(filename));
		 return(Double.toString(result_object.trk().trkseg(0).trkpt(1).lon()));
	}
	
	public String test3()
	{
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename_bad1,checker.checkFormat(filename_bad1));	
		 return(result_object.trk().toString());
	}
	
	public String test4()
	{
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename,checker.checkFormat(filename));
		 return(result_object.trk().toString());
	}
	
	public String test5()
	{
		GPXparser parser=new GPXparser();
		GPXchecker checker=new GPXchecker();
		result_object = parser.parse(filename_bad3,checker.checkFormat(filename_bad3));
		 return(result_object.trk().toString());
	}

}