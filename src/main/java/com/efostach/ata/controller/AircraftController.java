package com.efostach.ata.controller;

import com.efostach.ata.model.Aircraft;
import com.efostach.ata.repository.io.JavaIOAircraftRepositoryImpl;

public class AircraftController {

    JavaIOAircraftRepositoryImpl ioAircraft = new JavaIOAircraftRepositoryImpl();

    public Aircraft getAircraftById(Integer id) {
        return null;
    }
}
