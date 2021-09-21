package com.company;

import java.io.FileNotFoundException;

public class Expression {

    private static String value;
    private static final String languageFile = "English.txt";

    public Expression() throws FileNotFoundException {
        FileReader fileReader = new FileReader(languageFile);

    }
}
