package com.dummyTesting;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class PojoClass {
    private static final String SAMPLE_CSV_PATH="D:\\Amritha\\Amritha.csv";

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

    public static void main(String args[]) throws IOException {
        Reader reader= Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));
        CsvToBean<PojoClass> csvToBean=new CsvToBeanBuilder(reader).
                withType(PojoClass.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<PojoClass> csvIterator=csvToBean.iterator();
        while (csvIterator.hasNext()){
            PojoClass pojocsvUser=csvIterator.next();
            System.out.println("Name : "+pojocsvUser.name);
            System.out.println("Email : "+pojocsvUser.email);
            System.out.println("Phone : "+pojocsvUser.phoneNo);
            System.out.println("Country : "+pojocsvUser.country);

        }
    }


}


