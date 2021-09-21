package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FileReader {

    private static File file;
    private static int fileLength;

    public FileReader(String location) throws FileNotFoundException {
        // Imports file and checks if it exists
        file = new File(location);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        fileLength = getFileLength();
    }

    public char[] getRandomLine() throws FileNotFoundException {
        // Goes to random line in file
        Scanner fileScanner = new Scanner(file);
        int location = ThreadLocalRandom.current().nextInt(0, fileLength);
        for (int i = 0; i < location; i++) {
            fileScanner.nextLine();
        }

        // Puts string in array and returns array
        String input = fileScanner.nextLine();
        return Main.stringToCharArr(input);
    }

    private int getFileLength() throws FileNotFoundException {
        // Scans the length of the file
        Scanner fileScanner = new Scanner(file);
        int fileLength = 0;
        while (fileScanner.hasNextLine()) {
            fileLength++;
            fileScanner.nextLine();
        }
        return fileLength;
    }
}
