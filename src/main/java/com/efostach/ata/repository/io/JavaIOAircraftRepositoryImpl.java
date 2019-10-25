package com.efostach.ata.repository.io;

import com.efostach.ata.model.Aircraft;
import com.efostach.ata.repository.AircraftRepository;

import java.io.FileNotFoundException;
import java.util.List;

class JavaIOAircraftRepositoryImpl implements AircraftRepository {

    @Override
    public Aircraft getById(Integer integer) throws FileNotFoundException {
        return null;
    }

    @Override
    public List<Aircraft> getAll() throws FileNotFoundException {
        return null;
    }

    @Override
    public Aircraft create(Aircraft aircraft) throws Exception {
        return null;
    }

    @Override
    public Aircraft update(Aircraft aircraft) {
        return null;
    }
}
