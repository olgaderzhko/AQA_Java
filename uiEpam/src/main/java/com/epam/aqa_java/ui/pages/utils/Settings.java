package com.epam.aqa_java.ui.pages.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;


public class Settings {

    public static Settings Instance = new Settings();

    private final HashMap<String, String> map = new HashMap<String, String>();

    private Settings() {
        this.LoadFile();
    }

    private void LoadFile() {
        try {
            FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("parser_data.csv").getPath());
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                this.map.put(row[0], row[1]);
            }
        } catch (Exception err) {
            System.out.println("Unable to parse the file");
        }
    }

    public String getValue(String key) {
        return this.map.get(key);
    }
}
