package lastpencil;

import java.util.Scanner;

public class Main {
    private static int amountOfPencils;
    private static Scanner scanner = new Scanner(System.in);
    private static String john = "John";
    private static String jack = "Jack";
    private static String johnsTurn = "John's turn!";
    private static String jacksTurn = "Jack's turn:";
    private static String startingPlayer;
    private static boolean hasViableAmountOfPencils = false;
    private static boolean hasViableStartingPlayer = false;

    public static void main(String[] args) {

        howManyPencils();
        whoGoesFirst();
        printPencils();
        if (startingPlayer.equals(jack)) {
            botTurn();
            printPencils();
        }
        while (true) {
            playerTurn();
            printPencils();
            botTurn();
            printPencils();
        }

    }

    private static void howManyPencils() {
        System.out.println("How many pencils would you like to use:");
        while (!hasViableAmountOfPencils) {
            try {
                amountOfPencils = Integer.parseInt(scanner.nextLine());
                if (amountOfPencils > 0) {
                    hasViableAmountOfPencils = true;
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    private static void whoGoesFirst() {
        System.out.println("Who will be the first (" + john + ", " + jack + "):");
        while (!hasViableStartingPlayer) {
            startingPlayer = scanner.nextLine();
            if (startingPlayer.equals(john)) {
                startingPlayer = john;
                hasViableStartingPlayer = true;
            } else if (startingPlayer.equals(jack)) {
                startingPlayer = jack;
                hasViableStartingPlayer = true;
            } else {
                System.out.println("Choose between '" + john + "' and '" + jack + "'");
            }
        }
    }

    private static void printPencils() {
        for (int i = 0; i < amountOfPencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    private static void playerTurn() {
        System.out.println(johnsTurn);
        while (true) {
            int input = 0;
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 1 || input > 3) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (amountOfPencils - input < 0) {
                    System.out.println("Too many pencils were taken");
                } else {
                    amountOfPencils -= input;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Possible values: '1', '2' or '3'");
            }

        }
        if (amountOfPencils == 0) {
            System.out.println(jack + " won!");
            System.exit(0);
        }
    }

    private static void botTurn() {
        System.out.println(jacksTurn);
        if (amountOfPencils > 3 && amountOfPencils % 4 == 0) {
            amountOfPencils -= 3;
            System.out.println("3");
        } else if (amountOfPencils > 2 && amountOfPencils % 2 == 1) {
            amountOfPencils -= 2;
            System.out.println("2");
        } else if (amountOfPencils > 1) {
            amountOfPencils -= 1;
            System.out.println("1");
        } else if (amountOfPencils == 1) {
            System.out.println("1");
            System.out.println(john + " won!");
            System.exit(0);
        }
    }
}