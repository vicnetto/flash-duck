package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificationCarteController implements Initializable {


    public TextArea textarea_q;
    public TextArea textarea_r;

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
    }

    public void annuler(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.swtichTo(View.CARTE_CREATION);
    }

    public void modifierCarte(ActionEvent actionEvent) throws IOException {
        this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).
                getCards().get(this.fcg.getCurrentCarte()).setQuestion(this.textarea_q.getText());
        this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).
                getCards().get(this.fcg.getCurrentCarte()).setReponse(this.textarea_r.getText());
        ViewSwitcher.swtichTo(View.CARTE_CREATION);
    }
}
