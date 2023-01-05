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
import javafx.scene.control.Tooltip;
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
    private HBox stackInformation;

    @FXML
    private HBox stackActions;

    @FXML
    private VBox vBoxCartes;

    @FXML
    private ScrollPane scrollPane ;

    private FlashCardGame fcg;

    public AffichageCartesController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Button deleteStack = createDeleteButton();
        deleteStack.setTooltip(new Tooltip("Supprimer la pile"));
        deleteStack.setOnMouseClicked(e -> {
            try {
                supprimerPile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Label label = new Label("Pile " + this.fcg.getLesPiles().get(this.fcg.getCurrentPile()).getName());
        label.getStyleClass().add("text");
        stackInformation.getChildren().add(label);

        Button editStack = createModifyButton();
        editStack.setTooltip(new Tooltip("Éditer la pile"));
        editStack.setOnMouseClicked(e -> {
            try {
                editerPile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        stackActions.getChildren().addAll(editStack, deleteStack);

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

            Button modify = createModifyButton();
            modify.setTooltip(new Tooltip("Éditer la carte"));
            modify.setOnMouseClicked(e-> {
                try {
                    goToModificationFormCarte(copieI);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            rightBox.getChildren().add(modify);

            Button delete = createDeleteButton();
            delete.setTooltip(new Tooltip("Supprimer la carte"));
            delete.setOnMouseClicked(e -> supprimerCarte(copieI));
            rightBox.getChildren().add(delete);

            HBox hBox = new HBox(leftBox, rightBox);
            this.vBoxCartes.getChildren().addAll(hBox);
            i++;
        }
    }

    public void goToFormCarte() throws IOException {
        ViewSwitcher.switchTo(View.FORM_CARTE);
    }

    public void retour() throws  IOException{
        ViewSwitcher.switchTo(View.PILE_CREATION);
    }

    public void goToModificationFormCarte(int i) throws IOException {
        this.fcg.setCurrentCarte(i);
        ViewSwitcher.switchTo(View.FORM_MODIFICATION_CARTE);
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

    public void supprimerPile() throws IOException {
        fcg.removePileByIndex(fcg.getCurrentPile());
        ViewSwitcher.switchTo(View.PILE_CREATION);
    }

    public void editerPile() throws IOException {
        ViewSwitcher.switchTo(View.FORM_MODIFICATION_PILE);
    }

    public Button createModifyButton() {
        ImageView imView = new ImageView(getClass().getResource("images/edit.png").toExternalForm()) ;

        imView.setPreserveRatio(true) ;
        imView.setPickOnBounds(true) ;
        imView.setFitHeight(40);
        imView.setFitWidth(40);

        Button modify = new Button();
//        modify.getStyleClass().add("icone_button") ;
        modify.setGraphic(imView) ;

        modify.getStyleClass().add("icone_button");
        modify.setOnMouseEntered(action -> {
            modify.getStyleClass().clear();
            modify.getStyleClass().add("icone_button");
            modify.getStyleClass().add("icone_button_entered");});
        modify.setOnMouseExited(action -> {
            modify.getStyleClass().clear();
            modify.getStyleClass().add("icone_button");
            modify.getStyleClass().add("icone_button_exited");});

        return modify;
    }

    public Button createDeleteButton() {
        ImageView imView = new ImageView(getClass().getResource("images/trash.png").toExternalForm());

        imView.setPreserveRatio(true) ;
        imView.setPickOnBounds(true) ;
        imView.setFitHeight(40);
        imView.setFitWidth(40);

        Button delete = new Button();
        delete.setGraphic(imView) ;
        delete.setTooltip(new Tooltip("Supprimer la pile"));
        delete.getStyleClass().add("icone_button");
        delete.setOnMouseEntered(action -> {
                delete.getStyleClass().clear();
                delete.getStyleClass().add("icone_button");
                delete.getStyleClass().add("icone_button_entered");});
        delete.setOnMouseExited(action -> {
            delete.getStyleClass().clear();
            delete.getStyleClass().add("icone_button");
            delete.getStyleClass().add("icone_button_exited");});

        return delete;
    }
}
