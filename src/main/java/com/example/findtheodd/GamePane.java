package com.example.findtheodd;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePane extends Application {
    // private class constant and some variables

    private static final Integer STARTTIME = 6;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private Integer timeSeconds = STARTTIME;

    Group root = new Group();
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a border pane
        BorderPane pane = new BorderPane();
        // Place nodes in the pane
        pane.setTop(getHBox()); // Top border

        // Configure the Label
        timerLabel.setText(timeSeconds.toString());
        timerLabel.setTextFill(Color.BLACK);
        //timerLabel.setStyle("-fx-font-size: 4em;");

        // Create a scene and place it in the stage

        Scene scene = new Scene(pane, 800, 600);
        scene.setFill(Color.BEIGE);
        primaryStage.setTitle("ShowHBoxVBox"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage


    }
    private HBox getHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: grey");
        hBox.getChildren().add(new Text("Time:"));

        // Add the button and timerLabel to the VBox
        hBox.getChildren().addAll(timerLabel);

        hBox.getChildren().add(new Text("Score:"));

        // Create and configure the Button
        Button button = new Button();
        button.setText("Start Game");

        button.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                //make a button disappear after it is clicked
                button.setVisible(false);
                if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds = STARTTIME;

                // update timerLabel
                timerLabel.setText(timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler() {
                                    @Override
                                    public void handle(Event event) {
                                        timeSeconds--;
                                        // update timerLabel
                                        timerLabel.setText(
                                                timeSeconds.toString());
                                        if (timeSeconds <= 0) {
                                            timeline.stop();
                                            button.setVisible(true);
                                        }

                                    }
                                }));

                timeline.playFromStart();
            }

        });
        hBox.getChildren().add(button);

        return hBox;
    }



}


