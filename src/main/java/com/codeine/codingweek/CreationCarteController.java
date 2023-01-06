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
import javafx.stage.Stage;

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
    private VBox vBox_principale;

    @FXML
    private Button button_annuler ;

    @FXML
    private String filePath;

    @FXML
    private Button button_valider ;

    @FXML
    private HBox hBox;

    private FlashCardGame fcg;

    private MediaPlayer mediaPlayer;
    private Stage stage;

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

    public void onViewUnloaded() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }


    public void ajouterImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers d'image", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(button_image_question.getScene().getWindow());
        if (file != null) {
            vBox.setVisible(false);
            filePath = file.getAbsolutePath();
            Image image = new Image("file://" + filePath);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);
            Button resetButton = new Button();
            ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
            imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
            resetButton.setGraphic(imageViewReset);
            resetButton.setOnAction(event -> {
                filePath = null;
                vBox_file.getChildren().removeAll(imageView, resetButton);
                vBox.setVisible(true);
                onViewUnloaded();
            });
            vBox_file.getChildren().addAll(imageView,resetButton);

        }
    }

    public void ajouterImageReponse(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers d'image", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(button_image_reponse.getScene().getWindow());
        if (file != null) {
            vBox_reponse.setVisible(false);
            filePath = file.getAbsolutePath();
            Image image = new Image("file://" + filePath);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(400);
            imageView.setPreserveRatio(true);
            Button resetButton = new Button();
            ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
            imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
            resetButton.setGraphic(imageViewReset);
            resetButton.setOnAction(event -> {
                filePath = null;
                vBox_file_reponse.getChildren().removeAll(imageView, resetButton);
                vBox_reponse.setVisible(true);
                onViewUnloaded();
            });
            vBox_file_reponse.getChildren().addAll(imageView,resetButton);
        }
    }

    public void ajouterVideo(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers video", "*.MP4","*.avi", "*.mkv"));
        File file = fileChooser.showOpenDialog(button_video_question.getScene().getWindow());
        if (file != null) {
            vBox.setVisible(false);
            filePath = file.getAbsolutePath();
            Media media = new Media("file://" + filePath);
            this.mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(this.mediaPlayer);
            mediaView.setFitWidth(400);
            mediaView.setPreserveRatio(true);
            Button playButton = new Button();
            ImageView imageViewPlay = new ImageView(new Image(getClass().getResource("images/play_logo.png").toExternalForm()));
            imageViewPlay.setFitHeight(30);imageViewPlay.setFitWidth(30);
            playButton.setGraphic(imageViewPlay);
            playButton.setOnAction(event -> mediaPlayer.play());
            Button pauseButton = new Button();
            ImageView imageViewPause = new ImageView(new Image(getClass().getResource("images/pause_logo.png").toExternalForm()));
            imageViewPause.setFitHeight(30);imageViewPause.setFitWidth(30);
            pauseButton.setGraphic(imageViewPause);
            pauseButton.setOnAction(event -> mediaPlayer.pause());
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(playButton,pauseButton);
            Button resetButton = new Button();
            ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
            imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
            resetButton.setGraphic(imageViewReset);
            resetButton.setOnAction(event -> {
                filePath = null;
                vBox_file.getChildren().removeAll(mediaView, hBox, resetButton);
                vBox.setVisible(true);
                onViewUnloaded();

            });
            vBox_file.getChildren().addAll(mediaView,hBox,resetButton);
        }
    }

    public void ajouterVideoReponse(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers video", "*.MP4","*.avi", "*.mkv"));
        File file = fileChooser.showOpenDialog(button_video_reponse.getScene().getWindow());
        if (file != null) {
            vBox_reponse.setVisible(false);
            filePath = file.getAbsolutePath();
            Media media = new Media("file://" + filePath);
            this.mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(this.mediaPlayer);
            mediaView.setFitWidth(400);
            mediaView.setPreserveRatio(true);
            Button playButton = new Button();
            ImageView imageViewPlay = new ImageView(new Image(getClass().getResource("images/play_logo.png").toExternalForm()));
            imageViewPlay.setFitHeight(30);imageViewPlay.setFitWidth(30);
            playButton.setGraphic(imageViewPlay);
            playButton.setOnAction(event -> mediaPlayer.play());
            Button pauseButton = new Button();
            ImageView imageViewPause = new ImageView(new Image(getClass().getResource("images/pause_logo.png").toExternalForm()));
            imageViewPause.setFitHeight(30);imageViewPause.setFitWidth(30);
            pauseButton.setGraphic(imageViewPause);
            pauseButton.setOnAction(event -> mediaPlayer.pause());
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(playButton,pauseButton);
            Button resetButton = new Button();
            ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
            imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
            resetButton.setGraphic(imageViewReset);
            resetButton.setOnAction(event -> {
                filePath = null;
                vBox_file_reponse.getChildren().removeAll(mediaView, hBox, resetButton);
                vBox_reponse.setVisible(true);
                onViewUnloaded();

            });
            vBox_file_reponse.getChildren().addAll(mediaView,hBox,resetButton);
        }
    }

    public void ajouterAudio() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers audio", "*.mp3", "*.wav", "*.aac"));
        File file = fileChooser.showOpenDialog(button_audio_question.getScene().getWindow());
        if (file != null) {
            vBox.setVisible(false);
            filePath = file.getAbsolutePath();
            Media media = new Media("file://" + filePath);
            this.mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(this.mediaPlayer);
            mediaView.setFitWidth(400);
            mediaView.setPreserveRatio(true);
            Button playButton = new Button();
            ImageView imageViewPlay = new ImageView(new Image(getClass().getResource("images/play_logo.png").toExternalForm()));
            imageViewPlay.setFitHeight(30);imageViewPlay.setFitWidth(30);
            playButton.setGraphic(imageViewPlay);
            playButton.setOnAction(event -> mediaPlayer.play());
            Button pauseButton = new Button();
            ImageView imageViewPause = new ImageView(new Image(getClass().getResource("images/pause_logo.png").toExternalForm()));
            imageViewPause.setFitHeight(30);imageViewPause.setFitWidth(30);
            pauseButton.setGraphic(imageViewPause);
            pauseButton.setOnAction(event -> mediaPlayer.pause());
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(playButton,pauseButton);
            Button resetButton = new Button();
            ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
            imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
            resetButton.setGraphic(imageViewReset);

            resetButton.setOnAction(event -> {
                filePath = null;
                vBox_file.getChildren().removeAll(mediaView, hBox, resetButton);
                vBox.setVisible(true);
                onViewUnloaded();
            });
            vBox_file.getChildren().addAll(mediaView,hBox, resetButton);
        }
    }

    public void ajouterAudioReponse() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers audio", "*.mp3", "*.wav", "*.aac"));
        File file = fileChooser.showOpenDialog(button_audio_reponse.getScene().getWindow());
        if (file != null) {
            vBox_reponse.setVisible(false);
            filePath = file.getAbsolutePath();
            Media media = new Media("file://" + filePath);
            this.mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(this.mediaPlayer);
            mediaView.setFitWidth(400);
            mediaView.setPreserveRatio(true);
            Button playButton = new Button();
            ImageView imageViewPlay = new ImageView(new Image(getClass().getResource("images/play_logo.png").toExternalForm()));
            imageViewPlay.setFitHeight(30);imageViewPlay.setFitWidth(30);
            playButton.setGraphic(imageViewPlay);
            playButton.setOnAction(event -> mediaPlayer.play());
            Button pauseButton = new Button();
            ImageView imageViewPause = new ImageView(new Image(getClass().getResource("images/pause_logo.png").toExternalForm()));
            imageViewPause.setFitHeight(30);imageViewPause.setFitWidth(30);
            pauseButton.setGraphic(imageViewPause);
            pauseButton.setOnAction(event -> mediaPlayer.pause());
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().addAll(playButton,pauseButton);
            Button resetButton = new Button();
            ImageView imageViewReset = new ImageView(new Image(getClass().getResource("images/trash.png").toExternalForm()));
            imageViewReset.setFitHeight(30);imageViewReset.setFitWidth(30);
            resetButton.setGraphic(imageViewReset);
            resetButton.setOnAction(event -> {
                filePath = null;
                vBox_file_reponse.getChildren().removeAll(mediaView, hBox, resetButton);
                vBox_reponse.setVisible(true);
                onViewUnloaded();
            });
            vBox_file_reponse.getChildren().addAll(mediaView,hBox, resetButton);
        }
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
