import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class GPXConverttimeTest {
	protected GPXtime t;
	protected String ExpectedTime;
	protected long ExpectedConvertTime; 	
	
	@Before
	public void setUp() throws Exception {
		t = new GPXtime(0, 0, 0, 0, 0, 0, "GPX");
	}
	
	@After
	 public void TearDown() throws Exception {
	   t = null;
	 }
	
	/*test convertToJavaTime*/
	@Test    //A day later 
	public void testconvertToJavaTime1() {
		t = GPXtime.createGPXtime("1970-01-02T00:00:00Z");
		if (t!=null){
			ExpectedConvertTime = 24*60*60*1000 ;
			assertEquals(ExpectedConvertTime,t.convertToJavaTime());
	        }		
	}
	
	
	
	@Test   //consider 1972 leap year
	public void testconvertToJavaTime2() {
		t = GPXtime.createGPXtime("1973-01-01T00:00:00Z");
		if (t!=null){
			ExpectedConvertTime = (365+365+366)*24*60*60*1000 ;
			assertEquals(ExpectedConvertTime,t.convertToJavaTime());
	        }		
	}
	
	@Test   //consider 2000 leap year
	public void testconvertToJavaTime3() {
		t = GPXtime.createGPXtime("2000-01-01T00:00:00Z");
		if (t!=null){
			ExpectedConvertTime = (365+365+366)*24*60*60*1000 ;
			assertEquals(ExpectedConvertTime,t.convertToJavaTime());
	        }		
	}
	
	@Test   //The same day. (day should minus 1)
	public void testconvertToJavaTime4() {
		t = GPXtime.createGPXtime("1970-01-01T00:00:00Z");
		if (t!=null){
			ExpectedConvertTime = 0 ;
			assertEquals(ExpectedConvertTime,t.convertToJavaTime());
	        }		
	}
	

	@Test   //return input string
	public void testconvertToJavaTime5() {
		t = new GPXtime(0, 0, 0, 0, 0, 0, "GPX");
		String ExpectedString = "GPX";
		if (t!=null){			
			assertEquals(ExpectedString,t.toString());
	        }		
	}
	
	
	
	@Test   //invalid time to create/ should return null
	public void testconvertToJavaTime6() {
		t = GPXtime.createGPXtime("1970-02-29T00:00:00Z");
		if(t!=null){
		   ExpectedConvertTime =0 ;
			assertEquals(ExpectedConvertTime,t.convertToJavaTime());
		}
		else
			System.out.println(t);
	 }		
	

	@Test   //before Java time
	public void testconvertToJavaTime7() {
		t = GPXtime.createGPXtime("1969-02-22T00:00:00Z");
		if(t!=null){
		   ExpectedConvertTime =0 ;
			assertEquals(ExpectedConvertTime,t.convertToJavaTime());
		}
		else
			assertEquals(null, t);
	 }		
	
}