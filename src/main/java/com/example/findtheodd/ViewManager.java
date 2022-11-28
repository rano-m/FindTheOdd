package com.example.findtheodd;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewManager {
    private Stage stage;
    private Scene scene;

    public ViewManager(){
        BorderPane bpane = new BorderPane();
        Scene scene = new Scene(bpane, 800, 600);
        Stage stage = new Stage();
        stage.getScene();
        scene.setFill(Color.BEIGE);
    }
    public Stage getStage(){
        return stage;
    }
}
