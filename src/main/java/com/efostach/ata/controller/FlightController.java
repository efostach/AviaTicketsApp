package com.efostach.ata.controller;

import com.efostach.ata.model.Flight;
import com.efostach.ata.repository.io.JavaIOFlightRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlightController {

    JavaIOFlightRepositoryImpl ioFlight = new JavaIOFlightRepositoryImpl();

    public List<Flight> showDatesForRout(Integer routId, String date, Integer seatClass) throws FileNotFoundException {
        List<Flight> filteredFlightsByRout = new ArrayList<>();
        Iterator iterator = ioFlight.getAll().iterator();

        while (iterator.hasNext()) {
            Flight object = (Flight) iterator.next();

            if(routId.equals(object.getRoutId()) && date.equals(object.getStartDate())) {
                filteredFlightsByRout.add(object);
            }
        }

        return filteredFlightsByRout;
    }
}
