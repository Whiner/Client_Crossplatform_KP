package com.donntu.kp.client.logger.observer;

import javafx.scene.control.TextArea;

public class TextAreaObserver implements IObserver {

    private TextArea textField;

    public TextAreaObserver(TextArea textField) {
        this.textField = textField;
    }

    @Override
    public synchronized void update(String log) {
        textField.appendText(log + "\n");
    }
}
