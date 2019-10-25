package com.efostach.ata.repository.io;

import com.efostach.ata.model.Rout;
import com.efostach.ata.repository.RoutRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ata.repository.io.IOUtil.*;
import static com.efostach.ata.repository.io.IOUtil.writeDataToFile;

public class JavaIORoutRepositoryImpl implements RoutRepository {

    private static String file = "src/main/resources/routs.csv";

    @Override
    public Rout getById(Integer id) throws FileNotFoundException {
        Iterator iterator = stringToRout().iterator();
        Rout result = null;
        while (iterator.hasNext()) {
            Rout rout = (Rout) iterator.next();
            if (id.equals(rout.getId())) {
                result = rout;
            }
        }
        System.out.println(result.toString());
        return result;
    }

    @Override
    public List<Rout> getAll() throws FileNotFoundException {
        return stringToRout();
    }

    @Override
    public Rout create(Rout rout) throws Exception {
        rout.setId(getIncrementedId(file));
        writeDataToFile(file, rout.toString());
        return rout;
    }

    @Override
    public Rout update(Rout rout) {
        return null;
    }

    private List<Rout> stringToRout() throws FileNotFoundException {
        List<Rout> ticketsSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Rout rout = new Rout();
            rout.setId(Integer.valueOf(attributes[0]));
            rout.setFrom(attributes[1]);
            rout.setTo(attributes[2]);
            rout.setAircraftId(attributes[3]);
            rout.setFlightNumber(attributes[4]);
            ticketsSet.add(rout);
        }
        return ticketsSet;
    }
}
