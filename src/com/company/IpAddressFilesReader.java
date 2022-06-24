package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IpAddressFilesReader {

    public long read(String file, IpAddres iPaddresses) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    iPaddresses.insert(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File " + file + " is not found!");
        }

        return iPaddresses.size();
    }


}
