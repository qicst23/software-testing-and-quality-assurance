import java.util.ArrayList;


public class DataStoreHelper extends DataStore {

	public DataStoreHelper(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<WorldSeriesInstance> getList(){
		return _list;
	}	
	
}
