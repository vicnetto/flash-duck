module com.codeine.codingweek {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires java.desktop;

    opens com.codeine.codingweek to javafx.fxml, com.google.gson;
    exports com.codeine.codingweek;
    exports com.codeine.codingweek.PatternStrategyQuestions;
    opens com.codeine.codingweek.PatternStrategyQuestions to com.google.gson, javafx.fxml;
    exports com.codeine.codingweek.model;
    opens com.codeine.codingweek.model to com.google.gson, javafx.fxml;
}