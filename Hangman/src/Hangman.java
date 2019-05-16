import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Random;

public class Hangman {

	public static void main(String[] args) {
		
		// Scanner to read user input
		Scanner scn = new Scanner(System.in);
		
		// Initialize Randomizer
		Random random = new Random();
		
		// Set Number of guesses
		int numOfGuesses = 20;
		
		// Array of strings for program to pick from for user to Guess
		String[] words = {"program", "drums", "keyboard", "pizza", "computer"};
		
		boolean weArePlaying = false;
		
		System.out.println("Do you want to play Hangman? (yes/no)");
		String wantToPlay = scn.nextLine().toLowerCase();
		
		if (wantToPlay.equals("yes")) {
			weArePlaying = true;
		} else {
			System.out.println("Maybe next time :(");
		}
			
		
		// Initialized during play to create runtime Variablesy
		while (weArePlaying) {
			System.out.println("Welcome to Hangman");
			
			// Convert a random word to a char array
			char[] randomWord = words[random.nextInt(words.length)].toCharArray();
			
			// Store players guesses
			char[] playGuesses = new char[randomWord.length];
			
			// Populate the array
			for (int i = 0; i < playGuesses.length; i++) {
				// Set '_' as each character in playGuesses array
				playGuesses[i] = '_';
				
			}
			
			boolean successfulGuess = false;
			int tries = 0;
			
			while (!successfulGuess && tries != numOfGuesses) {
				
				System.out.println("Current Guesses: ");
				printArray(playGuesses);
				
				System.out.printf("You have %d tries left. \n" , numOfGuesses - tries);
				
				System.out.println("Enter a single character: ");
				
				
				char input = scn.nextLine().charAt(0);
				
				System.out.println();
				tries++;
				
				if (input == '-') {
					weArePlaying = false;
					successfulGuess = true;
				} else {
					for (int i = 0; i < randomWord.length; i++) {
						if (randomWord[i] == input) {
							playGuesses[i] = input;
						}
					}
					
					if (isTheWordGuessed(playGuesses)) {
						successfulGuess = true;
						System.out.println("Congratulations! You Won!");
								
					}					
				}
			}
			
						
			if (!successfulGuess) System.out.println("You ran out of guesses.");
			System.out.println("Do you want to play another game? (Yes/No)");
			
			String anotherGame = scn.nextLine();
			
			if (anotherGame.equals("no")) {
				weArePlaying = false;
			}
		}
		System.out.println("Game Over");
		
			
			
// Test print of char
//			// Print out each char in random word
//			for (int i = 0; i<randomWord.length; i++) {
//				
//				System.out.println(randomWord[i]);
	}
	
	private static boolean isTheWordGuessed(char[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '_') {
				return false;
			}
		}
		return true;
	}

	public static void printArray(char[] array) {
		
		for (int i = 0; i < array.length; i++) {
			// Set '_' as each character in playGuesses array
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}


