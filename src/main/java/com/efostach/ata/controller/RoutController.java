package com.efostach.ata.controller;

import com.efostach.ata.model.Rout;
import com.efostach.ata.repository.io.JavaIORoutRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.List;

public class RoutController {

    private JavaIORoutRepositoryImpl ioRout = new JavaIORoutRepositoryImpl();

    public List<Rout> showAllRouts() throws FileNotFoundException {
        return ioRout.getAll();
    }

    public Integer getRoutIdByName(String name) {
        return null;
    }


}
