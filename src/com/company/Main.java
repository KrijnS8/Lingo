package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
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
        mainMenu();
    }

    static void mainMenu() throws FileNotFoundException{
        // Main menu loop
        boolean exit = false;
        do {
            System.out.println("Welcome to Lingo!");
            System.out.println(ANSI_GREEN + "start" + ANSI_RESET + "/" + ANSI_RED + "exit" + ANSI_RESET);
            String input = scanner.nextLine();

            if (input.equals("start")) {
                mainGameLoop(getRandomLineFile("English.txt"));
                exit = true;
            } else if (input.equals("exit")) {
                exit = true;
            }
        } while(!exit);
    }

    static void mainGameLoop(char[] arr){
        // Creates color array and defines colors
        String[] colors = new String[arr.length];
        colors[0] = ANSI_RED;
        for (int i = 1; i < colors.length; i++) {
            colors[i] = ANSI_RESET;
        }

        // Creates display array and defines chars
        char[] displayArr = new char[arr.length];
        displayArr[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            displayArr[i] = '_';
        }

        // Main game loop
        boolean exit = false;
        do {
            System.out.println(evaluate(displayArr, colors));
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                exit = true;
            }
        } while(!exit);
    }

    static String evaluate(char[] chars, String[] colors) {
        // Combine chars and colors to one string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            output.append(colors[i]).append(chars[i]);
        }
        return output.toString();
    }

    static char[] getRandomLineFile(String s) throws FileNotFoundException {
        // Imports file and checks if it exists
        File file = new File(s);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        // Scans the length of the file
        Scanner fileScanner = new Scanner(file);
        int fileLength = 0;
        while (fileScanner.hasNextLine()) {
            fileLength++;
            fileScanner.nextLine();
        }

        // Goes to random line in file
        fileScanner = new Scanner(file);
        int location = ThreadLocalRandom.current().nextInt(0, fileLength);
        for (int i = 0; i < location; i++) {
            fileScanner.nextLine();
        }

        // Puts line in array and returns array
        String input = fileScanner.nextLine();
        char[] arr = new char[input.length()];
        for(int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }
        return arr;
    }
}
