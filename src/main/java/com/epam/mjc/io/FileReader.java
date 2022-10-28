package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

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
            throw new RuntimeException("File was not found." + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(name, age, email, phone);
    }
}