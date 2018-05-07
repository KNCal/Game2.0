package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String[] mainMenu = new String[] {"play","history","exit"};
    private static List mainMenuChoice = Arrays.asList(mainMenu);

    private static final String[] playerMenu = new String[] {"1","2","exit"};
    private static List playerMenuChoice = Arrays.asList(playerMenu);

    private static boolean validMenuInput;
    private static boolean validPlayerMenuInput;

    private static boolean returnToMain = false;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String gameType = "2"; //defaults to playing with computer
        System.out.println("\nWelcome to the Game of Rock, Paper, Scissors!");
        System.out.println("MAIN MENU");
        System.out.println("=====");

        do {
            if (returnToMain) {
                System.out.println("\n\nMAIN MENU");
                System.out.println("=====");
                returnToMain = false;
            }
            validMenuInput = false;
            System.out.println("\n1. Type 'play' to play");
            System.out.println("2. Type 'history' to view your game history");
            System.out.println("Type 'exit' to stop playing");
            String inputMenuChoice = scanner.nextLine().toLowerCase();

            try {
                validMenuInput = mainMenuChoice.contains(inputMenuChoice);
                if (!validMenuInput) {
                    System.out.println("Please enter valid input.");
                }
                else {
                    switch (inputMenuChoice) {
                        case "play":
                            do {
                                validPlayerMenuInput = false;
                                System.out.println("\nEnter:");
                                System.out.println("    1 - 2 players");
                                System.out.println("    2 - vs. Computer");
                                System.out.println("Type 'exit' to go back to main menu");
                                String inputPlayerChoice = scanner.nextLine();

                                try {
                                    validPlayerMenuInput = playerMenuChoice.contains(inputPlayerChoice);
                                    if (!validPlayerMenuInput) {
                                        System.out.println("Please enter valid input.");
                                    }
                                    else {
                                        if (!inputPlayerChoice.toLowerCase().equals("exit")) {
                                            System.out.println("Enter name of player:");
                                            String inputPlayerName = scanner.nextLine();

                                            if (inputPlayerChoice.equals("1")) {
                                                Player.setGameEnds(false);

                                                //Get name of 2nd player
                                                //Add exception handling
                                                System.out.println("Enter name of 2nd player:");
                                                String inputPlayerName2 = scanner.nextLine();
                                                Game game = new Game(1, inputPlayerName, inputPlayerName2);
                                            }
                                            else {
                                                Player.setGameEnds(false);
                                                Game game = new Game(2, inputPlayerName, "Computer");
                                            }
                                            if (Player.isGameEnds()) {
                                                returnToMain = true;
                                            }
                                        }
                                        else {
                                            returnToMain = true;
                                        }
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("Please enter valid input.");
                                }
                            } while (!validPlayerMenuInput);
                            break;

                        case "history":
                            // Display history
                            System.out.println("Display History");
                            validMenuInput = true;
                            returnToMain = true;
                            break;

                        case "exit":
                            System.out.println("Goodbye!");
                            System.exit(0);

                        default:
                            break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter valid input.");
            }
        } while (!validMenuInput || returnToMain);

    }
}


