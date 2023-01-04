package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreationPileController implements Initializable {

    private FlashCardGame fcg;

    @FXML
    private TextArea textarea_t ;

    @FXML
    private Button button_annuler ;

    @FXML
    private Button button_valider ;

    public CreationPileController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void annuler(ActionEvent actionEvent) throws  IOException {
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }

    public void ajouterPile(ActionEvent actionEvent) throws IOException {
        String titre = this.textarea_t.getText();
        System.out.println(titre);
        this.fcg.addPile(new Pile("Catégorie inconnue", titre));
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }
}
