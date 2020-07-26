package com.dummyTesting;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteToCSV {
    private static final String SAMPLE_CSV_PATH = "D:\\Amritha\\Writetocsv.csv";
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    public WriteToCSV(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    @Override
    public String toString() {
        return "PojoClass{" +
                "name= " + name + '\'' +
                ",email= " + email + '\'' +
                ",phoneNo= " + phoneNo + '\'' +
                ",country= " + country + '\'' +
                '}';
    }

    public static void main(String args[]) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

            Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_PATH));
            StatefulBeanToCsv<WriteToCSV> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<WriteToCSV> users = new ArrayList<>();
            users.add(new WriteToCSV("Rathi", "ratho66@Gmail.com", "8579399222", "India"));
            users.add(new WriteToCSV("Ramdas", "ramd@gmail.com", "87789299222", "India"));

            beanToCsv.write(users);
    }
}