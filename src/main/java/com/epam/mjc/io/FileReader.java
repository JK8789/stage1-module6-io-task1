package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        Integer age = 0;
        String email = "";
        Long phone = Long.valueOf(0);
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file.getPath()))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Name: ")) {
                    name = line.substring(6);
                }
                if (line.contains("Age: ")) {
                    age = Integer.valueOf(line.substring(5));
                }
                if (line.contains("Email: ")) {
                    email = line.substring(7);
                }
                if (line.contains("Phone: ")) {
                    phone = Long.valueOf(line.substring(7));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Profile profile = new Profile(name, age, email, phone);
        return profile;
    }
}