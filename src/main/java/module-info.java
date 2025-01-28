module org.ui.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Triviapp;


    opens org.ui.ui to javafx.fxml;
    exports org.ui.ui;
}