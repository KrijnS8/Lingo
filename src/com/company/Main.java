package com.company;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //mainMenu();
        System.out.println(getRandomLineFile("English.txt"));
    }

    static void mainMenu() {
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

    static void mainGameLoop() {
        boolean exit = false;
        do {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                exit = true;
            }
        } while(!exit);
    }

    static String getRandomLineFile(String s) throws FileNotFoundException {
        Random r = new Random();
        File file = new File(s);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        Scanner fileScanner = new Scanner(file);
        for (int i = 0; i < r.nextInt((int) file.length()); i++) {
            fileScanner.nextLine();
        }
        return fileScanner.nextLine();
    }
}
