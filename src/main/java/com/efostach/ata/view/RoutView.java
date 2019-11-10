package com.efostach.ata.view;

import com.efostach.ata.controller.RouteController;
import com.efostach.ata.model.Route;

import java.io.FileNotFoundException;
import java.util.Iterator;

class RouteView {

    private RouteController routeController = new RouteController();

    void showAllRoutes() {
        try {
            Iterator iterator = routeController.showAllRoutes().iterator();
            while (iterator.hasNext()) {
                printRoute((Route) iterator.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the data file storage.");
        }
    }

    private void printRoute(Route route){
        System.out.println(route.getId()
                + "\tFrom: " + route.getFrom()
                + "\tTo: " + route.getTo());
    }
}
