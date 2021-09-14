package com.company;

public class Palette {
    static String[] names = {"BLACK", "RED", "GREEN", "YELLOW", "BLUE", "PURPLE", "CYAN", "WHITE"};
    static String[] ID = {"\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m",
                          "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"};

    static String color(String s) throws Exception {
        for (int i = 0; i < names.length; i++) {
            if (s.equals(names[i])) {
                return ID[i];
            }
        }
        throw new Exception("Invalid color ID");
    }

    static String reset(){
        return "\u001B[0m";
    }
}
