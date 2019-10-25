package com.efostach.ata.controller;

import com.efostach.ata.model.TicketClass;
import com.efostach.ata.repository.io.JavaIOTicketRepositoryImpl;

public class TicketController {

    private JavaIOTicketRepositoryImpl ioTicket = new JavaIOTicketRepositoryImpl();

    public void findTicketByFilter(String from, String to, String date, TicketClass classType) {
        //ioTicket.getAll();
    }

    public void buyTicket(String from, String to, String date, TicketClass classType, String seatNumber) {
        //ioTicket.create(new Ticket());
    }

    public void returnTicket(Integer ticketNumber, String LastName) {

    }

    private void findTicketByNumber() {

    }
}
