package com.codeine.codingweek;

import com.codeine.codingweek.model.FlashCardGame;
import com.codeine.codingweek.model.Pile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
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

        button_valider.setDisable(!isValidForm());

        MutableDouble x = new MutableDouble(0) ;
        MutableDouble y = new MutableDouble(0) ;

        // Ajout d'une popup avec la liste
        Popup popup = new Popup() ;

        textarea_c.setOnMouseClicked(event -> {

            popup.hide() ;
            x.set(event.getScreenX()) ;
            y.set(event.getScreenY()) ;

            ListView<Label> list = new ListView<Label>() ;

            for (String option : getAutocompleteOptions()) {
                if (option.startsWith(textarea_c.getText())) {
                    list.getItems().add(new Label(option)) ;
                }
            }

            list.setOnMouseClicked(eventlist -> {
                if (list.getSelectionModel().getSelectedItem() != null) 
                    textarea_c.setText(list.getSelectionModel().getSelectedItem().getText()) ;
                button_valider.setDisable(!isValidForm());
                popup.hide() ;
            });

            list.setOnKeyPressed(eventlistkey -> {
                popup.hide() ;
            }) ;

            popup.getContent().add(list) ;

            popup.show(textarea_c, x.get()+20, y.get()+60) ;

        });

        textarea_c.setOnKeyPressed(event -> {

            if (event.getCode() == KeyCode.TAB) {
                event.consume();
                popup.hide() ;

                int caretPosition = textarea_c.getCaretPosition();
                String text = textarea_c.getText();
                text = text.replaceAll("\t", "");

                // On cherche une auto-complétion qui correspond
                for (String option : getAutocompleteOptions()) {
                    if (option.startsWith(text)) {

                        textarea_c.insertText(caretPosition - 1, option.substring(text.length()));
                        textarea_c.setText(textarea_c.getText().replaceAll("\t", ""));
                        textarea_c.positionCaret(textarea_c.getLength());
                        break;

                    }
                }
            } else {

                popup.hide() ;

                ListView<Label> list = new ListView<Label>() ;

                for (String option : getAutocompleteOptions()) {
                    if (option.startsWith(textarea_c.getText())) {
                        list.getItems().add(new Label(option)) ;
                    }
                }

                list.setOnMouseClicked(eventlist -> {
                    if (list.getSelectionModel().getSelectedItem() != null) 
                        textarea_c.setText(list.getSelectionModel().getSelectedItem().getText()) ;
                    button_valider.setDisable(!isValidForm());
                    popup.hide() ;
                });

                list.setOnKeyPressed(eventlistkey -> {
                    popup.hide() ;
                }) ;

                popup.getContent().add(list) ;

                if (!list.getItems().isEmpty())
                    popup.show(textarea_c, x.get()+20, y.get()+60) ;

            }
        });

        textarea_t.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
        textarea_c.setOnKeyReleased(event -> {
            button_valider.setDisable(!isValidForm());
        });
//        textarea_t.setOnMouseClicked(event -> {
//            button_valider.setDisable(!isValidForm());
//        });
//        textarea_c.setOnMouseClicked(event -> {
//            button_valider.setDisable(!isValidForm());
//        });
    }

    private List<String> getAutocompleteOptions() {
        // Termes possibles de l'auto-complétion
        return fcg.getCategories();
    }

    public void annuler() throws IOException {
        ViewSwitcher.switchTo(View.PILE_CREATION);
    }

    public void ajouterPile(ActionEvent actionEvent) throws IOException {
        if (isValidForm()) {
            String titre = this.textarea_t.getText();
            String categorie = this.textarea_c.getText().replaceAll("\t", "");
            this.fcg.addPile(new Pile(categorie, titre));
            ViewSwitcher.switchTo(View.PILE_CREATION);
        }
    }

    private boolean isValidForm() {
        return !Objects.equals(this.textarea_t.getText(), "") && !Objects.equals(this.textarea_c.getText(), "");
    }
}
