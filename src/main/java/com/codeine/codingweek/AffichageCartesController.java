package com.codeine.codingweek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AffichageCartesController implements Initializable {

    @FXML
    public VBox gridCartes;
    @FXML
    private ScrollPane scrollPane ;

    private FlashCardGame fcg;

    public AffichageCartesController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int i = 0;
        for (Card carte : this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).getCards()) {
            VBox vb = new VBox();
            Label question = new Label(carte.getQuestion());
            Label reponse = new Label(carte.getReponse());
            vb.getChildren().add(question);
            vb.getChildren().add(reponse);

            vb.setPadding(new Insets(10, 0, 10, 0)) ;
            vb.setStyle("-fx-border-color: black; -fx-border-radius: 20; -fx-spacing: 10px;") ;
            vb.setAlignment(Pos.CENTER) ;
            
            Button suppr = new Button("Supprimer");
            int copieI = i;
            suppr.setOnMouseClicked((e) -> {supprimerCarte(copieI);});
            vb.getChildren().add(suppr);
            Button modif = new Button("Éditer");
            modif.setOnMouseClicked((e)-> {
                try {
                    goToModificationFormCarte(copieI);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            suppr.getStyleClass().add("bottom_button") ;
            modif.getStyleClass().add("bottom_button") ;
            
            vb.getChildren().add(modif);
            this.gridCartes.getChildren().add(vb);
            i++;
        }
    }

    public void goToFormCarte(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.swtichTo(View.FORM_CARTE);
    }

    public void retour(ActionEvent actionEvent) throws  IOException{
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }

    public void goToModificationFormCarte(int i) throws IOException {
        this.fcg.setCurrentCarte(i);
        ViewSwitcher.swtichTo(View.FORM_MODIFICATION_CARTE);
    }

    public void supprimerCarte(int i) {

        this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).deleteCarteByIndex(i);
        this.gridCartes.getChildren().remove(this.gridCartes.getChildren().get(i));

        for (int j = 0; j < this.gridCartes.getChildren().size(); j++) {
            VBox vb = (VBox) this.gridCartes.getChildren().get(j);
            Button suppr = (Button) vb.getChildren().get(2);
            int copieJ = j;
            suppr.setOnMouseClicked((e) -> {supprimerCarte(copieJ);});
            Button modif = (Button) vb.getChildren().get(3);
            modif.setOnMouseClicked((e) ->{
                try {
                    goToModificationFormCarte(copieJ);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    public void exporterPile(ActionEvent actionEvent) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Sélectionnez un emplacement");
        chooser.setCurrentDirectory(new File("/"));
        chooser.setFileFilter(new FileNameExtensionFilter("JSON", "json"));
        int dialog = chooser.showSaveDialog(null);
        if (dialog == JFileChooser.APPROVE_OPTION) {
            try {
                JsonController jsonController = new JsonController(chooser.getSelectedFile().toString() + ".json");
                jsonController.writeNewPile(this.fcg.getLesPiles().get(this.fcg.getCurrentPile()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
