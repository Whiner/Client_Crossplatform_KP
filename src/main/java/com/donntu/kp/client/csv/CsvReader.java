package com.donntu.kp.client.csv;

import com.donntu.kp.client.logger.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader extends Thread {
    private List<String> readLines = new ArrayList<>();
    private String filename;


    private void readFiles() {
        if (filename == null || !filename.toLowerCase().contains(".csv")) {
            throw new InvalidParameterException("Файл должен быть расширения .csv");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Log.getInstance().log("Файл (" + filename + ") открыт");
            String s;
            while ((s = reader.readLine()) != null) {
                readLines.add(s);
            }
        } catch (IOException e) {
            Log.getInstance().log("Ошибка чтения из файла (" + filename + "). Текст ошибки:" + e.getMessage());
            e.printStackTrace();
        }
        Log.getInstance().log("Файл (" + filename + ") считан");
        Log.getInstance().log("Файл (" + filename + ") закрыт");
    }



    @Override
    public void run() {
        readFiles();
    }

    public List<String> getReadLines() {
        return readLines;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public CsvReader() {
    }



    public CsvReader(String filename) {
        this.filename = filename;
    }
}
