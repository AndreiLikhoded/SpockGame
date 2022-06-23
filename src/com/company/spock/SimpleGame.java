package com.company.spock;

import java.util.Random;
import java.util.Scanner;


public class SimpleGame {

    Players players;
    public static int userScore;
    public static int computerScore;
    public static int numberOfGames;

    public SimpleGame(Players players){
        this.players = players;
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public static void startSimpleGame(){
        Scanner scanner = new Scanner(System.in);
        Players computerMove = choose(new Random().nextInt(3) + 1);
        Players playerMove;
        while(true){
            System.out.println("Please enter 'r' for Rock, 's' for Scissors, 'p' for Paper");
            try {
                int userNumber = Integer.parseInt(scanner.nextLine());
                playerMove = choose(userNumber);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            if (playerMove.equals(Players1.ROCK)
                    || playerMove.equals(Players1.SCISSORS)
                    || playerMove.equals(Players1.PAPER)) {
                break;
            }
            System.out.println(playerMove + " is not a valid move.");
        }
        System.out.println("Computer played: " + computerMove);
        if (playerMove.equals(computerMove)) {
            System.out.println("The game was a tie!");
        } else if (playerMove.equals(Players1.ROCK)) {
            if (computerMove.equals(Players1.PAPER)) {
                System.out.println("Paper covers rock. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players1.SCISSORS)) {
                System.out.println("Rock crushes scissors. You win!");
                userScore++;
            }
        } else if (playerMove.equals(Players1.PAPER)) {
            if (computerMove.equals(Players1.ROCK)) {
                System.out.println("Paper covers rock. You win!");
                userScore++;
            } else if (computerMove.equals(Players1.SCISSORS)) {
                System.out.println("Scissors cuts paper. You lose!");
                computerScore++;
            }
        } else if (playerMove.equals(Players1.SCISSORS)) {
            if (computerMove.equals(Players1.PAPER)) {
                System.out.println("Scissors cuts paper. You win!");
                userScore++;
            } else if (computerMove.equals(Players1.ROCK)) {
                System.out.println("Rock crushes scissors. You lose!");
                computerScore++;
            }
        }

        String playAgain = scanner.nextLine();
        if (!playAgain.equals("y")) {
            startSimpleGame();
        } else {
            printGameStatistics();
        }
        scanner.close();
    }

    private static Players choose(int userNumber) {
        Players[] pl = Players.values();
        if (userNumber > 0 && userNumber < 6)
            return pl[userNumber - 1];

        throw new RuntimeException("players not found");
    }

    public static void printGameStatistics() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;


        System.out.print("+");
        printDashes(68);
        System.out.println("+");


        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "Win", "Lose", "tie", "sum of games", "% of wins");


        System.out.print("|");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(16);
        System.out.print("+");
        printDashes(18);
        System.out.println("|");


        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);


        System.out.print("+");
        printDashes(68);
        System.out.println("+");
    }

    private static void printDashes(int i) {
    }

}
