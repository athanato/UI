package org.ui.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import org.example.Result;

public class TriviaScene implements EventHandler<MouseEvent> {

    //Flow pane
    FlowPane buttonFlowPane;

    //Grid Panes
    GridPane rootGridPane,inputFieldsPane;

    //Movie scene buttons
    Button categoryBtn, difficultyBtn, typeBtn , searchquizBtn, backBtn;

    //Movie scene label
    Label textLbl;

    //Movie scene text field
    TextField paramField;

    TableView<Result> movieTableView;

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
