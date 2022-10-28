package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReader {

    static final Logger LOGGER = LogManager.getLogger();
    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0L;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file.getPath()))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Name: ")) {
                    name = line.substring(6);
                }
                if (line.contains("Age: ")) {
                    age = Integer.parseInt(line.substring(5));
                }
                if (line.contains("Email: ")) {
                    email = line.substring(7);
                }
                if (line.contains("Phone: ")) {
                    phone = Long.parseLong(line.substring(7));
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File was not found. " + e.getMessage());
        } catch (IOException ex) {
            LOGGER.error("Read line Error. " + ex);
        }
        return new Profile(name, age, email, phone);
    }
}