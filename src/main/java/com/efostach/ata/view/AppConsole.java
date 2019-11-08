package com.efostach.ata.view;

import com.efostach.ata.controller.exceptions.InvalidValueException;

import java.util.Scanner;

import static com.efostach.ata.controller.ControllerUtil.getIntegerValue;

public class AppConsole {

    private Scanner scanner = new Scanner(System.in);
    private FlightView fw = new FlightView();
    private RoutView rw = new RoutView();
    private TicketView tw = new TicketView();

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
                rw.showAllRouts();
                Integer routNumber = transferToIntegerValue();


                printChooseDateToFindTicketsMenu();
                String date = getFieldInputValue();
                Integer seatClass = transferToIntegerValue();
                fw.showDatesForRout(routNumber, date, seatClass);

                printChooseTicketToBuyMenu();
                Integer listNumber = transferToIntegerValue();

                printPutPersonalInfoToBuyTicketMenu();
                String firstName = getFieldInputValue();
                String lastName = getFieldInputValue();
                tw.buyTicket(listNumber, seatClass, firstName, lastName);
                run();
                break;
            }
            case "2": {
                printReturnTicketSubGeneralMenu();
                Integer ticketNumber = transferToIntegerValue();
                String lastName = getFieldInputValue();
                tw.returnTicket(ticketNumber, lastName);
                run();
                break;
            }
            case "0": {
                break;
            }
        }
    }

    private void printGeneralMenu() {
        System.out.println("\n1. Find Ticket");
        System.out.println("2. Return ticket");
        System.out.println("0. Exit \n");
    }

    private void printFindTicketsSubGeneralMenu() {
        System.out.println("\nEnter rout number");
    }

    private void printChooseDateToFindTicketsMenu() {
        System.out.println("\nEnter 'date' and 'seat class' (1 - Business, 2 - Economy)");
    }

    private void printChooseTicketToBuyMenu() {
        System.out.println("\nEnter number of the offered tickets");
    }

    private void printPutPersonalInfoToBuyTicketMenu() {
        System.out.println("\nEnter 'first name' and 'last name'");
    }

    private void printReturnTicketSubGeneralMenu() {
        System.out.println("\nEnter 'ticket number' and 'last name'");
    }

    private void printWrongSelection() {
        System.out.println("Oops, it's wrong value.\n");
    }

    private Integer transferToIntegerValue() {
        Integer input = null;
        do {
            try {
                input = getIntegerValue(scanner.nextLine());
            } catch (InvalidValueException ex) {
                ex.getMessage();
            }
        } while (input == null);
        return input;
    }

    private String getFieldInputValue() {
        String input;
        do {
            input = scanner.nextLine();
        } while (input.equals(""));
        return input;
    }
}
