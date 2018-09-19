package com.donntu.kp.client.ui.observer;

import javafx.scene.control.TextArea;

public class TextAreaObserver implements IObserver {

    private TextArea textField;

    public TextAreaObserver(TextArea textField) {
        this.textField = textField;
    }

    @Override
    public void update(String log) {
        textField.setText(textField.getText().concat("\n" + log));
    }
}
