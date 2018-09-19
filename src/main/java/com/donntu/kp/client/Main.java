package com.donntu.kp.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage currentStage;

    public static void main(String[] args) throws IOException {
        launch(args);
        //DatagramSender clientLogic = new DatagramSender("localhost", 1050);
        //clientLogic.send("Первый пошел");
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/main.fxml/"));
        currentStage = primaryStage;
        primaryStage.setTitle("Клиент");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
        //primaryStage.setOnCloseRequest(event -> Dao.getInstance().close());
    }
}
