package org.ui.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainScene implements EventHandler<MouseEvent> {
    //Flow Pane (root node)
    FlowPane rootFlowPane;
    //Main scene buttons
    Button newgameBtn, tvBtn, peopleBtn;

    public MainScene() {
        rootFlowPane=new FlowPane();
        newgameBtn=new Button("New Game");
        tvBtn=new Button("TV");
        peopleBtn=new Button("People");

        //Attach handle event to movieBtn
        newgameBtn.setOnMouseClicked(this);
        //Set up flow pane
        rootFlowPane.setAlignment(Pos.CENTER);
        rootFlowPane.setHgap(10);
        newgameBtn.setMinSize(120,30);
        tvBtn.setMinSize(120,30);
        peopleBtn.setMinSize(120,30);

        //add buttons to rootflowpane
        rootFlowPane.getChildren().add(newgameBtn);
        rootFlowPane.getChildren().add(tvBtn);
        rootFlowPane.getChildren().add(peopleBtn);
    }

    Scene createScene(){
        return new Scene(rootFlowPane, 650, 300);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource()==newgameBtn) {
            HelloApplication.primaryStage.setScene(HelloApplication.triviaScene);
        }
    }
}
