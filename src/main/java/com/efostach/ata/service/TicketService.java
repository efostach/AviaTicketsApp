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
    private static Integer BUSINESS_BASE_PRICE = 900;
    private static Integer ECONOMY_BASE_PRICE = 300;

    public Ticket buyTicket(Integer flightId, Integer seatClass, String firstName, String lastName) throws Exception {
        FlightService flightService = new FlightService();
        SeatClass classType = SeatClass.ECONOMY;

        if(seatClass == 1)
            classType = SeatClass.BUSINESS;

        Ticket ticket = Ticket.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setFlightId(flightId)
                .setSeatNumber(flightService.defineSeatNumber(flightId, seatClass))
                .setSeatClass(classType)
                .setStatus(TicketStatus.PURCHASED)
                .setPrice(defineTicketPrice(flightId,classType))
                .build();

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
        final List<Ticket> filteredTickets = new ArrayList<>();

        tickets.parallelStream().forEach((ticket) -> {
            if (flightId.equals(ticket.getFlightId())
                    && seatClass.equals(ticket.getSeatClass())
                    && status.equals(ticket.getStatus())) {
                filteredTickets.add(ticket);
            }
        });
        return filteredTickets;
    }

    Ticket getTicketsByFilter(Integer ticketNumber, String lastName) throws FileNotFoundException {
        List<Ticket> tickets = ioTicket.getAll();
        final Ticket[] foundTicket = {null};

        tickets.parallelStream().forEach((ticket) -> {
            if (ticketNumber.equals(ticket.getTicketNumber()) && lastName.equals(ticket.getLastName())) {
               foundTicket[0] = ticket;
            }
        });
        return foundTicket[0];
    }

    private Integer defineTicketPrice(Integer flightId, SeatClass seatClass) throws FileNotFoundException {
        FlightService flightService = new FlightService();
        Integer adj;

        adj = flightService.getSoldSeatsCount(flightId);

        if (SeatClass.BUSINESS.equals(seatClass)) {
            return BUSINESS_BASE_PRICE + adj;
        } else return ECONOMY_BASE_PRICE + adj;
    }
}
