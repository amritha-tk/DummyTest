package com.dummyTesting;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVList {
    private static final String SAMPLE_CSV_PATH="D:\\Amritha\\Amritha.csv";

    public static void main(String args[]) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));
        CSVReader csvReader = new CSVReader(reader);
        //Read all record at once
        List<String[]> records=csvReader.readAll();
        for(String[] nextRecord : records) {
            System.out.println("Name : " + nextRecord[0]);
            System.out.println("Email : " + nextRecord[1]);
            System.out.println("Phone : " + nextRecord[2]);
            System.out.println("Country : " + nextRecord[3]);
            System.out.println("================================");

        }
    }
}


