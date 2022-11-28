module com.example.findtheodd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.findtheodd to javafx.fxml;
    exports com.example.findtheodd;
}