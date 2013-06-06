import java.util.ArrayList;
//import java.util.Set;
import java.util.TreeMap;


public class DataProcessor {
	
	protected static DataStore _dataStore;
	private static int wins = 0, losses = 0;
	protected static DataProcessor uniqueDataProcessor;
	protected static ArrayList<WorldSeriesInstance> list;
	
	protected DataProcessor(DataStore dataStore) {
		_dataStore = dataStore;
		 list= _dataStore.allWorldSeriesInstances();
	}
	
	public static DataProcessor getDataInstance(){
		if(uniqueDataProcessor==null){
			uniqueDataProcessor=new DataProcessor(null);
		}
		return uniqueDataProcessor;
		
	}
	
	

	public WorldSeriesInstance showDataForYear(int year) {
		logger.setType("DataProcessor");
		logger.log("showing data for year: " + year);
		
		WorldSeriesInstance wsi = getDataForYear(year);
		
		if (wsi != null) return wsi;
		// if we made it here, we didn't find it
		else return null;
		
	}
	
	private WorldSeriesInstance getDataForYear(int year) {
		logger.setType("DataProcessor");
		logger.log("getting data for year: " + year);
		
		// look through all the instances		

		for (WorldSeriesInstance wsi : list) {
			if (wsi.year() == year) {
				// found it!
				return wsi;
			}
		}
		
		// if we get here, we didn't find one for that year
		return null;
	}
	
	public String showDataForRange(int start, int end) {
		logger.setType("DataProcessor");
		logger.log("showing data for range: " + start + " to " + end);
		
		// make sure we have valid data
		if (end < start) {
			return "Invalid year range";
		}
				
		// look in the cache first
		if (_dataStore.lookup(start+"-"+end) != null) {
			return DataStore.resultsCache().get(start+"-"+end);
		}
		
		StringBuffer result = new StringBuffer();
		
		// this is a counter of how many we've added to the buffer
		int count = 0;
		
		for (int year = start; year <= end; year++) {
			WorldSeriesInstance wsi = getDataForYear(year);
			if (wsi != null) {
				result.append(wsi.toStringWinner());
				result.append("\n");
				count++;
			}
		}

		// if we didn't see any results, return that
		if (count == 0) {
			return "No World Series held between " + start + " and " + end;
		}
		else {
			DataStore.resultsCache().put(start+"-"+end, result.toString());
			return result.toString();
		}
		
	}


	public String showDataForTeamWins(String team) {
		logger.setType("DataProcessor");
		logger.log("showing wins for team: " + team);
		
		// look in the cache first
		if (_dataStore.lookup(team+"-wins") != null) {
			return DataStore.resultsCache().get(team+"-wins");
		}
		
		// to hold the result
		StringBuffer result = new StringBuffer();
	
		// keep track of the number of wins for the team
		wins = 0;	
		// look through all the instances		
		for (WorldSeriesInstance wsi : list) {
			// convert to uppercase and use "contains" for partial matching
			if (wsi.winner().toUpperCase().contains(team.toUpperCase())) {
				// we found an instance when the team won
				result.append(wsi.toStringWinner());
				result.append("\n");
				wins++;
			}
		}
		// if none found, print a message
		if (wins == 0) {
			result.append("The " + team + " have not won any World Series");
			result.append("\n");
		}
		else {
			result.append("The " + team + " have won " + wins + " World Series");
			result.append("\n");
		}
		
		// put it in the cache
		DataStore.resultsCache().put(team+"-wins", result.toString());

		return result.toString();
	}
	
	public String showDataForTeamLosses(String team) {
		logger.setType("DataProcessor");
		logger.log("showing losses for team: " + team);
		
		// look in the cache first
		if (_dataStore.lookup(team+"-losses") != null) {
			return DataStore.resultsCache().get(team+"-losses");
		}
		
		// to hold the result
		StringBuffer result = new StringBuffer();

		// keep track of the number of losses for the team
		losses = 0;
		// look through all the instances		
		for (WorldSeriesInstance wsi : list) {
			// convert to uppercase and use "contains" for partial matching
			if (wsi.loser().toUpperCase().contains(team.toUpperCase())) {
				result.append(wsi.toStringLoser());
				result.append("\n");
				losses++;
			}	
		}
		// if none found, print a message
		if (losses == 0) {
			result.append("The " + team + " have not lost any World Series");
			result.append("\n");
			}
		else {
			result.append("The " + team + " have lost " + losses + " World Series");
			result.append("\n");
		}

		// put it in the cache
		DataStore.resultsCache().put(team+"-losses", result.toString());
		
		return result.toString();

	}
			
	public String showDataForTeamAll(String team) {
		logger.setType("DataProcessor");
		logger.log("showing wins and losses for team: " + team);
		
		// look in the cache first
		if (_dataStore.lookup(team+"-all") != null) {
			return DataStore.resultsCache().get(team+"-all");
		}

		// to hold the result
		StringBuffer result = new StringBuffer();

		result.append(showDataForTeamWins(team));
		
		result.append(showDataForTeamLosses(team));
		// if none found, print a message
		if (wins + losses == 0) {
			result.append("The " + team + " have not played in any World Series");
			result.append("\n");
		}
		else {
			result.append("The " + team + " have won " + wins + " World Series and lost " + losses);
			result.append("\n");
		}
		
		// put it in the cache
		DataStore.resultsCache().put(team+"-all", result.toString());
		
		return result.toString();
		
	}
	
	
	protected TreeMap<String, ArrayList<Integer>> assembleWinnersByTeam(TreeMap<String, ArrayList<Integer>> winningTeams) {		
		logger.setType("UserInterface");
		logger.log("Trying to assemble winners by team");			

		winningTeams = new TreeMap<String, ArrayList<Integer>>();
		
		for (WorldSeriesInstance wsi : list) {

			// see if the winner is already in the list of teams
			if (winningTeams.containsKey(wsi.winner())) {
				winningTeams.get(wsi.winner()).add(wsi.year());
			}
			else {
				// create an entry in the wins list
				ArrayList<Integer> newEntry = new ArrayList<Integer>();
				newEntry.add(wsi.year());
				winningTeams.put(wsi.winner(), newEntry);
			}
		}
		return winningTeams;
				
	}
	
	
	
}
