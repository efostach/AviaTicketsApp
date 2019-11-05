package com.efostach.ata.view;

import com.efostach.ata.controller.RoutController;
import com.efostach.ata.model.Rout;

import java.io.FileNotFoundException;
import java.util.Iterator;

class RoutView {

    private RoutController routController = new RoutController();

    void showAllRouts() {
        try {
            Iterator iterator = routController.showAllRouts().iterator();
            while (iterator.hasNext()) {
                printRout((Rout) iterator.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the data file storage.");
        }
    }

    private void printRout(Rout rout){
        System.out.println(rout.getId()
                + "\tFrom: " + rout.getFrom()
                + "\tTo: " + rout.getTo());
    }
}
