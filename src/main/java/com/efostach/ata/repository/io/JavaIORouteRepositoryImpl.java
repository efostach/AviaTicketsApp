package com.efostach.ata.repository.io;

import com.efostach.ata.model.Route;
import com.efostach.ata.repository.RouteRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ata.repository.io.IOUtil.*;
import static com.efostach.ata.repository.io.IOUtil.writeDataToFile;

public class JavaIORouteRepositoryImpl implements RouteRepository {

    private static String file = "src/main/resources/routes.csv";

    @Override
    public Route getById(Integer id) throws FileNotFoundException {
        Iterator iterator = stringToRoute().iterator();
        Route result = null;
        while (iterator.hasNext()) {
            Route route = (Route) iterator.next();
            if (id.equals(route.getId())) {
                result = route;
            }
        }
        return result;
    }

    @Override
    public List<Route> getAll() throws FileNotFoundException {
        return stringToRoute();
    }

    @Override
    public Route create(Route route) throws Exception {
        route.setId(getIncrementedId(file));
        writeDataToFile(file, route.toString());
        return route;
    }

    @Override
    public Route update(Route route) throws IOException {
        List<Route> routes = stringToRoute();
        clearFile(file);
        for (Route element : routes) {
            if (element.getId().equals(route.getId())) {
                element.setFrom(route.getFrom());
                element.setTo(route.getTo());
            }
            writeDataToFile(file, element.toString());
        }
        return getById(route.getId());
    }

    @Override
    public Route delete(Route route) {
        return null;
    }

    private List<Route> stringToRoute() throws FileNotFoundException {
        List<Route> routeSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Route route = new Route();
            route.setId(Integer.valueOf(attributes[0]));
            route.setFrom(attributes[1]);
            route.setTo(attributes[2]);
            routeSet.add(route);
        }
        return routeSet;
    }
}
