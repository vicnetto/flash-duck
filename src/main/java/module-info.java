module com.codeine.codingweek {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens com.codeine.codingweek to javafx.fxml, com.google.gson;
    exports com.codeine.codingweek;
}