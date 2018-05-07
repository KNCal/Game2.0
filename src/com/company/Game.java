package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

  private int gameType;
  private Player player1;
  private Player player2;
  private int intMove1 = 0;
  private int intMove2 = 0;
  private int tie = 0;
  private boolean gameOver = false;


  public Game(int gameType, String name, String name2 ) {

      Scanner scanner = new Scanner(System.in);

      player1 = new Player(1, name);

      //determine player 2
      if (gameType == 1) {
        player2 = new Player(1, name2);
      }
      else {
        player2 = new Player(2, "Computer");
      }


//      while (!Player.isGameEnds()) {
      while (!gameOver) {

          intMove1 = player1.playerMove();
          gameOver = Player.isGameEnds();

          if (!gameOver) {
            intMove2 = player2.playerMove();
            gameOver = Player.isGameEnds();
            if (!gameOver) {

              //determine winner
              if (intMove1 == intMove2) {
                System.out.println("Tie");
                tie++;
              } else {
                if ((intMove1 == 2) || (intMove2 == 2)) {
                  if (intMove1 == 2) {
                    if (intMove2 == 0) {
                      player2.setWin(1);
                      System.out.println("Player 2 wins");
                    } else {
                      player1.setWin(1);
                      System.out.println("Player 1 wins");
                    }
                  } else {
                    if (intMove1 == 0) {
                      player1.setWin(1);
                      System.out.println("Player 1 wins");
                    } else {
                      player2.setWin(1);
                      System.out.println("Player 2 wins");
                    }
                  }
                } else {
                  if (intMove1 > intMove2) {
                    player1.setWin(1);
                    System.out.println("Player 1 wins");
                  } else {
                    player2.setWin(1);
                    System.out.println("Player 2 wins");
                  }
                }
              }
            }
          }
      }
    System.out.println(player1.getName() + ": " + player1.getWin());
    System.out.println(player2.getName() + ": " + player2.getWin());
    System.out.println("Tie: " + tie);

    //Write out to file, names, wins, dates
    //Open file

    //Write

    //Close file

  }
}
