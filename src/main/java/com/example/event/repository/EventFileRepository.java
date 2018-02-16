package com.example.event.repository;

import au.com.bytecode.opencsv.CSVReader;
import com.example.event.model.Event;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EventFileRepository {
    @SuppressWarnings("resource")
    public List<Event> getAllFromFile(String fileName) throws Exception {
        List<Event> list = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(fileName), ';', '"', 1);
        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        while (((nextLine = reader.readNext()) != null)) {
            list.add(new Event(nextLine));
        }
        return list;
    }


    public static void main(String[] args) throws Exception {
        EventFileRepository repo = new EventFileRepository();
        repo.getAllFromFile("src\\main\\resources\\test_case.csv").forEach(System.out::println);
    }
}