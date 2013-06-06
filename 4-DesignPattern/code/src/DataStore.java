import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataStore {
	
	private final String _fileName;
	protected ArrayList<WorldSeriesInstance> _list;
	protected static HashMap<String, String> _resultsCache;
	
	public DataStore(String fileName) {
		_fileName = fileName;
		_list = new ArrayList<WorldSeriesInstance>();
		_resultsCache = new HashMap<String, String>();
		loadFile();
	}
		
	public ArrayList<WorldSeriesInstance> allWorldSeriesInstances() { 
		return _list; 
	}
	
	public static HashMap<String, String> resultsCache(){
		if(_resultsCache == null)
				_resultsCache = new HashMap<String, String>();
		return _resultsCache; 
	}
	
	protected void loadFile() {
		logger.setType("DataStore");
		logger.log("populating ArrayList");
		try {
			Scanner in = new Scanner(new File(_fileName));
			// since it's a comma-separated file
			in.useDelimiter(",");
			
			// read each line of the file one at a time
			while (in.hasNext()) {
				
				// create a WorldSeriesInstance
				WorldSeriesInstance wsi = createWorldSeriesInstance(in);
				
				// add it to the ArrayList
				_list.add(wsi);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	protected WorldSeriesInstance createWorldSeriesInstance(Scanner in) {
		int year = in.nextInt();
		String winner = in.next();
		String score = in.next();
		String loser = in.nextLine();
		// the loser still has the leading comma attached, so get rid of it
		loser = loser.substring(1, loser.length());

		return new WorldSeriesInstance(year, winner, loser, score);
	}
	
	public String lookup(String key) {
		logger.setType("DataStore");
		logger.log("Looking in cache for key: " + key);
		if (_resultsCache.containsKey(key)) return _resultsCache.get(key); 
		else return null;
	}
	
}
