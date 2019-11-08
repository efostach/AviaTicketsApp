package com.efostach.ata.view;

import com.efostach.ata.controller.TicketController;
import com.efostach.ata.model.Ticket;

import java.io.IOException;

class TicketView {

    private TicketController ticketController = new TicketController();

    void buyTicket(Integer flightId, Integer seatClass, String firstName, String lastName) {
        try {
            printTicket(ticketController.buyTicket(flightId, seatClass, firstName, lastName));
        } catch (Exception e) {
            System.out.println("Something goes wrong. Please, try again.");
        }
    }

    void returnTicket(Integer ticketNumber, String lastName) {
        try {
            printTicket(ticketController.returnTicket(ticketNumber, lastName));
        } catch (IOException e) {
            System.out.println("Something goes wrong. Please, try again.");
        }
    }

    private void printTicket(Ticket ticket){
        System.out.println("Ticket Number: " + ticket.getTicketNumber()
                + "\tFirst Name: " + ticket.getFirstName()
                + "\tLast Name: " + ticket.getLastName()
                + "\tSeat: " + ticket.getSeatNumber()
                + "\tClass: " + ticket.getSeatClass()
                + "\tStatus: " + ticket.getStatus()
                + "\tPrice: " + ticket.getPrice() + "$");
    }
}