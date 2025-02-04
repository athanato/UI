module org.ui.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Triviapp;
    requires javafx.graphics;


    opens org.ui.ui to javafx.fxml;
    exports org.ui.ui;
}