package edu.bsu.cs327;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {

    private Button transmitFrameButton = new Button("Transmit Frame");
    private TextField sourceAddressField = new TextField();
    private TextField destAddressField = new TextField();
    private TextField portNumberField = new TextField();
    private Button resetButton = new Button("Reset");
    private Button showTableButton = new Button("Show Switching Table");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        configure(primaryStage);
    }

    private void configure(Stage stage){
        stage.setTitle("Switching");
        stage.setScene(new Scene(createRoot()));
        stage.setWidth(480);
        stage.setHeight(320);
        stage.show();
    }

    private Pane createRoot(){
        VBox root = new VBox(10);
        HBox buttons = new HBox(5);
        buttons.getChildren().addAll(
                transmitFrameButton,
                showTableButton,
                resetButton
        );
        root.getChildren().addAll(
                new Label("Source Port:"),
                portNumberField,
                new Label("Source Address:"),
                sourceAddressField,
                new Label("Destination Address:"),
                destAddressField,
                buttons
        );
        return root;
    }

}
