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
                element = Ticket.newBuilder()
                        .setTicketNumber(ticket.getTicketNumber())
                        .setFirstName(ticket.getFirstName())
                        .setLastName(ticket.getLastName())
                        .setFlightId(ticket.getFlightId())
                        .setSeatClass(ticket.getSeatClass())
                        .setSeatNumber(ticket.getSeatNumber())
                        .setStatus(ticket.getStatus())
                        .setPrice(ticket.getPrice())
                        .build();
                System.out.println("element" + element.toString());
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

            Ticket ticket = Ticket.newBuilder()
                    .setTicketNumber(Integer.valueOf(attributes[0]))
                    .setFirstName(attributes[1])
                    .setLastName(attributes[2])
                    .setFlightId(Integer.valueOf(attributes[3]))
                    .setSeatNumber(Integer.valueOf(attributes[4]))
                    .setSeatClass(SeatClass.valueOf(attributes[5]))
                    .setStatus(TicketStatus.valueOf(attributes[6]))
                    .setPrice(Integer.valueOf(attributes[7]))
                    .build();
            ticketsSet.add(ticket);
        }
        return ticketsSet;
    }
}
