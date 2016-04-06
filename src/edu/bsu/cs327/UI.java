package edu.bsu.cs327;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {

    private Switching switchingSim = new Switching();
    private Button transmitFrameButton = new Button("Transmit Frame");
    private TextField sourceAddressField = new TextField();
    private TextField destAddressField = new TextField();
    private TextField portNumberField = new TextField();
    private Button resetButton = new Button("Reset");
    private Button showTableButton = new Button("Show Switching Table");
    private TextArea results = new TextArea();
    private TextArea tableResults = new TextArea();
    private Button clearTableButton = new Button("Clear Table");
    private Button returnToHome = new Button("Return to Main Screen");
    private Button closeButton = new Button("Close");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        configure(primaryStage);
        configTransmitFrameButton();
        configResetButton();
        configSwitchTableButton();
        configClearTableButton();
        configReturnButton();
        configCloseButton();
    }

    private void configure(Stage stage){
        stage.setTitle("Switching");
        stage.setScene(new Scene(createRoot()));
        stage.setWidth(720);
        stage.setHeight(540);
        stage.show();
    }

    private Pane createRoot(){
        VBox root = new VBox(5);
        HBox buttons = new HBox(5);
        results.setPrefSize(420, 150);
        results.setEditable(false);
        buttons.getChildren().addAll(
                transmitFrameButton,
                showTableButton,
                resetButton,
                closeButton
        );
        root.getChildren().addAll(
                new Label("Source Port:"),
                portNumberField,
                new Label("Source Address:"),
                sourceAddressField,
                new Label("Destination Address:"),
                destAddressField,
                results,
                buttons
        );
        return root;
    }

    private Pane createTablePane(){
        tableResults.setText(switchingSim.getTable().toString());
        VBox root = new VBox(5);
        HBox buttons = new HBox(5);
        buttons.getChildren().addAll(
                clearTableButton,
                returnToHome,
                closeButton
        );
        root.getChildren().addAll(
                new Label("Switch Table"),
                tableResults,
                buttons
        );
        return root;
    }

    private void configTransmitFrameButton(){
        transmitFrameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (switchingSim.frameErrorCheck(sourceAddressField.getText()).equals("NoError") &&
                        switchingSim.frameErrorCheck(destAddressField.getText()).equals("NoError") &&
                        switchingSim.portErrorCheck(Integer.parseInt(portNumberField.getText())).equals("NoError")){
                    results.setText(switchingSim.handleInput(sourceAddressField.getText(), Integer.parseInt(portNumberField.getText()), destAddressField.getText()));
                } else{
                    results.setText("Error! Please make sure the MAC addresses are 6 bytes long and the Port Number is less than 24!\n" +
                            "Click Reset to try again.");
                }
            }
        });
    }

    private void configResetButton(){
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sourceAddressField.clear();
                destAddressField.clear();
                portNumberField.clear();
                results.clear();
            }
        });
    }

    private void configSwitchTableButton(){
        showTableButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage second = (Stage) showTableButton.getScene().getWindow();
                second.setScene(new Scene(createTablePane()));
                second.show();
            }
        });
    }

    private void configClearTableButton(){
        clearTableButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switchingSim.getTable().clear();
                tableResults.setText(switchingSim.getTable().toString());
            }
        });
    }

    private void configReturnButton(){
        returnToHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage temp = (Stage)returnToHome.getScene().getWindow();
                temp.setScene(new Scene(createRoot()));
                sourceAddressField.clear();
                destAddressField.clear();
                results.clear();
                portNumberField.clear();
                temp.show();
            }
        });
    }

    private void configCloseButton(){
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeButton.getScene().getWindow().hide();
            }
        });
    }

}
