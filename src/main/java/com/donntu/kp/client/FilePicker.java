package com.donntu.kp.client;

import com.donntu.kp.client.Main;
import com.donntu.kp.client.logger.Log;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilePicker {

    public static List<File> getFiles() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файлы");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv")
        );
        List<File> files = fileChooser.showOpenMultipleDialog(Main.getCurrentStage());
        if(files != null) {
            return files;
        } else {
            return new ArrayList<>();
        }
    }

    public static List<String> getFilesNames() {
        List<File> files = getFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file: files){
            fileNames.add(file.getName());
        }
        return fileNames;
    }

    public static List<String> getFilesAbsolutePath() {
        List<File> files = getFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file: files){
            fileNames.add(file.getAbsolutePath());
        }
        return fileNames;
    }
}
