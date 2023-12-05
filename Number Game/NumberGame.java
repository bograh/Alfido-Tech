import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            int difficultyChoice = 0;

            System.out.println("****************************");
            System.out.println("WELCOME TO NUMBER GUESS GAME");
            System.out.println("****************************");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("4. Exit\n");

            try {
                System.out.print("Select difficulty level or 4 to Exit: ");
                difficultyChoice = scan.nextInt();

                switch (difficultyChoice) {
                    case 1:
                        easyDifficulty();
                        break;
                    case 2:
                        mediumDifficulty();
                        break;
                    case 3:
                        hardDifficulty();
                        break;
                    case 4:
                        System.out.println("\nExiting....\nThanks for playing!!");
                        break;
                    default:
                        System.out.println("Input choice not found!! Try Again");
                        System.out.print("Select difficulty level: ");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\n**Invalid input type, Please try again**");
            }
        }

    }

    private static void easyDifficulty() {
        int lowerBound = 1, upperBound = 10;
        gameLogic(lowerBound, upperBound);
    }

    private static void mediumDifficulty() {
        int lowerBound = 1, upperBound = 25;
        gameLogic(lowerBound, upperBound);

    }

    private static void hardDifficulty() {
        int lowerBound = 1, upperBound = 100;
        gameLogic(lowerBound, upperBound);
    }

    private static void gameLogic(int lowerBound, int upperBound) {
        Random random = new Random();
        int randomNumber = random.nextInt(lowerBound, upperBound + 1);
        int guess;
        int numberOfAttempts = 5;

        try (Scanner input = new Scanner(System.in)) {

            try {
                System.out.println("Guess a number between " + lowerBound + " and " + upperBound + "(inclusive):");

                for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
                    System.out.print("> ");
                    guess = input.nextInt();
                    if (guess < randomNumber) {

                        // If maximum attempts reached end program
                        if (attempt == numberOfAttempts) {
                            System.out.println("Sorry, you've reached maximum number of attempts.");
                            System.out.println("The correct number was " + randomNumber);
                            break;
                        }

                        if (guess < lowerBound || guess > upperBound) {
                            System.out.println("Sorry, your guess must be between " + lowerBound + " and " + upperBound
                                    + "(inclusive)");
                            continue;
                        }

                        System.out.println("Incorrect! Your guess is Too Low, Guess Again");
                        continue;

                    } else if (guess > randomNumber) {

                        // If maximum attempts reached end program
                        if (attempt == numberOfAttempts) {
                            System.out.println("Sorry, you've reached maximum number of attempts.");
                            System.out.println("The correct number was " + randomNumber);
                            break;
                        }

                        if (guess < lowerBound || guess > upperBound) {
                            System.out.println("Sorry, your guess must be between " + lowerBound + " and " + upperBound
                                    + "(inclusive)");
                            continue;
                        }

                        System.out.println("Incorrect! Your guess is Too High, Guess Again");
                        continue;

                    } else {
                        System.out
                                .println("Congratulations!! You guessed the number '" + randomNumber + "' correctly in "
                                        + attempt + " attempts!!");
                        break;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("\n**Guess should be an integer number!**");
            }
        }
    }
}
