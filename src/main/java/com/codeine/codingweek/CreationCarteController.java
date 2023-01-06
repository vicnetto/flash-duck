package com.codeine.codingweek;

import com.codeine.codingweek.model.Card;
import com.codeine.codingweek.model.FlashCardGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
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
    private Button button_image_question ;
    @FXML
    private Button button_video_question;
    @FXML
    private Button button_audio_question;
    @FXML
    private Button button_image_reponse ;
    @FXML
    private Button button_video_reponse;
    @FXML
    private Button button_audio_reponse;
    @FXML
    private VBox vBox;
    @FXML
    private VBox vBox_reponse;

    @FXML
    private VBox vBox_file;
    @FXML
    private VBox vBox_file_reponse;

    @FXML
    private Button button_valider ;

    private String filePath;
    private FlashCardGame fcg;

    private MediaPlayer mediaPlayer;

    public CreationCarteController(FlashCardGame fcg) {
        this.fcg = fcg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_valider.setDisable(!isValidForm());
        textarea_q.setOnKeyReleased(event -> button_valider.setDisable(!isValidForm()));
        textarea_r.setOnKeyReleased(event -> button_valider.setDisable(!isValidForm()));

    }

    public void onViewUnloaded() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }


    public void ajouterImageQuestion(){
        ajouterImage(vBox, vBox_file, button_image_question);
    }

    public void ajouterImageReponse(){
        ajouterImage(vBox_reponse, vBox_file_reponse, button_image_reponse);
    }

    public void ajouterImage(VBox first, VBox second, Button button) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers d'image", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(button.getScene().getWindow());

        if (file != null) {
            first.setVisible(false);
            filePath = file.getAbsolutePath();

            Image image = new Image("file://" + filePath);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);

            Button resetButton = createResetButton();
            resetButton.setOnAction(event -> {
                filePath = null;
                second.getChildren().removeAll(imageView, resetButton);
                first.setVisible(true);
                onViewUnloaded();
            });

            second.getChildren().addAll(imageView,resetButton);
        }
    }

    public void ajouterVideoQuestion(){
        ajouterVideo(vBox, vBox_file, button_video_question);
    }

    public void ajouterVideoReponse(){
        ajouterVideo(vBox_reponse, vBox_file_reponse, button_video_reponse);
    }

    public void ajouterVideo(VBox first, VBox second, Button button) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers video", "*.MP4","*.avi", "*.mkv"));

        ajouterVideoOuAudio(first, second, fileChooser, button);
    }

    public void ajouterAudioQuestion() {
        ajouterAudio(vBox, vBox_file, button_audio_question);
    }

    public void ajouterAudioReponse() {
        ajouterAudio(vBox_reponse, vBox_file_reponse, button_audio_reponse);
    }

    public void ajouterAudio(VBox first, VBox second, Button button) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers audio", "*.mp3", "*.wav", "*.aac"));

        ajouterVideoOuAudio(first, second, fileChooser, button);
    }

    private void ajouterVideoOuAudio(VBox first, VBox second, FileChooser fileChooser, Button button) {
        File file = fileChooser.showOpenDialog(button.getScene().getWindow());

        if (file != null) {
            first.setVisible(false);

            filePath = file.getAbsolutePath();

            Media media = new Media("file://" + filePath);
            this.mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(this.mediaPlayer);
            mediaView.setFitWidth(400);
            mediaView.setPreserveRatio(true);

            Button playButton = createPlayButton();
            Button pauseButton = createPauseButton();

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(playButton,pauseButton);

            Button resetButton = createResetButton();
            resetButton.setOnAction(event -> {
                filePath = null;
                second.getChildren().removeAll(mediaView, hBox, resetButton);
                first.setVisible(true);
                onViewUnloaded();

            });

            second.getChildren().addAll(mediaView,hBox,resetButton);
        }
    }

    public Button createPlayButton() {
        Button playButton = new Button();
        ImageView imageViewPlay = new ImageView(new Image(getClass().getResource("images/play_logo.png").toExternalForm()));
        imageViewPlay.setFitHeight(30);imageViewPlay.setFitWidth(30);
        playButton.setGraphic(imageViewPlay);
        playButton.setOnAction(event -> mediaPlayer.play());

        return playButton;
    }

    public Button createPauseButton() {
        Button pauseButton = new Button();
        ImageView imageViewPause = new ImageView(new Image(getClass().getResource("images/pause_logo.png").toExternalForm()));
        imageViewPause.setFitHeight(30);imageViewPause.setFitWidth(30);
        pauseButton.setGraphic(imageViewPause);
        pauseButton.setOnAction(event -> mediaPlayer.pause());

        return pauseButton;
    }

    public Button createResetButton() {
        Button resetButton = new Button();
        ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
        imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
        resetButton.setGraphic(imageViewReset);

        return resetButton;
    }


    public void ajouterCarte() throws IOException {
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
