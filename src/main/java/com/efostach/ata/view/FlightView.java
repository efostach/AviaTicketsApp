package com.efostach.ata.view;

import com.efostach.ata.controller.FlightController;
import com.efostach.ata.model.Flight;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

class FlightView {

    private FlightController flightController = new FlightController();

    void showDatesForRoute(Integer routeId, String date) {
        try {
            List<Flight> flights = flightController.showDatesForRoute(routeId, date);
            if (!flights.isEmpty()) {
                Iterator iterator = flightController.showDatesForRoute(routeId, date).iterator();
                while (iterator.hasNext()) {
                    printFlight((Flight) iterator.next());
                }
            } else {
                System.out.println("No found any flight.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the data file storage.");
        }
    }

    private void printFlight(Flight flight) {
        System.out.println(flight.getId()
                + "\tStart Date: " + flight.getStartDate()
                + "\tEnd Date: " + flight.getEndDate());
    }
}
