
public class DelayPredictor {
	
	
	/**
	 * Implements something like k-nearest neighbors (http://en.wikipedia.org/wiki/K-nearest_neighbor_algorithm)
	 * to predict the delay for this flight, based on the current weather and past records.
	 * It looks through the records and finds the three flights that are most like this one,
	 * in terms of whether it was windy, rainy, or cloudy. This is done by creating a score
	 * for each one, based on how many of the conditions it has in common (the score will therefore
	 * range from 0 to 3). It keeps track of the three highest scores, and then uses the average delay of those
	 * three flights to calculate the predicted delay. Note, however, that it will not consider
	 * any flights that are opposite to it in terms of windy, rainy, or cloudy (i.e., where score is 0, 
	 * so it may only consider one or two others (instead of three). If there are no other flights like it, then
	 * it will return 0.
	 */
	
	public static int predict(FlightRecord[] records, boolean windy, boolean rainy, boolean cloudy) {

		// hold the top three scores seen so far
		int topScores[] = {0, 0, 0};
		// hold the corresponding delays for the records with those top scores
		int delays[] = {0, 0, 0};

		// loop through all the records
		for (int i = 0; i < records.length; i++) {
			
			// the record we're considering
			FlightRecord record = records[i];
			
			// its score (how close it is to our current conditions)
			int score = 0;
			
			// increment the score if the conditions were the same
			if (windy && record.windy()) {
				score++;
			}
			else if (!windy && !record.windy()) {
				score++;
			}
			if (rainy && record.rainy()) {
				score++;
			}
			else if (!rainy && !record.rainy()) {
				score++;
			}
			if (cloudy && record.cloudy()) {
				score++;
			}
			else if (!cloudy && !record.cloudy()) {
				score++;
			}
			
			// if the score is still zero, then don't bother with this one		
			if (score != 0) {
				
				// see if it's bigger than any of the three scores, and update the arrays
				int minScore=topScores[0];	
				int minIndex=0;
				for (int k=1; k<3; k++){
					if(topScores[k]<minScore){
						minScore=topScores[k];
						minIndex=k;
					}
				}
				if(score>topScores[minIndex]){
					topScores[minIndex]=score;
					delays[minIndex]=record.delay(); 
				}		
		     }
	    }
		
		// now look at the delays and calculate their average		
		int sumDelay=0;
		int numNonZero=0;
		int expectedDelay=0;		
		for(int j=0; j<3; j++){
			if(topScores[j]!=0){
				numNonZero++;
				sumDelay=sumDelay + delays[j];
			}
		}		
		if (numNonZero!=0){
			expectedDelay = sumDelay/numNonZero;
		}	
			
		return expectedDelay;
		
	}
	

}
