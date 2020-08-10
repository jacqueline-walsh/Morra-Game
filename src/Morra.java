import java.util.Random;

public class Morra {

    private Random rand = new Random();

    // declare variables
    private int computer;
    private int userGuess;
    private int computerWin;
    private int userWin;
    private int totalRound;
    private int computerScore = 0;
    private int userScore = 0;
    private int computerCount;
    private int userGuessCount;
    private int userEven;
    private int userOdd;
    private int compEven;
    private int compOdd;
    private int userBonus;
    private int compBonus;
    private String bonus;
    private String oddOrEven;
    private String winner;

    // ******************* input *******************
    // sets the users choice for odd or even
    public void setOddOrEven(String oddOrEven) {
        this.oddOrEven = oddOrEven;
    }

    // sets the users number entered
    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
        if (userGuess % 2 == 0) {
            userEven++;
        } else {
            userOdd++;
        }
    }

    // ******************* process *******************
    public void compute() {
        // computer picks random number between 1 and 10
        computer = rand.nextInt(10) + 1;

        if (computer % 2 == 0) {
            compEven++;
        } else {
            compOdd++;
        }

        // add scores together
        totalRound = computer + userGuess;

        // call calculate winner of the round method
        calculateRound();

        // call closest player to the total method
        closestPlayer();
    } // end of compute method

    // calculate winner of the round
    public void calculateRound() {

        if (totalRound % 2 == 0 && oddOrEven.equalsIgnoreCase("even") ||
                totalRound % 2 == 1 && oddOrEven.equalsIgnoreCase("odd")) {
            userScore = 2;
            computerScore = 0;
            userGuessCount += 2;
            userWin++;
            winner = "Total round is " + totalRound + " Congratulations! you win this round.";

        } else if (totalRound % 2 == 1 && oddOrEven.equalsIgnoreCase("even") ||
                totalRound % 2 == 0 && oddOrEven.equalsIgnoreCase("odd")) {
            userScore = 0;
            computerScore = 2;
            computerCount += 2;
            computerWin++;
            winner = "Total round is " + totalRound + " Sorry! computer won this round.";
        }
    } // end of method

    // closest play to round total
    public void closestPlayer() {

        if ((totalRound - computer) > (totalRound - userGuess)) {
            userScore += 1;
            userGuessCount++;
            userBonus++;
            bonus = "Your guess was nearest to the total, 1 point awarded.";

        } else if ((totalRound - userGuess) > (totalRound - computer)) {
            computerScore += 1;
            computerCount++;
            compBonus++;
            bonus = "Computers guess was nearest to the total 1 points awarded.";
        } else if (computer == userGuess) {
            bonus = "No bonus points given this round as both players are equal.";
        }
    } // end of method


    // ******************* output *******************

    // getter / accessor Methods
    public String getWinner() {
        return winner;
    }

    public int getComputerWin() {
        return computerWin;
    }

    public int getUserWin() {
        return userWin;
    }

    public int getComputer() { return computer; }

    public int getUserGuess() {
        return userGuess;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getComputerCount() {
        return computerCount;
    }

    public int getUserGuessCount() {
        return userGuessCount;
    }

    public String getBonus() {
        return bonus;
    }

    public int getUserEvens() {
        return userEven;
    }

    public int getUserOdds() {
        return userOdd;
    }

    public int getCompEvens() {
        return compEven;
    }

    public int getCompOdds() {
        return compOdd;
    }

    public int getUserBonus() {
        return userBonus;
    }

    public int getCompBonus() {
        return compBonus;
    }
}  // end of class