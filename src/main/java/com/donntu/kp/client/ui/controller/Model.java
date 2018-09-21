package com.donntu.kp.client.ui.controller;

import com.donntu.kp.client.DatagramSender;
import com.donntu.kp.client.FilePicker;
import com.donntu.kp.client.csv.ThreadController;
import com.donntu.kp.client.logger.Log;
import javafx.scene.control.ListView;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
    private Set<File> files = new HashSet<>();

    public Set<String> getFilenames() {
        Set<String> filenames = new HashSet<>();
        for (File file : files) {
            if (file != null) {
                filenames.add(file.getName());
            }
        }
        return filenames;
    }

    private int checkUniqueCount(List<File> files) {
        int count = 0;
        for (File file : files) {
            if (!this.files.contains(file)) {
                count++;
            }
        }
        return count;
    }

    public void pickFiles() {
        List<File> files = FilePicker.getFiles();
        int i = checkUniqueCount(files);
        if (i == 0) {
            Log.getInstance().log("Все выбранные файлы уже находятся в очереди");
        } else {
            Log.getInstance().log("Выбрано " + i + " файлов");
        }
        this.files.addAll(files);
    }

    public void sendFiles(String host, int port) throws InterruptedException {
        List<String> strings = parseFiles();
        DatagramSender clientLogic = new DatagramSender(host, port);
        for (String string : strings) {
            clientLogic.send(string);
        }
        Log.getInstance().log("Отправка завершена");
    }

    private List<String> parseFiles() throws InterruptedException {
        ThreadController threadController = new ThreadController();
        for (File file : files) {
            threadController.addFile(file.getAbsolutePath());
        }

        threadController.startReading();
        return threadController.getParsedLines();
    }

    public void deleteFile(String filename) {
        for (File file : files) {
            if (file.getName().equals(filename)) {
                files.remove(file);
            }
        }
    }

    public void updateFileList(ListView<String> fileQueueLV) {
        fileQueueLV.getItems().clear();
        fileQueueLV.getItems().addAll(getFilenames());
    }
}
