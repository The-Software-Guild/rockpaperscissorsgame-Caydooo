package com.scissorspaperrock;

import java.util.Random;
import java.util.Scanner;

enum Choice {
	SCISSORS,
	PAPER,
	ROCK;
}

public class ScissorsPaperRockGame {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		boolean playAgain = false;
		
		while(!playAgain) {
			int computerOption = 0;
			int userOption = 0;
			int rounds = 0;
			
			int userScore = 0;
			int computerScore = 0;
			int roundTies = 0;
			System.out.println("Let's play Scissors, Paper, Rock!");
			
			
			while(true) {
				System.out.print("Choose a number of rounds (min. 1, max. 10): ");
				rounds = Integer.parseInt(scanner.nextLine());
				if(rounds > 0 && rounds < 11) {
					System.out.println("Great, let's play!");
					break;
				}
				System.out.println("This isn't a valid amount! Quitting...");
				System.exit(0);
			}
			
			
			do {
				while(true) {
					System.out.println("\nChoose an option:");
					System.out.println("1. Rock");
					System.out.println("2. Paper");
					System.out.println("3. Scissors");
					System.out.println("\nYour opponent is waiting...");
					userOption = Integer.parseInt(scanner.nextLine());
					if(userOption > 0 && userOption < 4) {
						break;
					}
					System.out.println("That's not an option!");
				}
				
				computerOption = rand.nextInt(3)+1;
				
				//Rock = 1
				//Paper = 2
				//Scissors = 3
				
				if (userOption == 1 && computerOption == 2) {
					System.out.println("\nComputer picked Paper!");
					System.out.println("Rock is wrapped by Paper. Computer wins!");
					computerScore++;
				} else if (userOption == 1 && computerOption == 3) {
					System.out.println("\nComputer picked Scissors!");
					System.out.println("Rock breaks Scissors. User wins!");
					userScore++;
				} else if (userOption == 2 && computerOption == 1) {
					System.out.println("\nComputer picked Rock!");
					System.out.println("Paper wraps Rock. User wins!");
					userScore++;
				} else if (userOption == 2 && computerOption == 3) {
					System.out.println("\nComputer picked Scissors!");
					System.out.println("Paper is cut by Scissors. Computer wins!");
					computerScore++;
				} else if (userOption == 3 && computerOption == 1) {
					System.out.println("\nComputer picked Rock!");
					System.out.println("Scissors break against Rock. Computer wins!");
					computerScore++;
				} else if (userOption == 3 && computerOption == 2) {
					System.out.println("\nComputer picked Paper!");
					System.out.println("Scissors cuts Paper. User wins!");
					userScore++;
				} else {
					System.out.println("This is a tie!");
					roundTies++;
				}
				rounds--;
			} while (rounds > 0);
			
			System.out.println("\nThe final tally is...");
			System.out.println("User score: " + userScore);
			System.out.println("Computer score: " + computerScore);
			System.out.println("Ties: " + roundTies);
			
			if(userScore > computerScore) {
				System.out.println("The user is the winner!");
			} else if (userScore < computerScore) {
				System.out.println("The computer is the winner!");
			} else {
				System.out.println("The game was a tie!");
			}
			
			System.out.println("\nWould you like to play again?");
			while(true) {
				String response = scanner.nextLine();
				if(response.equalsIgnoreCase("Yes")) {
					break;
				} else if (response.equalsIgnoreCase("No")) {
					System.out.println("Thanks for playing!");
					playAgain = true;
					break;
				} else {
					System.out.println("That's not a valid response!");
				}
			}
		}
	}
}
