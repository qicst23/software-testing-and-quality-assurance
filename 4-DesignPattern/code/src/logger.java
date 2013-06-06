import java.io.File;
import java.io.FileWriter;


public class logger {
	protected static String _type = null;
	
	public static void setType(String type){
		_type = type;
	}
	
	public static void log(String event) {
		try {
			FileWriter writer = new FileWriter(new File("log.txt"), true);
			writer.write(System.currentTimeMillis() + " (" +  _type + ")" + ": " + event +"\n");
			writer.flush();
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
}
