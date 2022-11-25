package com.example.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class CsvReaderHelper {

    private InputStream path;
    public CsvReaderHelper(InputStream path) {
        this.path = path;
    }
    public List<String []> getData() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new InputStreamReader(path));
        return  csvReader.readAll();
    }

}