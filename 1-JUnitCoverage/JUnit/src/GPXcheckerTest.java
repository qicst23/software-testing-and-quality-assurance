import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class GPXcheckerTest {
	
	protected GPXchecker checker = new GPXchecker();
	protected GPXformat result = new GPXformat();
	protected String fileName1 = "D\\1.txt";      //original valid file
	protected String fileName2 = "D\\2.txt";      //if triple <trkseg>
	protected String fileName3 = "D\\3.txt";      //if more than one hrf
	protected String fileName4 = "D\\4.txt";      //if first longitude than latitude
	protected String fileName5 = "D\\5.txt";      //if without name
	protected String fileName6 = "D\\6.txt";      
	protected String fileName7 = "D\\7.txt";      
	protected String fileName8 = "D\\8.txt";      
	protected String fileName9 = "D\\9.txt";      
	protected String fileName10 = "D\\10.txt";      
	protected String fileName11 = "D\\11.txt";     
	protected String fileName12 = "D\\12.txt";      
	protected String fileName13 = "D\\13.txt";     
	protected String fileName14 = "D\\14.txt";    
	protected String fileName15 = "D\\15.txt";  
	protected String fileName16 = "D\\16.txt";  
	protected String fileName17 = "D\\17.txt";  
	protected String fileName18 = "D\\18.txt";  
	protected String fileName19 = "D\\19.txt";  
	protected String fileName20 = "D\\20.txt";  
	protected String fileName21 = "D\\21.txt";  
	protected String fileName22 = "D\\22.txt";  
	protected String fileName23 = "D\\23.txt";  
	protected String fileName24 = "D\\24.txt";  
	protected String fileName25 = "D\\25.txt";  
	protected String fileName26 = "D\\26.txt";  
	
	
	
	
	
	@Test
	public final void testGPXchecker1() {		
		result = checker.checkFormat(fileName1) ;
		assertEquals(true,result.isValid()) ;		
	}
	
	
	@Test
	public final void testGPXchecker2() {		
		result = checker.checkFormat(fileName2) ;
		assertEquals(true,result.isValid()) ;
	}
	

	@Test
	public final void testGPXchecker3() {		
		result = checker.checkFormat(fileName3) ;
		assertEquals(false,result.isValid()) ;
	}
	

	@Test
	public final void testGPXchecker4() {		
		result = checker.checkFormat(fileName4) ;
		assertEquals(false,result.isValid()) ;
	}
	

	@Test   //if without name
	public final void testGPXchecker5() {		
		result = checker.checkFormat(fileName5) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test   //if irregular words
	public final void testGPXchecker6() {		
		result = checker.checkFormat(fileName6) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test   //doesn't start with "<"
	public final void testGPXchecker7() {		
		result = checker.checkFormat(fileName7) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't start with <gpx>
	public final void testGPXchecker8() {		
		result = checker.checkFormat(fileName8) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test   //doesn't arrives <link
	public final void testGPXchecker9() {		
		result = checker.checkFormat(fileName9) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives <text
	public final void testGPXchecker10() {		
		result = checker.checkFormat(fileName10) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </text
	public final void testGPXchecker11() {		
		result = checker.checkFormat(fileName11) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </link
	public final void testGPXchecker12() {		
		result = checker.checkFormat(fileName12) ;
		assertEquals(false,result.isValid()) ;
	}

	@Test    //doesn't arrives <time 
	public final void testGPXchecker13() {		
		result = checker.checkFormat(fileName13) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </time
	public final void testGPXchecker14() {		
		result = checker.checkFormat(fileName14) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </metadata
	public final void testGPXchecker15() {		
		result = checker.checkFormat(fileName15) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't contains metadata, and doesn't arrives </trk
	public final void testGPXchecker16() {		
		result = checker.checkFormat(fileName16) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </name
	public final void testGPXchecker17() {		
		result = checker.checkFormat(fileName17) ;
		assertEquals(false,result.isValid()) ;
	}
	@Test    //doesn't arrives <trkseg
	public final void testGPXchecker18() {		
		result = checker.checkFormat(fileName18) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives <trkpt
	public final void testGPXchecker19() {		
		result = checker.checkFormat(fileName19) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives <ele
	public final void testGPXchecker20() {		
		result = checker.checkFormat(fileName20) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </ele
	public final void testGPXchecker21() {		
		result = checker.checkFormat(fileName21) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives <time
	public final void testGPXchecker22() {		
		result = checker.checkFormat(fileName22) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </time
	public final void testGPXchecker23() {		
		result = checker.checkFormat(fileName23) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </trkpt
	public final void testGPXchecker24() {		
		result = checker.checkFormat(fileName24) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //contains no trkpt, doesn't arrives </trk
	public final void testGPXchecker25() {		
		result = checker.checkFormat(fileName25) ;
		assertEquals(false,result.isValid()) ;
	}
	
	@Test    //doesn't arrives </gpx
	public final void testGPXchecker26() {		
		result = checker.checkFormat(fileName26) ;
		assertEquals(false,result.isValid()) ;
	}
	
	



}
