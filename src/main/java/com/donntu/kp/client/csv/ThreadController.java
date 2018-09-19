package com.donntu.kp.client.csv;


import com.donntu.kp.client.logger.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreadController {
    private Set<String> filenames = new HashSet<>();
    private List<String> parsedLines = new ArrayList<>();

    public void addFile(String filename) {
        boolean add = filenames.add(filename);
        if (add) {
            Log.getInstance().log("Файл " + filename + " добавлен в очередь");
        } else {
            Log.getInstance().log("Файл " + filename + " уже существует в очереди");
        }
    }

    public void startReading() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (String filename : filenames) {
            Thread thread = new CsvReader(filename);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (Thread thread : threads) {
            if (thread instanceof CsvReader) {
                CsvReader csvReader = (CsvReader) thread;
                parsedLines.addAll(csvReader.getReadLines());
            }
        }
    }

    public List<String> getParsedLines() {
        return parsedLines;
    }
}
