package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ModificationPileController implements Initializable {


    @FXML
    public TextArea textarea_t;
    @FXML
    public TextArea textarea_c;
    @FXML
    public Button button_valider;

    private FlashCardGame fcg;

    public ModificationPileController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.textarea_t.setText(this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).getName());
        this.textarea_c.setText(this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).getCategory());

        button_valider.setDisable(!isValidForm());
        textarea_t.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
        textarea_c.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
    }

    public void annuler(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.switchTo(View.CARTE_CREATION);
    }

    public void modifierPile(ActionEvent actionEvent) throws IOException {
        if (isValidForm()) {
            this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).setName(this.textarea_t.getText());
            this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).setCategory(this.textarea_c.getText());
            ViewSwitcher.switchTo(View.CARTE_CREATION);
        }
    }

    private boolean isValidForm() {
        return !Objects.equals(this.textarea_t.getText(), "") && !Objects.equals(this.textarea_c.getText(), "");
    }
}
