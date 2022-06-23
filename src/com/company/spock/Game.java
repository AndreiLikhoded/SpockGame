package com.company.spock;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Players players;
    public static int userScore;
    public static int computerScore;
    public static int numberOfGames;

    public Game(Players players) {
        this.players = players;
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        Players computerMove = choose(new Random().nextInt(5) + 1);

        Players playerMove;

        while (true) {
            System.out.println("Please enter 'r' for Rock, 's' for Scissors, 'p' for Paper, 'l' for Lizard, 's' for Spock");
            try {
                int userNumber = Integer.parseInt(scanner.nextLine());
                playerMove = choose(userNumber);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            if (playerMove.equals(Players.ROCK)
                    || playerMove.equals(Players.SCISSORS)
                    || playerMove.equals(Players.PAPER)
                    || playerMove.equals(Players.LIZARD)
                    || playerMove.equals(Players.SPOCK)) {
                break;
            }
            System.out.println(playerMove + " is not a valid move.");
        }
        System.out.println("Computer played: " + computerMove);
        if (playerMove.equals(computerMove)) {
            System.out.println("The game was a tie!");
        } else if (playerMove.equals(Players.ROCK)) {
            if (computerMove.equals(Players.PAPER)) {
                System.out.println("Paper covers rock. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.SCISSORS)) {
                System.out.println("Rock crushes scissors. You win!");
                userScore++;
            } else if (computerMove.equals(Players.LIZARD)) {
                System.out.println("Rock crushes lizard. You win!");
                userScore++;
            } else if (computerMove.equals(Players.SPOCK)) {
                System.out.println("Spock vaporizes rock. You lose!");
                computerScore++;
            }
        } else if (playerMove.equals(Players.PAPER)) {
            if (computerMove.equals(Players.ROCK)) {
                System.out.println("Paper covers rock. You win!");
                userScore++;
            } else if (computerMove.equals(Players.SCISSORS)) {
                System.out.println("Scissors cuts paper. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.LIZARD)) {
                System.out.println("Lizard eats paper. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.SPOCK)) {
                System.out.println("Paper disproves Spock. You win!");
                userScore++;
            }
        } else if (playerMove.equals(Players.SCISSORS)) {
            if (computerMove.equals(Players.PAPER)) {
                System.out.println("Scissors cuts paper. You win!");
                userScore++;
            } else if (computerMove.equals(Players.ROCK)) {
                System.out.println("Rock crushes scissors. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.LIZARD)) {
                System.out.println("Scissors decapitates lizard. You win!");
                userScore++;
            } else if (computerMove.equals(Players.SPOCK)) {
                System.out.println("Spock smashes scissors. You lose!");
                computerScore++;
            }
        } else if (playerMove.equals(Players.LIZARD)) {
            if (computerMove.equals(Players.PAPER)) {
                System.out.println("Lizard eats paper. You win!");
                userScore++;
            } else if (computerMove.equals(Players.ROCK)) {
                System.out.println("Rock smashes lizard. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.SCISSORS)) {
                System.out.println("Scissors decapitates lizard. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.SPOCK)) {
                System.out.println("Lizard poisons Spock. You win!");
                userScore++;
            }
        } else if (playerMove.equals(Players.SPOCK)) {
            if (computerMove.equals(Players.PAPER)) {
                System.out.println("Paper disproves Spock. You lose!");
                computerScore++;
            } else if (computerMove.equals(Players.ROCK)) {
                System.out.println("Spock vaporizes Spock. You win!");
                userScore++;
            } else if (computerMove.equals(Players.SCISSORS)) {
                System.out.println("Spock smashes scissors. You win!");
                userScore++;
            } else if (computerMove.equals(Players.LIZARD)) {
                System.out.println("Lizard poisons Spock. You lose!");
                computerScore++;
            }
        }

        String playAgain = scanner2.nextLine();
        if (!playAgain.equals("y")) {
            startGame();
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

    public static void chooseGame(){
        
    }
}
