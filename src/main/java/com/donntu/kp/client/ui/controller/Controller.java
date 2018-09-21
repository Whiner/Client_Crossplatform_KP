package com.donntu.kp.client.ui.controller;

import com.donntu.kp.client.logger.Log;
import com.donntu.kp.client.logger.observer.TextAreaObserver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    private Model model = new Model();
    @FXML
    private TextArea logTF;

    @FXML
    private ListView<String> fileQueueLV;

    @FXML
    private Button addButton;

    @FXML
    private Button delButton;

    @FXML
    private TextField hostTB;

    @FXML
    private TextField portTB;

    @FXML
    private Button sendButton;

    private void setButtonActions() {
        addButton.setOnAction(event -> {
            model.pickFiles();
            model.updateFileList(fileQueueLV);
        });

        sendButton.setOnAction(event -> {
            if (fileQueueLV.getItems().size() == 0) {
                Log.getInstance().log("Файлы не выбраны. Отправка не состоялась");
            } else {
                try {
                    model.sendFiles(hostTB.getText(), Integer.parseInt(portTB.getText()));
                } catch (InterruptedException e) {
                    Log.getInstance().log("Ошибка отправки: " + e.getMessage());
                }
            }
        });

        delButton.setOnAction(event -> {
            String selectedItem = fileQueueLV.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                model.deleteFile(selectedItem);
                model.updateFileList(fileQueueLV);
            }
        });

    }

    @FXML
    void initialize() {
        setButtonActions();
        Log.getInstance().subscribe(new TextAreaObserver(logTF));
        fileQueueLV.setStyle("-fx-font-size: 16px");
        fileQueueLV.setOnMouseClicked(event -> {
            String selectedItem = fileQueueLV.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                delButton.setDisable(false);
            } else {
                delButton.setDisable(true);
            }
        });

        hostTB.setText("localhost");
        portTB.setText("1050");
    }

}
