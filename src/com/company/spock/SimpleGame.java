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
        Players computerMove = choose(new Random().nextInt(5) + 1);
        while(true){

        }
    }

    String playAgain = scanner.nextLine();
            if (!playAgain.equals("y")) {
        startSimpleGame();
    } else {
        printSimpleGameStatistics();
    }

    private static Players choose(int userNumber) {
        Players[] pl = Players.values();
        if (userNumber > 0 && userNumber < 6)
            return pl[userNumber - 1];

        throw new RuntimeException("players not found");
    }

    public static void printSimpleGameStatistics() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;


        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "Win", "Lose", "tie", "sum of games", "% of wins");


        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);

    }

}
