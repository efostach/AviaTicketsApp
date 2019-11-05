package com.efostach.ata.service;

import com.efostach.ata.model.SeatClass;
import com.efostach.ata.model.Ticket;
import com.efostach.ata.model.TicketStatus;
import com.efostach.ata.repository.io.JavaIOTicketRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketService {

    private JavaIOTicketRepositoryImpl ioTicket = new JavaIOTicketRepositoryImpl();

    public Ticket buyTicket(Integer flightId, Integer seatClass, String firstName, String lastName) throws Exception {
        FlightService flightService = new FlightService();
        Ticket ticket = new Ticket();
        ticket.setFirstName(firstName);
        ticket.setLastName(lastName);
        ticket.setFlightId(flightId);
        if(seatClass == 1) {
            ticket.setSeatClass(SeatClass.BUSINESS);
        } else ticket.setSeatClass(SeatClass.ECONOMY);
        ticket.setSeatNumber(flightService.defineSeatNumber(flightId, seatClass));
        ticket.setStatus(TicketStatus.PURCHASED);
        Ticket createdTicket = ioTicket.create(ticket);
        if (createdTicket != null) {
            flightService.incrementSoldSeatsCount(flightId);
        }
        return ticket;
    }

    public Ticket returnTicket(Integer ticketNumber, String lastName) throws IOException {
        FlightService flightService = new FlightService();
        Ticket ticket = getTicketsByFilter(ticketNumber, lastName);
        if (ticket != null) {
            if (TicketStatus.PURCHASED.equals(ticket.getStatus())) {
                ticket.setStatus(TicketStatus.RETURNED);
            }
            ioTicket.update(ticket);
            flightService.decrementSoldSeatsCount(ticket.getFlightId());
        }
        return ticket;
    }

    List<Ticket> getTicketsByFilter(Integer flightId, SeatClass seatClass, TicketStatus status) throws FileNotFoundException {
        List<Ticket> tickets = ioTicket.getAll();
        List<Ticket> filteredTickets = new ArrayList<>();

        for (Ticket ticket : tickets) {
            if (flightId.equals(ticket.getFlightId())
                    && seatClass.equals(ticket.getSeatClass())
                    && status.equals(ticket.getStatus())) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }

    Ticket getTicketsByFilter(Integer ticketNumber, String lastName) throws FileNotFoundException {
        List<Ticket> tickets = ioTicket.getAll();
        Ticket foundTicket = null;

        for (Ticket ticket : tickets) {
            if (ticketNumber.equals(ticket.getTicketNumber()) && lastName.equals(ticket.getLastName())) {
                foundTicket = ticket;
            }
        }
        return foundTicket;
    }
}
