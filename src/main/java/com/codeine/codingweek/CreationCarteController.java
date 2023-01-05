package com.codeine.codingweek;

import com.codeine.codingweek.model.Card;
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

public class CreationCarteController implements Initializable {

    @FXML
    private TextArea textarea_q ;

    @FXML
    private TextArea textarea_r ;

    @FXML
    private Button button_annuler ;

    @FXML
    private Button button_valider ;

    private FlashCardGame fcg;

    public CreationCarteController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_valider.setDisable(!isValidForm());
        textarea_q.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
        textarea_r.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
    }


    public void ajouterCarte(ActionEvent actionEvent) throws IOException {
        if (isValidForm()) {
            this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).addCarte(new Card(this.textarea_q.getText(), this.textarea_r.getText()));
            ViewSwitcher.switchTo(View.CARTE_CREATION);
        }
    }

    public void annuler() throws IOException {
        ViewSwitcher.switchTo(View.CARTE_CREATION);
    }

    private boolean isValidForm() {
        return !Objects.equals(this.textarea_q.getText(), "") && !Objects.equals(this.textarea_r.getText(), "");
    }
}
