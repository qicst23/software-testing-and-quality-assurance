import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStore {	
	private final String _fileName;
	private ArrayList<WorldSeriesInstance> _list;
	
	public DataStore(String fileName) {
		_fileName = fileName;
		_list = new ArrayList<WorldSeriesInstance>();
		readDataFile();
	}
	
	public ArrayList<WorldSeriesInstance> allInstances() { return _list; }
	
	private String GetLoser(Scanner in) {
		String loser;
		loser = in.nextLine();
		loser = loser.substring(1, loser.length());
		return loser;
	}
	
	private WorldSeriesInstance ReturnInstance(Scanner in) {
		int year;
		String winner, loser, score;
		
		year = in.nextInt();
		winner = in.next();
		score = in.next();
		loser = GetLoser(in);	
		
		WorldSeriesInstance instance = new WorldSeriesInstance(year, winner, loser, score);
		
		return instance;
	}
	
	protected void readDataFile() {	
		try {
			Scanner in = new Scanner(new File(_fileName));
			in.useDelimiter(",");
			
			while (in.hasNext()) {
				_list.add(ReturnInstance(in));
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
		}	
	}
	}
	
