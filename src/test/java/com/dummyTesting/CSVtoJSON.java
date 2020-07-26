package com.dummyTesting;

import com.google.gson.Gson;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CSVtoJSON {
    private static final String SAMPLE_CSV_PATH="D:\\Amritha\\Amritha.csv";
    private static final String SAMPLE_JSON_PATH="D:\\Amritha\\Amritha.json";

    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email",required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    @Override
    public String toString() {
        return "PojoClass{" +
                "name= " + name + '\'' +
                ",email= " + email + '\'' +
                ",phoneNo= " + phoneNo + '\'' +
                ",country=" + country + '\'' +
                '}';
    }
    public static void main (String args[]){

        try{
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));
            CsvToBeanBuilder<CSVtoJSON> csv=new CsvToBeanBuilder<>(reader);
            csv.withType(CSVtoJSON.class);
            csv.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVtoJSON> csvToBean=csv.build();
            List<CSVtoJSON> users=csvToBean.parse();
            Gson gson=new Gson();
            String json=gson.toJson(users);
            FileWriter writer =new FileWriter(SAMPLE_JSON_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br=new BufferedReader(new FileReader(SAMPLE_JSON_PATH));
            CSVtoJSON[] usrObj=gson.fromJson(br,CSVtoJSON[].class);
            List<CSVtoJSON> list= Arrays.asList(usrObj);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
