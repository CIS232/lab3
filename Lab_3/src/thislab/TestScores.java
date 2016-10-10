package thislab;

import java.io.Serializable;
import java.util.Scanner;

public class TestScores implements Serializable{

	private double[] validScore;

	public TestScores(double[] scores) throws IllegalArgumentException {
		// creates a double array of scores
		validScore = new double[scores.length];
		//sets valid score = to the length of scores array
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < 0 || scores[i] > 100) {
				//checks that the value of i is less then 100 and greater then 0
				throw new IllegalArgumentException("The scores must be between 0 and 100. ");
				// throws an illegal argumnet ecxeption 
			} else {
				validScore[i] = scores[i];
				//sets the array value to scores array value
			}
		}

	}

	


	public double getAverage() {
		double sum = 0;
		for (int i = 0; i < validScore.length; i++)
			sum += validScore[i];
		return (sum / validScore.length);
	}
	
	public String toString(){
		return "average; "+getAverage();
	}
}