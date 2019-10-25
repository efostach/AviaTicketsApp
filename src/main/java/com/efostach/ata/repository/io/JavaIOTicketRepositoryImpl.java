package com.efostach.ata.repository.io;

import com.efostach.ata.model.Ticket;
import com.efostach.ata.model.TicketClass;
import com.efostach.ata.repository.TicketRepository;

import java.io.FileNotFoundException;
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
        System.out.println(result.toString());
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
    public Ticket update(Ticket ticket) {
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
            ticket.setFrom(attributes[1]);
            ticket.setTo(attributes[1]);
            ticket.setAircraft(attributes[0]);
            ticket.setDate(attributes[3]);
            ticket.setSeatNumber(attributes[2]);
            ticket.setTicketClass(TicketClass.valueOf(attributes[4]));
            ticketsSet.add(ticket);
        }
        return ticketsSet;
    }
}
