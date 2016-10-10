package thislab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int scores = 0;
		int score = 5;

		Scanner kb = new Scanner(System.in);

		TestScores[] scoreAmount = new TestScores[score];
		// create an array for the amout of scores
		for (int i = 0; i < scoreAmount.length ; i++) {
			System.out.print("Enter the number of scores. ");
			scores = kb.nextInt();
			// promts the user to enter the number of scores and then sets them
			// to kb
			double[] scoreArray = new double[scores];
			// creates a dou array to hold all of the scores
			for (int b = 0; b < scores; b++) {
				System.out.println("Enter a test score. " + (i + 1));
				scoreArray[b] = kb.nextDouble();
				// prompts the user to enter the score for each grade and sets
				// it to equal kb
				kb.nextLine();
				// conusmes a line
			}

			scoreAmount[i] = new TestScores(scoreArray);
		}
		FileOutputStream outStream = new FileOutputStream("Scores.dat");
		ObjectOutputStream objOut = new ObjectOutputStream(outStream);
		// creats a file named dcores.dat

		for (int a = 0; a < scoreAmount.length; a++) {
			objOut.writeObject(scoreAmount[a]);
			// prints the array value of a to the scores file

		}
		objOut.close();
		// close the file
		
		FileInputStream in = new FileInputStream("Scores.dat");
		ObjectInputStream objIn = new ObjectInputStream(in);
		// reads the file scores.dat
		TestScores[] score2 = new TestScores[scoreAmount.length];
		for (int i = 0; i < score2.length; i++) {

			score2[i] = (TestScores) objIn.readObject();

		}
		objIn.close();

		for (int i = 0; i < score2.length; i++) {

			System.out.println("Score " + (i + 1));
			System.out.println(score2[i]);

		}
	}

}
