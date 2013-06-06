import java.util.ArrayList;


public class Sorter {

	private ArrayList<String> _teamNames = new ArrayList<String>();
	private ArrayList<ArrayList<Integer>> _winYears = new ArrayList<ArrayList<Integer>>();

	private void NewNameOrNot(WorldSeriesInstance instance) {
		int teamsIndex = _teamNames.indexOf(instance.winner());
		
		if (teamsIndex == -1) {
			_teamNames.add(instance.winner());
			
			ArrayList<Integer> winYear = new ArrayList<Integer>();
			winYear.add(instance.year());
			_winYears.add(winYear);
		}
		else {
			_winYears.get(teamsIndex).add(instance.year());
		}
	}
	
	private boolean CompareNames(int index, String min) {
		return (_teamNames.get(index).compareTo(min) < 0);
	}
	
	private void SwapNames(int index, String min,int minIndex) {
		String tempName = _teamNames.get(index);
		_teamNames.set(index, min);
		_teamNames.set(minIndex, tempName);
	}
	
	private void SwapYears(int index, String min,int minIndex) {
		ArrayList<Integer> tempYears = _winYears.get(index);
		_winYears.set(index, _winYears.get(minIndex));
		_winYears.set(minIndex, tempYears);
	}
	
	private void sortData()	{
		String min;
		int minIndex;
		
		for (int i = 0; i < _teamNames.size(); i++) {
			min = _teamNames.get(i);
			minIndex = i;
			for (int j = i; j < _teamNames.size(); j++) {
				if (CompareNames(j, min)) {
					min = _teamNames.get(j);
					minIndex = j;
				}
			}		
			
			SwapNames(i, min, minIndex);
			
			SwapYears(i, min, minIndex);		
		}
	}
	
	private StringBuffer outputYears(StringBuffer result, int index) {
		ArrayList<Integer> winYear = _winYears.get(index);	
		
		for (int j = 0; j < winYear.size(); j++) {
			result.append(winYear.get(j));
			if (j < winYear.size()-1) result.append(", ");
		}
		result.append("\n");	
		
		return result;
	}
	
	private String output() {
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < _teamNames.size(); i++) {
			result.append(_teamNames.get(i) + ": ");		
			outputYears(result, i);
		}	
		
		return result.toString();
	}
	
	public String GetWinners() {	
		ArrayList<WorldSeriesInstance> list = new UserInterface().GetList();
		
		for (WorldSeriesInstance instance : list) {
			NewNameOrNot(instance);
		}
		
		sortData();
		
		return output();		
	}
}
