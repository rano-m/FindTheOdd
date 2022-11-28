package com.example.findtheodd;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartScene extends Application {
    private static final Integer STARTTIME = 6;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private Integer timeSeconds = STARTTIME;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 800, 600);
        scene.setFill(Color.BEIGE);
        primaryStage.setTitle("FindTheOdd"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    protected BorderPane getPane() {
        HBox introPane = new HBox(40);
        introPane.setPadding(new Insets(15, 15, 15, 15));
        String cwd = System.getProperty("user.dir");
        Button btStart = new Button("Start"); // Windows 10

        ImageView btImage = new ImageView("file:" + cwd +"\\PNG\\buttonLong_brown.png");
        // ImageView btImage = new ImageView("file://" + cwd +"\\PNG\\buttonLong_brown.png");// MacOSX
        btStart.setGraphic(btImage);
        btStart.setContentDisplay(ContentDisplay.CENTER);
        btStart.setPadding(Insets.EMPTY);

        introPane.getChildren().addAll(btStart);
        introPane.setAlignment(Pos.CENTER);

        BackgroundImage myBI= new BackgroundImage(new Image("file:" + cwd +"\\PNG\\panel_beigeLight.png",32,32,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        BorderPane bPane = new BorderPane();
        bPane.setCenter(introPane);
        
        bPane.setBackground(new Background(myBI));


        btStart.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                //make a button disappear after it is clicked
                btStart.setVisible(false);

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
                        //button.setVisible(true);
                    }

                }
            }));

                timeline.playFromStart();

        }});


        return bPane;
    }




    public static void main(String[] args) {
        launch(args);
    }
}