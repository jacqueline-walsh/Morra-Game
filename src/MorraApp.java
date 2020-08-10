import java.util.Scanner;

public class MorraApp {

    // declare and create arrays
    private static String[] history = new String[10];
    private static String[] allTimeHistoryArray = new String[50];

    public static void main(String[] args) {

        // declare variables
        String oddOrEven;
        String playAgain = "";
        boolean flag = false;
        int userNumber;
        int round = 1;
        int totalGames = 1;

        // declare objects
        Morra myMorra;
        Scanner scan = new Scanner(System.in);

        // ******************* input *******************
        do {
            // instantiate new object
            myMorra = new Morra();

            // resets scores if user wants to play again
            if (playAgain.equalsIgnoreCase("yes")) {
                flag = false;
                totalGames++;
                round = 1;
                // assigns null value to history array
                for (int i = 0; i < history.length; i++) {
                    history[i] = null;
                }
            }
                do {
                    // user inputs odd / even and input validated
                    System.out.println("Would you like to be odd or even player?");
                    oddOrEven = scan.next();
                    if (oddOrEven.equalsIgnoreCase("odd") || oddOrEven.equalsIgnoreCase("even")) {
                        myMorra.setOddOrEven(oddOrEven);
                    } else {
                        System.out.println("You entered incorrectly!");
                        continue;
                    }
                    // user inputs number between 1-10 and input validated
                    System.out.println("Please enter a number between 1-10");
                    userNumber = scan.nextInt();

                    if (userNumber > 0 && userNumber <= 10) {
                        myMorra.setUserGuess(userNumber);
                    } else {
                        System.out.println("You entered incorrectly!");
                        continue;
                    }
                    // ******************* process *******************

                    // calls the compute method from the Morra class
                    myMorra.compute();

                    // ******************* output *******************
                    // output results of round
                    System.out.println("The computer chose " + myMorra.getComputer() + " you chose " +
                            myMorra.getUserGuess() + " " + myMorra.getWinner());
                    System.out.println(myMorra.getBonus());
                    System.out.println("Computer scored: " + myMorra.getComputerScore());
                    System.out.println("You scored: " + myMorra.getUserScore());

                    // store round scores in the array
                    String roundText = "\nRound " + round + ":\t" +
                            myMorra.getComputer() + "\t\t" +
                            myMorra.getUserGuess();
                    history[round-1] = roundText;

                    // check to see winner of game.  Winner is the first to 6 points
                    if (myMorra.getComputerCount() == 6 && myMorra.getUserGuessCount() == 6) {
                        System.out.println("\nIt is a draw!\n");
                        flag = true;
                        // calls the printHistory method
                        printHistory();
                    } else if ((myMorra.getUserGuessCount() > 6 && myMorra.getComputerCount() <= 6)  ||
                            myMorra.getUserGuessCount() == 6 && myMorra.getComputerCount() < 6) {
                        System.out.println("\nCongratulations! You won the game\n");
                        flag = true;
                        // calls the printHistory method
                        printHistory();
                    } else if (myMorra.getComputerCount() > 6 && myMorra.getUserGuessCount() <= 6 ||
                            myMorra.getComputerCount() == 6 && myMorra.getUserGuessCount() < 6) {
                        System.out.println("\nBetter luck next time! The computer wins the game\n");
                        flag = true;
                        // calls the printHistory method
                        printHistory();
                    }
                    round++;
                } while (flag == false);

                // store history of scores in variable gameHistoryText
                String gameHistoryText = "\nGame " + totalGames +
                        "\n***************************\nWon: " +
                        myMorra.getUserWin() + " Rounds \nLost: " +
                        myMorra.getComputerWin() + " Rounds \nYourScore: " +
                        myMorra.getUserGuessCount() + "\nComputer Score" +
                        myMorra.getComputerCount() + "\nYou chose " +
                        myMorra.getUserEvens() + " even and " +
                        myMorra.getUserOdds() + " odd numbers " +
                        "\nYou scored " + myMorra.getUserBonus() +
                        " bonus points this game\nComputer scored " +
                        myMorra.getCompBonus() + " bonus points this game" +
                        "\n***************************\n";

                // adds gameHistoryText to array
                allTimeHistoryArray[totalGames - 1] = gameHistoryText;

                // ask user if they want to play the game again
                System.out.println("Would you like to play again?  Yes/No");
                playAgain = scan.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        // call printAllTimeHistory method
        printAllTimeHistory();

        // closes the Scanner class to avoid leakage
        scan.close();
    }  // end main method

    // output of round scores for the game
    public static void printHistory() {
        System.out.println("\tComp Guess\tYour Guess");
        for (String s : history) {
            if (s == null) {
                break;
            } else {
                System.out.println(s);
            }
        }
    }
    // outputs the final results of all the games played
    public static void printAllTimeHistory() {
        for (String s: allTimeHistoryArray) {
            if (s == null) {
                break;
            } else {
                System.out.println(s);
            }
        } // end for loop
    } // end method
} // end class
