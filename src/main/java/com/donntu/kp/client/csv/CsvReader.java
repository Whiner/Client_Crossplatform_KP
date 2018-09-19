package com.donntu.kp.client.csv;

import com.donntu.kp.client.logger.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader extends Thread {
    private List<String> parsedLines = new ArrayList<>();
    private String filename;
    private int birdAttrCount = 11;
    private int mammalAttrCount = 10;

    private void readCreations() {
        if (filename == null || !filename.toLowerCase().contains(".csv")) {
            throw new InvalidParameterException("Файл должен быть расширения .csv");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Log.getInstance().log("Файл (" + filename + ") открыт");
            String s;
            List<String> lines = new ArrayList<>();
            while ((s = reader.readLine()) != null) {
                lines.add(s);
            }
            createCreations(lines);

        } catch (IOException e) {
            Log.getInstance().log("Ошибка чтения из файла (" + filename + "). Текст ошибки:" + e.getMessage());
            e.printStackTrace();
        }
        Log.getInstance().log("Файл (" + filename + ") закрыт");
    }

    private void createCreations(List<String> lines) {
        for (String line : lines) {
            String[] split = line.split(";");
            if (split.length != birdAttrCount && split.length != mammalAttrCount) {
                Log.getInstance().log("Ошибка на строке: " + line);
            } else {
                parsedLines.add(line);
            }

        }
    }

    @Override
    public void run() {
        readCreations();
        Log.getInstance().log("Поток " + Thread.currentThread().getName() + " окончил свою работу");
    }

    public List<String> getParsedLines() {
        return parsedLines;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public CsvReader() {
    }

    public void setBirdAttrCount(int birdAttrCount) {
        this.birdAttrCount = birdAttrCount;
    }

    public void setMammalAttrCount(int mammalAttrCount) {
        this.mammalAttrCount = mammalAttrCount;
    }

    public CsvReader(String filename) {
        this.filename = filename;
    }
}
