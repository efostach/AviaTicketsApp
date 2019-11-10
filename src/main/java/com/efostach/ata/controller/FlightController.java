package com.efostach.ata.controller;

import com.efostach.ata.model.Flight;
import com.efostach.ata.repository.io.JavaIOFlightRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlightController {

    private JavaIOFlightRepositoryImpl ioFlight = new JavaIOFlightRepositoryImpl();

    public List<Flight> showDatesForRoute(Integer routeId, String date) throws FileNotFoundException {
        List<Flight> filteredFlightsByRoute = new ArrayList<>();
        Iterator iterator = ioFlight.getAll().iterator();

        while (iterator.hasNext()) {
            Flight object = (Flight) iterator.next();

            if(routeId.equals(object.getRouteId()) && date.equals(object.getStartDate())) {
                filteredFlightsByRoute.add(object);
            }
        }

        return filteredFlightsByRoute;
    }
}
