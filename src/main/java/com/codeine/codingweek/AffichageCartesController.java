package com.codeine.codingweek;

import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AffichageCartesController implements Initializable {

    @FXML
    public VBox vBoxCartes;
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
            VBox leftBox = new VBox();
            leftBox.setPrefWidth(700);

            Label question = new Label(carte.getQuestion());
            Label reponse = new Label(carte.getReponse());
            leftBox.getChildren().add(question);
            leftBox.getChildren().add(reponse);

            leftBox.setPadding(new Insets(10, 0, 10, 0)) ;
            leftBox.setStyle("-fx-border-color: black; -fx-border-radius: 20; -fx-spacing: 10px; -fx-background-color: #f3f6dd;") ;
            leftBox.setAlignment(Pos.CENTER) ;
            
            int copieI = i;
            VBox rightBox = new VBox();

            ImageView imView = new ImageView(getClass().getResource("images/trash.png").toExternalForm()) ;

            imView.setPreserveRatio(true) ;
            imView.setPickOnBounds(true) ;
            imView.setFitHeight(40);
            imView.setFitWidth(40);

            Button delete = new Button();
            delete.setOnMouseClicked(e -> supprimerCarte(copieI));
            delete.getStyleClass().add("icone_button") ;
            delete.setGraphic(imView) ;
            rightBox.getChildren().add(delete);

            imView = new ImageView(getClass().getResource("images/edit.png").toExternalForm()) ;

            imView.setPreserveRatio(true) ;
            imView.setPickOnBounds(true) ;
            imView.setFitHeight(40);
            imView.setFitWidth(40);

            Button modify = new Button();
            modify.setOnMouseClicked((e)-> {
                try {
                    goToModificationFormCarte(copieI);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            modify.getStyleClass().add("icone_button") ;
            modify.setGraphic(imView) ;
            rightBox.getChildren().add(modify);

            HBox hBox = new HBox(leftBox, rightBox);
            this.vBoxCartes.getChildren().addAll(hBox);
            i++;
        }
    }

    

    public void goToFormCarte() throws IOException {
        ViewSwitcher.swtichTo(View.FORM_CARTE);
    }

    public void retour() throws  IOException{
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }

    public void goToModificationFormCarte(int i) throws IOException {
        this.fcg.setCurrentCarte(i);
        ViewSwitcher.swtichTo(View.FORM_MODIFICATION_CARTE);
    }

    public void supprimerCarte(int i) {

        this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).deleteCarteByIndex(i);
        this.vBoxCartes.getChildren().remove(this.vBoxCartes.getChildren().get(i));

        for (int j = 0; j < this.vBoxCartes.getChildren().size(); j++) {
            HBox hb = (HBox) this.vBoxCartes.getChildren().get(j);
            Button suppr = (Button) ((VBox) hb.getChildren().get(1)).getChildren().get(0);
            int copieJ = j;
            suppr.setOnMouseClicked((e) -> supprimerCarte(copieJ));
            Button modif = (Button) ((VBox) hb.getChildren().get(1)).getChildren().get(1);
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
        if (System.getProperty("os.name").startsWith("Windows")) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException |
                     ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
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

    public void supprimerPile(ActionEvent actionEvent) throws IOException {
        fcg.removePileByIndex(fcg.getCurrentPile());
        ViewSwitcher.swtichTo(View.PILE_CREATION);
    }

    public void editerPile(ActionEvent actionEvent) {
    }
}
