package org.ui.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import org.example.DemoGetRESTAPI;
import org.example.Result;
import org.example.TriviaAPIException;

import java.util.List;




    public class TriviaSceneCreator  implements EventHandler<MouseEvent> {
        //Flow pane
        FlowPane buttonFlowPane;
        //Grid Panes
        GridPane rootGridPane,inputFieldsPane;
        //Movie scene buttons
        Button discoverNumBtn, discoverByDifficultyBtn, discoverCetegoryBtn, searchTriviaBtn, backBtn;
        //Movie scene label
        Label textLbl;
        //Movie scene text field
        TextField paramField;
        //Table view
        TableView<Result> triviaTableView;

        public TriviaSceneCreator() {
            //initialize things
            rootGridPane=new GridPane();
            inputFieldsPane=new GridPane();
            buttonFlowPane=new FlowPane();

            textLbl=new Label("Categories: ");
            paramField=new TextField();

            discoverNumBtn=new Button("Number of questions");
            discoverByDifficultyBtn=new Button("By Difficulty");
            discoverCetegoryBtn=new Button("By Category");
            searchTriviaBtn=new Button("Search For Questions");
            backBtn=new Button("Go Back");

            triviaTableView=new TableView<Result>();

            TableColumn<Result, String> titleColumn = new TableColumn<Result, String>("amount");
            titleColumn.setCellValueFactory(new PropertyValueFactory("amount"));
            triviaTableView.getColumns().add(titleColumn);

            TableColumn<Result, String> descriptionColumn = new TableColumn<Result, String>("category");
            descriptionColumn.setCellValueFactory(new PropertyValueFactory("category"));
            triviaTableView.getColumns().add(descriptionColumn);

            TableColumn<Result, String> ratingColumn = new TableColumn<Result, String>("difficulty");
            ratingColumn.setCellValueFactory(new PropertyValueFactory("difficulty"));
            triviaTableView.getColumns().add(ratingColumn);

            TableColumn<Result, String> releaseDateColumn = new TableColumn<Result, String>("type Date");
            releaseDateColumn.setCellValueFactory(new PropertyValueFactory("type"));
            triviaTableView.getColumns().add(releaseDateColumn);



            buttonFlowPane.getChildren().add(discoverNumBtn);
            buttonFlowPane.getChildren().add(discoverByDifficultyBtn);
            buttonFlowPane.getChildren().add(discoverCetegoryBtn);
            buttonFlowPane.getChildren().add(searchTriviaBtn);




            buttonFlowPane.setAlignment(Pos.CENTER);
            buttonFlowPane.setHgap(10);

            //customize input fields pane
            inputFieldsPane.add(textLbl, 0, 0);
            inputFieldsPane.add(paramField, 1, 0);
            inputFieldsPane.setVgap(10);
            inputFieldsPane.setHgap(10);


            rootGridPane.add(triviaTableView, 0, 0);
            rootGridPane.add(inputFieldsPane, 1, 0);
            rootGridPane.add(buttonFlowPane, 0, 1);
            rootGridPane.add(backBtn, 1, 1);

            rootGridPane.setHgap(10);
            rootGridPane.setVgap(10);

            //attach events
            discoverNumBtn.setOnMouseClicked(this);
            discoverByDifficultyBtn.setOnMouseClicked(this);
            discoverCetegoryBtn.setOnMouseClicked(this);
            searchTriviaBtn.setOnMouseClicked(this);
            backBtn.setOnMouseClicked(this);

        }

        Scene createScene(){
            return new Scene(rootGridPane, 650, 300);
        }

        @Override
        public void handle(MouseEvent event) {
            if (event.getSource()==discoverNumBtn) {
                DemoGetRESTAPI mas=new DemoGetRESTAPI();
                try {
                    int amount= Integer.parseInt(paramField.getText());
                    //List<Result> triviaList = mas.getPopularMovies();

                    List<Result> triviaList = mas.getAmountOfQuestions(amount);


                    List<Result> items =triviaTableView.getItems();
                    items.clear();

                    for (Result trivia:triviaList) {
                        items.add(trivia);
                    }

                }catch(NumberFormatException e) {
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Wrong Input");
                    a.setContentText("You must give an integer");
                    a.show();
                }catch(TriviaAPIException e) {
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error calling Movie API");
                    a.setContentText(e.getMessage());
                    a.show();
                }
            }
            else if (event.getSource()==discoverByDifficultyBtn) {
                DemoGetRESTAPI mas=new DemoGetRESTAPI();
                try {
                    int year= Integer.parseInt(paramField.getText());
                    List<Result> triviaList = mas.getDifficulty();

                    List<Result> items =triviaTableView.getItems();
                    items.clear();

//                    for (MovieInfo movie:movieList) {
//                        items.add(movie);
//                    }

//                }catch(NumberFormatException e) {
//                    Alert a =new Alert(Alert.AlertType.ERROR);
//                    a.setTitle("Wrong Input");
//                    a.setContentText("You must give an integer");
//                    a.show();
                }catch(TriviaAPIException e) {
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error calling Movie API");
                    a.setContentText(e.getMessage());
                    a.show();
                }
            }
            else if (event.getSource()==discoverCetegoryBtn) {
                DemoGetRESTAPI mas=new DemoGetRESTAPI();
                try {

                    String queryString= paramField.getText();
                    List<Result> triviaList = mas.searchForCategory(queryString);

                    List<Result> items =triviaTableView.getItems();
                    items.clear();

//                    for (MovieInfo movie:movieList) {
//                        items.add(movie);
//                    }

                }catch(TriviaAPIException e) {
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error calling Movie API");
                    a.setContentText(e.getMessage());
                    a.show();
                }
            }
            else if(event.getSource()==searchTriviaBtn) {
                DemoGetRESTAPI mas=new DemoGetRESTAPI();
                try {
                    List<Result> triviaList = mas.searchTrivia();

                    List<Result> items = triviaTableView.getItems();
                    items.clear();

//                    for (MovieInfo movie:movieList) {
//                        items.add(movie);
//                    }


                }catch(TriviaAPIException e) {
                    Alert a =new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error calling Movie API");
                    a.setContentText(e.getMessage());
                    a.show();
                }
            }
            else if (event.getSource()==backBtn) {
                HelloApplication.primaryStage.setScene(HelloApplication.mainScene);
            }

        }

    }