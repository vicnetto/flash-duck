package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CreationPileController implements Initializable {

    private FlashCardGame fcg;

    @FXML
    private TextArea textarea_t ;
    @FXML
    private TextArea textarea_c ;

    @FXML
    private Button button_annuler ;

    @FXML
    private Button button_valider ;

    public CreationPileController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textarea_c.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.TAB) {
                event.consume();

                int caretPosition = textarea_c.getCaretPosition();
                String text = textarea_c.getText();
                text = text.replaceAll("\t", "");

                // On cherche une auto-complétion qui correspond
                for (String option : getAutocompleteOptions()) {
                    if (option.startsWith(text)) {
                        textarea_c.insertText(caretPosition - 1, option.substring(text.length()));
                        break;
                    }
                }
            }
        });

    }

    private List<String> getAutocompleteOptions() {
        // Termes possibles de l'auto-complétion
        return Arrays.asList("Histoire", "Art", "Musique", "Cinéma", "Gastronomie", "Sport", "Science", "Littérature");
    }

    public void annuler(ActionEvent actionEvent) throws  IOException {
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }

    public void ajouterPile(ActionEvent actionEvent) throws IOException {
        String titre = this.textarea_t.getText();
        String categorie = this.textarea_c.getText();
        this.fcg.addPile(new Pile(categorie, titre));
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }
}
