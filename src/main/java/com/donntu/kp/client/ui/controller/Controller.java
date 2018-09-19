package com.donntu.kp.client.ui.controller;

import com.donntu.kp.client.logger.Log;
import com.donntu.kp.client.ui.observer.TextAreaObserver;
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
    private TextField hostTB;

    @FXML
    private TextField portTB;

    @FXML
    private Button sendButton;

    private void setButtonActions() {
        addButton.setOnAction(event -> {
            model.pickFiles();
            fileQueueLV.getItems().clear();
            fileQueueLV.getItems().addAll(model.getFilenames());
        });

        sendButton.setOnAction(event -> {
            try {
                model.sendFiles(hostTB.getText(), Integer.parseInt(portTB.getText()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    void initialize() {
        setButtonActions();
        Log.getInstance().subscribe(new TextAreaObserver(logTF));
        hostTB.setText("localhost");
        portTB.setText("1050");
    }

}
