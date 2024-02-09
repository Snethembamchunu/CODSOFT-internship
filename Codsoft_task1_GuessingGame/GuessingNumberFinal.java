package Codsoft_task1_GuessingGame;
import java.util.Scanner;

public class GuessingNumberFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min =   1;
        int max =   100;
        int maxAttempts;
        int attempts =   0;
        int totalScore =   0; // Total score across all rounds
        String playAgain;

        // Main game loop, allowing the user to play multiple rounds
        do {
            // Determine difficulty level and set max attempts accordingly
            System.out.println("Select a difficulty level:");
            System.out.println("1. Easy (15 attempts)");
            System.out.println("2. Medium (10 attempts)");
            System.out.println("3. Hard (5 attempts)");
            int level = scanner.nextInt();
            switch (level) {
                case   1:
                    maxAttempts =   15;
                    break;
                case   2:
                    maxAttempts =   10;
                    break;
                default:
                    maxAttempts =   5;
                    break;
            }
            
            // Generate a new random number for each round
            int randomNumber = (int)(Math.random() * (max - min +   1)) + min;

            // Inner loop for guessing the number
            while (attempts < maxAttempts) {
                System.out.printf("Enter your guess between %d and %d: ", min, max);
                int userGuess = scanner.nextInt();
                attempts++;

                // Validate user input
                if (userGuess < min || userGuess > max) {
                    System.out.println("Invalid entry. Please enter a number between " + min + " and " + max + ".");
                    attempts--; // Decrement attempts since the input was not valid
                    continue;
                }

                // Show remaining attempts
                System.out.printf("You have %d attempts left.\n", maxAttempts - attempts);

                // Check if the guess is correct
                if (userGuess == randomNumber) {
                    totalScore += attempts; // Add to total score
                    System.out.println("Correct! The number was " + randomNumber + ". Your score for this round is " + attempts + ".");
                    break; // Exit inner loop upon correct guess
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // If the user didn't guess the number within the max attempts
            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + randomNumber + ".");
            }

            // Ask the user if they want to play again
            System.out.println("Your total score so far is: " + totalScore);
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next().toLowerCase();

            // Reset attempts for the next round
            attempts =   0;

            // Quit the game if the user types "quit"
            if ("quit".equals(playAgain)) {
                break;
            }
        } while ("yes".equals(playAgain));

        // Close the scanner
        scanner.close();

        // Goodbye message
        System.out.println("Thanks for playing! Final score: " + totalScore);
    }
}
