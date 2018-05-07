package com.company;

import java.util.*;

public class Player {

  private int win;
  private int currentMove; //1=Rock, 2=Paper, 3=Scissors
  private int playerType;
  private boolean validInput = false;
  private String name;

  public static boolean isGameEnds() {
    return gameEnds;
  }

  public static void setGameEnds(boolean gameEnds) {
    Player.gameEnds = gameEnds;
  }

  public static boolean gameEnds = false;
  private String inputMove = "";

  enum Move {
    rock, paper, scissors, exit
  };

  static List moves = Arrays.asList(Move.values());

  public int getWin() {
    return win;
  }

  public void setWin(int win) {
    this.win = win++;
  }

  public String getName() {
    return name;
  }

  public Player(int playerType, String name) {
    this.win = 0;
    this.currentMove = 0;
    this.playerType = playerType;
    this.name = name;
  }


  public int playerMove() {

    if (this.playerType == 1) {
      Scanner scanner = new Scanner(System.in);
      do {

        if (!gameEnds) {
          System.out.println("\nType in 'rock', 'paper' or 'scissors' or 'exit' to exit: ");
          try {
            inputMove = scanner.nextLine();
            Move move = Move.valueOf(inputMove.toLowerCase());


            if (inputMove.equals("exit")) {
              System.out.println("Goodbye!");
              gameEnds = true;
            } else {
              this.currentMove = move.ordinal();
            }

            try {
              validInput = moves.contains(move);
            } catch (NullPointerException e) {
              System.out.println("Please enter valid input.");
            }
          } catch (IllegalArgumentException e) {
            System.out.println("Please enter valid input.");
            validInput = false;
          }
        }
      } while (!validInput);
    }
    else {
      if (!gameEnds) {
        Random rand = new Random();
        this.currentMove = rand.nextInt(3);
        System.out.println("computer: " + this.currentMove);
      }
    }

    return this.currentMove;
  }
}
