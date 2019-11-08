package com.efostach.ata.controller;

import com.efostach.ata.model.*;
import com.efostach.ata.service.TicketService;

import java.io.IOException;


public class TicketController {

    private TicketService ticketService = new TicketService();

    public Ticket buyTicket(Integer flightId, Integer seatClass, String firstName, String lastName) throws Exception {
        return ticketService.buyTicket(flightId, seatClass, firstName, lastName);
    }

    public Ticket returnTicket(Integer ticketNumber, String lastName) throws IOException {
        return ticketService.returnTicket(ticketNumber, lastName);
    }
}
