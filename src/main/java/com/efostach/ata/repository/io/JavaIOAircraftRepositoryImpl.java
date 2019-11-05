package com.efostach.ata.repository.io;

import com.efostach.ata.model.Aircraft;
import com.efostach.ata.repository.AircraftRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ata.repository.io.IOUtil.*;

public class JavaIOAircraftRepositoryImpl implements AircraftRepository {

    private static String file = "src/main/resources/aircraft.csv";

    @Override
    public Aircraft getById(Integer id) throws FileNotFoundException {
        Iterator iterator = stringToAircraft().iterator();
        Aircraft result = null;
        while (iterator.hasNext()) {
            Aircraft aircraft = (Aircraft) iterator.next();
            if (id.equals(aircraft.getId())) {
                result = aircraft;
            }
        }
        return result;
    }

    @Override
    public List<Aircraft> getAll() throws FileNotFoundException {
        return stringToAircraft();
    }

    @Override
    public Aircraft create(Aircraft aircraft) throws Exception {
        aircraft.setId(getIncrementedId(file));
        writeDataToFile(file, aircraft.toString());
        return aircraft;
    }

    @Override
    public Aircraft update(Aircraft aircraft) throws IOException {
        List<Aircraft> aircrafts = stringToAircraft();
        clearFile(file);
        for (Aircraft element : aircrafts) {
            if (element.getId().equals(aircraft.getId())) {
                element.setModelName(aircraft.getModelName());
                element.setBusinessSeatsCount(aircraft.getBusinessSeatsCount());
                element.setEconomySeatsCount(aircraft.getEconomySeatsCount());
            }
            writeDataToFile(file, element.toString());
        }
        return getById(aircraft.getId());
    }

    @Override
    public Aircraft delete(Aircraft aircraft) {
        return null;
    }

    private List<Aircraft> stringToAircraft() throws FileNotFoundException {
        List<Aircraft> aircraftSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Aircraft aircraft = new Aircraft();
            aircraft.setId(Integer.valueOf(attributes[0]));
            aircraft.setModelName(attributes[1]);
            aircraft.setBusinessSeatsCount(Integer.valueOf(attributes[2]));
            aircraft.setEconomySeatsCount(Integer.valueOf(attributes[3]));
            aircraftSet.add(aircraft);
        }
        return aircraftSet;
    }
}
