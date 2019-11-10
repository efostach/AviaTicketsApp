package com.efostach.ata.controller;

import com.efostach.ata.model.Route;
import com.efostach.ata.repository.io.JavaIORouteRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.List;

public class RouteController {

    private JavaIORouteRepositoryImpl ioRoute = new JavaIORouteRepositoryImpl();

    public List<Route> showAllRoutes() throws FileNotFoundException {
        return ioRoute.getAll();
    }
}
