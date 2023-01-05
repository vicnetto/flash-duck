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

public class ModificationCarteController implements Initializable {


    @FXML
    public TextArea textarea_q;
    @FXML
    public TextArea textarea_r;
    @FXML
    public Button button_valider;

    private FlashCardGame fcg;

    public ModificationCarteController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.textarea_q.setText(this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).
                getCards().get(this.fcg.getCurrentCarte()).getQuestion());
        this.textarea_r.setText(this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).
                getCards().get(this.fcg.getCurrentCarte()).getReponse());

        button_valider.setDisable(!isValidForm());
        textarea_q.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
        textarea_r.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
    }

    public void annuler(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.switchTo(View.CARTE_CREATION);
    }

    public void modifierCarte(ActionEvent actionEvent) throws IOException {
        if (isValidForm()) {
            this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).
                    getCards().get(this.fcg.getCurrentCarte()).setQuestion(this.textarea_q.getText());
            this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).
                    getCards().get(this.fcg.getCurrentCarte()).setReponse(this.textarea_r.getText());
            ViewSwitcher.switchTo(View.CARTE_CREATION);
        }
    }

    private boolean isValidForm() {
        return !Objects.equals(this.textarea_q.getText(), "") && !Objects.equals(this.textarea_r.getText(), "");
    }
}
