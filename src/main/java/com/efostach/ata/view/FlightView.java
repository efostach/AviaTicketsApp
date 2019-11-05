package com.efostach.ata.view;

import com.efostach.ata.controller.FlightController;
import com.efostach.ata.model.Flight;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

class FlightView {

    private FlightController flightController = new FlightController();

    void showDatesForRout(Integer routId, String date, Integer seatClass) {
        try {
            List<Flight> flights = flightController.showDatesForRout(routId, date, seatClass);
            if (!flights.isEmpty()) {
                Iterator iterator = flightController.showDatesForRout(routId, date, seatClass).iterator();
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
