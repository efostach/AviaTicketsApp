package com.efostach.ata.repository.io;

import com.efostach.ata.model.Flight;
import com.efostach.ata.repository.FlightRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ata.repository.io.IOUtil.*;
import static com.efostach.ata.repository.io.IOUtil.writeDataToFile;

public class JavaIOFlightRepositoryImpl implements FlightRepository {

    private static String file = "src/main/resources/flights.csv";

    @Override
    public Flight getById(Integer id) throws FileNotFoundException {
        Iterator iterator = stringToFlight().iterator();
        Flight result = null;
        while (iterator.hasNext()) {
            Flight flight = (Flight) iterator.next();
            if (id.equals(flight.getId())) {
                result = flight;
            }
        }
        return result;
    }

    @Override
    public List<Flight> getAll() throws FileNotFoundException {
        return stringToFlight();
    }

    @Override
    public Flight create(Flight flight) throws Exception {
        flight.setId(getIncrementedId(file));
        writeDataToFile(file, flight.toString());
        return flight;
    }

    @Override
    public Flight update(Flight flight) throws IOException {
        List<Flight> flights = stringToFlight();
        clearFile(file);
        for (Flight element : flights) {
            if (element.getId().equals(flight.getId())) {
                element.setAircrafrId(flight.getAircrafrId());
                element.setRouteId(flight.getRouteId());
                element.setStartDate(flight.getStartDate());
                element.setEndDate(flight.getEndDate());
                element.setSoldSeatsCount(flight.getSoldSeatsCount());
            }
            writeDataToFile(file, element.toString());
        }
        return getById(flight.getId());
    }

    @Override
    public Flight delete(Flight flight) {
        return null;
    }

    private List<Flight> stringToFlight() throws FileNotFoundException {
        List<Flight> flightSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Flight flight = new Flight();
            flight.setId(Integer.valueOf(attributes[0]));
            flight.setStartDate(attributes[1]);
            flight.setEndDate(attributes[2]);
            flight.setSoldSeatsCount(Integer.valueOf(attributes[3]));
            flight.setAircrafrId(Integer.valueOf(attributes[4]));
            flight.setRouteId(Integer.valueOf(attributes[5]));
            flightSet.add(flight);
        }
        return flightSet;
    }
}
