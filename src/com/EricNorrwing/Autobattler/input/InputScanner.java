package com.EricNorrwing.Autobattler.input;

import java.util.Scanner;

public class InputScanner {
    Scanner scanner = new Scanner(System.in);

    public int getNextInt() {
        System.out.println("Please enter a number");
        int result;
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number! Please enter a new number:");
            scanner.next();
        }

        result = scanner.nextInt();
        return result;
    }
    public int choseAction() {
        int result;
        System.out.println("Choose Benny's action...");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number! Please try again (Values accepted 1-4)");
                scanner.next(); // Consume the invalid input
            }
            result = scanner.nextInt();

            if (result < 1 || result > 4) {
                System.out.println("That's not a valid number! Please try again (Values accepted 1-4)");
            }
        } while (result < 1 || result > 4);

        return result;
    }
    public String getYesNo() {
        String result;
        do {
            result = scanner.next().toLowerCase();
            if (!(result.equals("y") || result.equals("n"))) {
                System.out.println("That's not Y/N. Please enter a correct input.");
            }
        } while (!(result.equals("y") || result.equals("n")));

        return result;
    }

}
