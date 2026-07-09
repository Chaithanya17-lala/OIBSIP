import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundCount = 0;
        System.out.println("=== WELCOME TO THE NUMBER GUESSING GAME ===");

        while (true) {
            roundCount++;
            System.out.println("\n--- Round " + roundCount + " ---");
            
            // 1. Difficulty Selection (Bonus Feature)
            System.out.println("Select Difficulty:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter choice (1-3): ");
            
            int choice = scanner.nextInt();
            int maxRange = 100;
            int maxAttempts = 7;
            
            if (choice == 1) {
                maxRange = 50;
                maxAttempts = 10;
            } else if (choice == 3) {
                maxRange = 200;
                maxAttempts = 5;
            } // Default is Medium (1-100, 7 attempts)

            // 2. System generates random number
            int targetNumber = random.nextInt(maxRange) + 1;
            int attemptsUsed = 0;
            boolean hasWon = false;

            System.out.println("\nI have chosen a number between 1 and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            // 3. Game Loop for Current Round
            while (attemptsUsed < maxAttempts) {
                attemptsUsed++;
                // Attempt counter visible to user
                System.out.print("\nAttempt " + attemptsUsed + "/" + maxAttempts + " -> Enter your guess: ");
                int userGuess = scanner.nextInt();

                // High/Low/Correct logic
                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You've guessed the number!");
                    hasWon = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("❌ Too High!");
                } else {
                    System.out.println("❌ Too Low!");
                }
            }

            // 4. Round Summary & Win/Loss Condition
            if (hasWon) {
                // Score tracking across multiple rounds summary
                System.out.println("🏆 Summary: Round " + roundCount + " — guessed in " + attemptsUsed + " attempts.");
            } else {
                System.out.println("\n💥 You Lost! You've run out of attempts.");
                System.out.println("The correct number was: " + targetNumber);
                System.out.println("🏆 Summary: Round " + roundCount + " — Failed to guess.");
            }

            // 5. Play Again Option
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            
            if (!playAgain.equals("yes") && !playAgain.equals("y")) {
                System.out.println("\nThank you for playing! Total rounds played: " + roundCount);
                break;
            }
        }
        
        scanner.close();
    }
}
