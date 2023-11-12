package com.EricNorrwing.Autobattler.input;

import java.util.Scanner;

public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int getNextInt() {
        int result;
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number! Please enter a new number:");
            scanner.next();
        }

        result = scanner.nextInt();
        return result;
    }

}
