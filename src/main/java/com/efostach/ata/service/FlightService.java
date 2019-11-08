package com.efostach.ata.service;

import com.efostach.ata.model.*;
import com.efostach.ata.repository.io.JavaIOAircraftRepositoryImpl;
import com.efostach.ata.repository.io.JavaIOFlightRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

class FlightService {

    private JavaIOFlightRepositoryImpl ioFlight = new JavaIOFlightRepositoryImpl();
    private JavaIOAircraftRepositoryImpl ioAircraft = new JavaIOAircraftRepositoryImpl();

    Integer defineSeatNumber(Integer flightId, Integer seatClass) throws FileNotFoundException {
        if (checkIfFreeSeatsExists(flightId, seatClass)) {
            return ioFlight.getById(flightId).getSoldSeatsCount() + 1;
        }
        return null;
    }

    Integer getSoldSeatsCount(Integer flightId) throws FileNotFoundException {
        return ioFlight.getById(flightId).getSoldSeatsCount();
    }

    void incrementSoldSeatsCount(Integer flightId) throws IOException {
        Flight flight = ioFlight.getById(flightId);
        flight.setSoldSeatsCount(flight.getSoldSeatsCount() + 1);
        ioFlight.update(flight);
    }

    void decrementSoldSeatsCount(Integer flightId) throws IOException {
        Flight flight = ioFlight.getById(flightId);
        flight.setSoldSeatsCount(flight.getSoldSeatsCount() - 1);
        ioFlight.update(flight);
    }

    private boolean checkIfFreeSeatsExists(Integer flightId, Integer seatClass) throws FileNotFoundException {
        TicketService ticketService = new TicketService();
        Integer currentSeats;
        Integer totalSeats;
        Integer aircraftId = ioFlight.getById(flightId).getAircrafrId();

        if (seatClass == 1) {
            currentSeats = ticketService.getTicketsByFilter(flightId, SeatClass.BUSINESS, TicketStatus.PURCHASED).size();
            totalSeats = ioAircraft.getById(aircraftId).getBusinessSeatsCount();
        } else {
            currentSeats = ticketService.getTicketsByFilter(flightId, SeatClass.ECONOMY, TicketStatus.PURCHASED).size();
            totalSeats = ioAircraft.getById(aircraftId).getEconomySeatsCount();
        }
        return currentSeats < totalSeats;
    }
}
