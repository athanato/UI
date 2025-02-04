package org.ui.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;


    public class MainSceneCreator implements EventHandler<MouseEvent> {
        //Flow Pane (root node)
        FlowPane rootFlowPane;
        //Main scene buttons
        Button triviaBtn, tvBtn, peopleBtn;

        public MainSceneCreator() {
            rootFlowPane=new FlowPane();
            triviaBtn=new Button("Trivia");
            tvBtn=new Button("TV");
            peopleBtn=new Button("People");

            //Attach handle event to movieBtn
            triviaBtn.setOnMouseClicked(this);
            //Set up flow pane
            rootFlowPane.setAlignment(Pos.CENTER);
            rootFlowPane.setHgap(10);
            triviaBtn.setMinSize(120,30);
            tvBtn.setMinSize(120,30);
            peopleBtn.setMinSize(120,30);

            //add buttons to rootflowpane
            rootFlowPane.getChildren().add(triviaBtn);
            rootFlowPane.getChildren().add(tvBtn);
            rootFlowPane.getChildren().add(peopleBtn);
        }

        Scene createScene(){
            return new Scene(rootFlowPane, 650, 300);
        }

        @Override
        public void handle(MouseEvent event) {
            if (event.getSource()==triviaBtn) {
                HelloApplication.primaryStage.setScene(HelloApplication.triviaScene);
            }
        }
    }
