package com.company;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main extends ColorPalette {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        mainMenu();
    }

    static void mainMenu() throws FileNotFoundException {
        // Main menu loop
        boolean exit = false;
        do {
            System.out.println("Welcome to Lingo!");
            System.out.printf("%sstart%s/%sexit\n", ANSI_GREEN, ANSI_RESET, ANSI_RED);
            String input = scanner.nextLine();

            if (input.equals("start")) {
                mainGameLoop();
            } else if (input.equals("exit")) {
                exit = true;
            }
        } while(!exit);
    }

    static void mainGameLoop() throws FileNotFoundException {
        // Main game loop
        Expression expression = new Expression();
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
