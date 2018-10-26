package com.Lireoy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public static TextArea consoleTextArea;

    @FXML
    private TextField downloadLinkField;

    @FXML
    public void handleButtonClick(ActionEvent event) {
        try {
            Thread downloadThread = new DownloadThread();
            DownloadThread.setLink(downloadLinkField.getText().trim());
            downloadThread.start();
        } catch (Exception e) {
            System.out.println("valami elbaszódott");
        }
    }

    static void setConsoleTextArea(String inputString) {
        consoleTextArea.setText(inputString);
    }

}
