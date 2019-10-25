package com.efostach.ata.repository.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOUtil {

    static final String REGEX = ",";

    static List<String> readDataFromFile(String filePath) throws FileNotFoundException {
        try (Scanner in = new Scanner(new FileReader(new File(filePath)))) {
            List<String> lines = new ArrayList<>();
            int i = 0;
            while (in.hasNext()) {
                lines.add(i, in.nextLine());
                i++;
            }
            return lines;
        }
    }

    static void writeDataToFile(String filePath, String data) throws IOException {
        try (FileWriter out = new FileWriter(new File(filePath), true)) {
            out.append(data);
        }
    }

    static Integer getIncrementedId(String filePath) throws FileNotFoundException {
        List<String> elements = readDataFromFile(filePath);

        if (elements.size() > 0) {
            String[] lastElement = elements.get(elements.size() - 1).split(REGEX);
            return (Integer.valueOf(lastElement[0]) + 1);
        } else
            return 1;
    }

    static void clearFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath, false);
        fw.flush();
        fw.close();
    }
}
