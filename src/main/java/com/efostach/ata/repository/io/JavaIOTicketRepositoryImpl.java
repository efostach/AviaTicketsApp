package com.efostach.ata.repository.io;

import com.efostach.ata.model.SeatClass;
import com.efostach.ata.model.Ticket;
import com.efostach.ata.model.TicketStatus;
import com.efostach.ata.repository.TicketRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ata.repository.io.IOUtil.*;

public class JavaIOTicketRepositoryImpl implements TicketRepository {

    private static String file = "src/main/resources/tickets.csv";

    @Override
    public Ticket getById(Integer ticketNumber) throws FileNotFoundException {
        Iterator iterator = stringToTicket().iterator();
        Ticket result = null;
        while (iterator.hasNext()) {
            Ticket ticket = (Ticket) iterator.next();
            if (ticketNumber.equals(ticket.getTicketNumber())) {
                result = ticket;
            }
        }
        return result;
    }

    @Override
    public List<Ticket> getAll() throws FileNotFoundException {
        return stringToTicket();
    }

    @Override
    public Ticket create(Ticket ticket) throws Exception {
        ticket.setTicketNumber(getIncrementedId(file));
        writeDataToFile(file, ticket.toString());
        return ticket;
    }

    @Override
    public Ticket update(Ticket ticket) throws IOException {
        List<Ticket> tickets = stringToTicket();
        clearFile(file);
        for (Ticket element : tickets) {
            if (element.getTicketNumber().equals(ticket.getTicketNumber())) {
                element.setFirstName(ticket.getFirstName());
                element.setLastName(ticket.getLastName());
                element.setFlightId(ticket.getFlightId());
                element.setSeatClass(ticket.getSeatClass());
                element.setSeatNumber(ticket.getSeatNumber());
                element.setStatus(ticket.getStatus());
            }
            writeDataToFile(file, element.toString());
        }
        return getById(ticket.getTicketNumber());
    }

    @Override
    public Ticket delete(Ticket ticket) {
        return null;
    }

    private List<Ticket> stringToTicket() throws FileNotFoundException {
        List<Ticket> ticketsSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Ticket ticket = new Ticket();
            ticket.setTicketNumber(Integer.valueOf(attributes[0]));
            ticket.setFirstName(attributes[1]);
            ticket.setLastName(attributes[2]);
            ticket.setFlightId(Integer.valueOf(attributes[3]));
            ticket.setSeatNumber(Integer.valueOf(attributes[4]));
            ticket.setSeatClass(SeatClass.valueOf(attributes[5]));
            ticket.setStatus(TicketStatus.valueOf(attributes[6]));
            ticketsSet.add(ticket);
        }
        return ticketsSet;
    }
}
