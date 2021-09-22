package com.company;

import java.io.FileNotFoundException;

public class Expression extends ColorPalette {

    private static String value;
    private static String displayValue = "";
    private static final String LANGUAGE_FILE = "English.txt";
    private static String[] colors;

    public Expression() throws FileNotFoundException {
        FileReader fileReader = new FileReader(LANGUAGE_FILE);
        value = fileReader.getRandomLine();
        displayValue = value.charAt(0) + new String(new char[value.length() - 1]).replace("\0", "_");

        colors = new String[value.length()];
        colors[0] = ANSI_RED;
        for (int i = 1; i < colors.length; i++) {
            colors[i] = ANSI_RESET;
        }
    }

    public String evaluate() {
        // Add colors to string and returns it
        char[] chars = stringToCharArr(displayValue);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            output.append(colors[i]).append(chars[i]);
        }
        return output.toString();
    }

    public void update(String input) {
        // Checks if input is correct length
        if (input.length() != value.length()) {
            System.out.printf("%sInput value has invalid length", ANSI_RESET);
            return;
        }

        // Updates colors
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            if (value.indexOf(input.charAt(i)) < 0) {
                colors[i] = ANSI_RESET;
            }
            if (value.indexOf(input.charAt(i)) > 0) {
                colors[i] = ANSI_YELLOW;
            }
            if (input.charAt(i) == value.charAt(i)) {
                colors[i] = ANSI_RED;
            }
        }
        displayValue = input;
    }

    public String getValue() {
        return value;
    }

    private char[] stringToCharArr(String s) {
        // Turns string to char array
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = Character.toUpperCase(s.charAt(i));
        }
        return arr;
    }
}
