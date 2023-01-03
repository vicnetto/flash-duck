module com.codeine.codingweek {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.codeine.codingweek to javafx.fxml;
    exports com.codeine.codingweek;
}