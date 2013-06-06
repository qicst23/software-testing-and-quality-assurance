import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {

	public static final String DATAFILE = "WorldSeries.csv";
	
	
	private static void showChoices(){		
		System.out.println("");
		System.out.println("Please make your selection:");
		System.out.println("1: Search for World Series info by year");
		System.out.println("2: Search for World Series info by team");
		System.out.println("3: Show all World Series for a range of years");
		System.out.println("4: Show all teams' World Series wins");
		System.out.println("Q: Quit");
		System.out.print("> ");			
	}
	
	private static void printByYear(Scanner in){
		System.out.print("Please enter the year: ");
		try {
			int year = in.nextInt();
			String yearData = showDataForYear(year);
			System.out.println(yearData);
		}
		catch (Exception e) { 
			System.out.println("That is not a valid year.");
		}		
	}
	
	private static void printByTeam(Scanner in){
		System.out.print("Please enter the team name: ");
		String team = in.nextLine();
		System.out.print("Do you want to see World Series the team has (W)on, (L)ost, or (A)ll? ");
		String winOrLose = in.next();
		String teamData = showDataForTeam(team, winOrLose);	
		System.out.println(teamData);
	}
	
	
	
	private static void printByRange(Scanner in){		
		int startYear=getInputYear(in, "start");
		if(startYear==-1)return;
		int endYear=getInputYear(in, "end");
		if(endYear==-1)return;		
		String yearData = showDataForRange(startYear, endYear);
		System.out.println(yearData);	
	}
	
	private static int getInputYear(Scanner in, String startOrEnd){
		int inputYear;
		System.out.print("Please enter the "+startOrEnd+"ing year: ");
		try {				
				inputYear = in.nextInt();			
		}
		catch (Exception e) { 
			System.out.println("That is not a valid year.");
			return -1;
		}
		return inputYear;
	}
	
	private static boolean notEqualToQ(String choice){
		return choice.equals("q") == false && choice.equals("Q") == false;
	}
	
	private static void printAllSeries(){
		String result = new Sorter().GetWinners();
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the World Series database!");		
		String choice = null; // the thing that the user chooses to do
		
		do {	
			showChoices();
			Scanner in = new Scanner(System.in);					
			choice=in.nextLine();	 // the thing that the user chooses to do		
			try {
				int choiceNum = Integer.parseInt(choice);
				//System.out.println(choiceNum);
				switch(choiceNum) {
				case 1: 
					// if they want to search by year
					printByYear(in);
					break;
				case 2:
					// search by team
					printByTeam(in);
					break;
				case 3:
					// for a range of years
					printByRange(in);
					break;					
				case 4:
					// show all the teams and the years they won a World Series
					printAllSeries();
					break;
				default:
					// they entered a number but not a valid one
					System.out.println("That is not a valid selection.");
				}
			}
			catch (NumberFormatException e) {
				// they didn't enter a number
				if (notEqualToQ(choice)) {
					System.out.println("That is not a valid selection.");
				}
			}
			
		}
		while (notEqualToQ(choice));
		System.out.println("Good bye");
	}

	
	protected static String showDataForYear(int year) {
		DataStore allData = new DataStore(DATAFILE);
		
		// look through all the instances
		ArrayList<WorldSeriesInstance> allIncidenceList = allData.allInstances();
		for (WorldSeriesInstance incidence : allIncidenceList) {
			if (incidence.year() == year) {
				// found it!
				return "In " + year + " the " + incidence.winner() + " defeated the " + incidence.loser() + " by " + incidence.score();
			}
		}
		
		// if we made it here, we didn't find it
		return "No World Series was held in " + year;
		
	}

	public static ArrayList<WorldSeriesInstance> GetList(){
		DataStore data = new DataStore(DATAFILE);
		
		return data.allInstances();
	}
	
	private static StringBuffer UpdateResult(StringBuffer result, WorldSeriesInstance instance) {
		result.append("In " + instance.year() + " the " + instance.winner() + " defeated the " + instance.loser() + " by " + instance.score());
		result.append("\n");
		
		return result;
	}
	
	private static String outputRange(StringBuffer result,int start, int end) {
		if (end < start) {
			return "Invalid year range";
		}	
		
		if (result.toString().equals("")) {
			return "No World Series held between " + start + " and " + end;
		}
		else {
			return result.toString();
		}
	}
	
	protected static String showDataForRange(int start, int end) {	
		ArrayList<WorldSeriesInstance> list = GetList();
		
		StringBuffer result = new StringBuffer();
		
		for (WorldSeriesInstance instance : list) {
			if (instance.year() >= start && instance.year() <= end) {	
				UpdateResult(result, instance);
			}
		}	
		
		return outputRange(result, start, end);	
	}
	protected static boolean containTeam(String choice, String searchCondition, WorldSeriesInstance incidence, String team){
    	boolean isContained = false;
    	if (searchCondition=="W")
    		isContained=(choice=="A"|| choice=="W") && incidence.winner().toUpperCase().contains(team.toUpperCase()); 	
    	else if(searchCondition=="L")
    		isContained=(choice=="A"|| choice=="L")  && incidence.loser().toUpperCase().contains(team.toUpperCase()); 	
    	return isContained;    	
    }
	
	protected static void appendGeneralInfo(StringBuffer result, String team, String wonOrLost, int numWon, int numLost){
		// Input "won" for won results, "lost" for lost results, and "played in" for all results.
		
		String gameInfo="won";  int numSelection=numWon;
		if (wonOrLost == "L")  {gameInfo="lost"; numSelection=numLost;}
		else if(wonOrLost=="A"){gameInfo="played in";}
		
		if (numWon+numLost == 0) {
			result.append("The " + team + " have not "+gameInfo+" any World Series");
			result.append("\n");
		}
		else { 
			if(wonOrLost=="A"){gameInfo="won";}			
			result.append("The " + team + " have " + gameInfo +" "+numSelection+ " World Series");
			if(wonOrLost=="A"){	result.append(" and lost "+numLost);}
			result.append("\n");
		}
	}		
	
	protected static void appendAllResults(DataStore allData, StringBuffer result,String choice,String team){
		int countWon = 0, countLoss=0;		
		// look through all the instances
		ArrayList<WorldSeriesInstance> allIncidenceList = allData.allInstances();
		for (WorldSeriesInstance incidence : allIncidenceList) {
			// convert to uppercase and use "contains" for partial matching
			if (containTeam(choice,"W",incidence,team)) {
				// we found an instance when the team won
				result.append("In " + incidence.year() + " the " + incidence.winner() + " defeated the " + incidence.loser() + " by " + incidence.score());
				result.append("\n");
				countWon++;
			}
			else if (containTeam(choice, "L",incidence,team)) {
				result.append("In " + incidence.year() + " the " + incidence.loser() + " lost to the " + incidence.winner() + " by " + incidence.score());
				result.append("\n");
				countLoss++;
			}
		}
		// if none found, print a message
		appendGeneralInfo(result,team,choice, countWon, countLoss);		
	}
	
	protected static String showDataForTeam(String team, String choice) {
		// load the data
		DataStore allData = new DataStore(DATAFILE);
		
		// to hold the result
		StringBuffer result = new StringBuffer();				
		
		if (choice.equalsIgnoreCase("W")) {
			appendAllResults(allData, result,"W", team);			
		}
		else if (choice.equalsIgnoreCase("L")) {
			appendAllResults(allData, result,"L", team);
		}
		else if (choice.equalsIgnoreCase("A")) {
			appendAllResults(allData, result,"A", team);
		}
		else {
			result.append("\"" + choice + "\" is not a valid entry.");
		}
		
		return result.toString();	
		
	}
	
}
