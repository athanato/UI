package org.ui.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    static Stage primaryStage;
    static Scene mainScene, triviaScene;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Brain Drain");
//        stage.setScene(scene);
//        stage.show();

        this.primaryStage=stage;

        MainScene mainSceneCreator=new MainScene();
        mainScene=mainSceneCreator.createScene();

//        MovieSceneCreator movieSceneCreator=new MovieSceneCreator();
//        movieScene=movieSceneCreator.createScene();

        primaryStage.setTitle("Brain Drain");
        primaryStage.setScene(mainScene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}