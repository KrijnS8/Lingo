package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.File;
import java.io.FileNotFoundException;

public class Main extends ColorPalette {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        mainMenu();
    }

    static void mainMenu() throws FileNotFoundException {
        // Main menu loop
        boolean exit = false;
        do {
            System.out.println("Welcome to Lingo!");
            System.out.println(ANSI_GREEN + "start" + ANSI_RESET + "/" + ANSI_RED + "exit" + ANSI_RESET);
            String input = scanner.nextLine();

            if (input.equals("start")) {
                mainGameLoop();
                exit = true;
            } else if (input.equals("exit")) {
                exit = true;
            }
        } while(!exit);
    }

    static void mainGameLoop() throws FileNotFoundException {
        Expression expression = new Expression();
        System.out.println(expression.getValue());
        // Main game loop
        boolean exit = false;
        do {
            System.out.println(expression.evaluate());
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                exit = true;
            } else {
                expression.update(input);
            }
        } while(!exit);
    }
}
