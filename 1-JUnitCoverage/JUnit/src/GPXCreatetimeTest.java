import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class GPXCreatetimeTest {
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

	

    /*test createGPXtime*/

    @Test   //Today
    public void testCreateGPXtime1() {
	t = GPXtime.createGPXtime("2011-10-17T13:11:11Z");
	ExpectedTime = "2011-10-17T13:11:11Z";	
		assertEquals(ExpectedTime,t.year()+"-"+t.month()+"-"+t.day()+"T"+t.hour()+":"+t.minute()+":"+t.second()+"Z");
		
    }
    

	@Test   //random input string
	public void testCreateGPXtime2() {
		t = GPXtime.createGPXtime("#$@%^g2");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}

	@Test   //error days of February 
	public void testCreateGPXtime3() {
		t = GPXtime.createGPXtime("2011-02-30T01:01:01Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t.year()+"-"+t.month()+"-"+t.day()+"T"+t.hour()+":"+t.minute()+":"+t.second()+"Z");
	}	
	
	@Test   // year<1970
	public void testCreateGPXtime4() {
		t = GPXtime.createGPXtime("1969-11-17T11:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // month<1
	public void testCreateGPXtime5() {
		t = GPXtime.createGPXtime("1971-00-17T11:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // month>12
	public void testCreateGPXtime6() {
		t = GPXtime.createGPXtime("1971-13-17T11:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // day<1
	public void testCreateGPXtime7() {
		t = GPXtime.createGPXtime("1971-11-00T11:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // day>31
	public void testCreateGPXtime8() {
		t = GPXtime.createGPXtime("1971-11-32T11:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // hour<0
	public void testCreateGPXtime9() {
		t = GPXtime.createGPXtime("1971-11-17T-1:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // hour>23
	public void testCreateGPXtime10() {
		t = GPXtime.createGPXtime("1971-11-17T25:11:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // minute<0
	public void testCreateGPXtime11() {
		t = GPXtime.createGPXtime("1971-11-17T11:-1:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // minute>59
	public void testCreateGPXtime12() {
		t = GPXtime.createGPXtime("1971-11-17T11:61:11Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // second<0
	public void testCreateGPXtime13() {
		t = GPXtime.createGPXtime("1969-19-17T11:11:-1Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
	@Test   // second>59
	public void testCreateGPXtime14() {
		t = GPXtime.createGPXtime("1969-19-17T11:11:61Z");
		ExpectedTime = null ;		
		assertEquals(ExpectedTime,t);
	}
	
}