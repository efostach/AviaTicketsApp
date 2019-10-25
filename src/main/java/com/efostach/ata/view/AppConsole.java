package com.efostach.ata.view;

import java.util.Scanner;

public class AppConsole {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        printGeneralMenu();

        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {
                printFindTicketsSubGeneralMenu();
                goToFindTicketsSubGeneralMenu();
                break;
            }
            case "2": {
                printReturnTicketSubGeneralMenu();
                goToReturnTicketSubGeneralMenu();
                break;
            }
            case "0": {
                break;
            }
        }
    }

    private void printGeneralMenu() {
        System.out.println("1. Find Ticket");
        System.out.println("2. Return ticket");
        System.out.println("0. Exit \n");
    }

    private void printFindTicketsSubGeneralMenu() {
        System.out.println("Enter FROM, TO, DATE, SEAT CLASS.");
        System.out.println("From/to:");
        System.out.println(" 1. LED");
        System.out.println(" 2. HND");
        System.out.println(" 3. MSQ");
        System.out.println(" 4. KBP");
        System.out.println("Seat classes:");
        System.out.println(" 5. BUSINESS CLASS");
        System.out.println(" 6. ECONOMY CLASS");
        System.out.println("0. Exit \n");
    }

    private void printСhooseTicketToBuySubGeneralMenu() {
        System.out.println("Enter TICKET NUMBER.");
        System.out.println("0. Exit \n");
    }

    private void printReturnTicketSubGeneralMenu() {
        System.out.println("Enter TICKET NUMBER and FAMILY NAME.");
        System.out.println("0. Exit \n");
    }

    private void goToFindTicketsSubGeneralMenu() {
        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {

                run();
                break;
            }
            case "0": {
                break;
            }
        }
    }

    private void goToReturnTicketSubGeneralMenu() {
        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {

                run();
                break;
            }
            case "0": {
                break;
            }
        }
    }

    private void printWrongSelection() {
        System.out.println("Oops, it's wrong value.\n");
    }
}
