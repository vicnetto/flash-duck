package com.codeine.codingweek;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonController {
    String path; // Chemin du fichier json

    JsonController(String path) {
        this.path = path;
    }

    /**
     * Sauvegarde la pile dans le fichier
     * @param newPile la pile à sauvegarder
     */
    void writeNewPile(Pile newPile) {
        // TODO: si le fichier n'existe pas, le créer
        Gson gson = new Gson();
        try (FileWriter file = new FileWriter(path)) {
            file.write(gson.toJson(newPile));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Renvoie la pile contenue dans le fichier
     * @return la pile contenue dans le fichier
     */
    Pile getPile() {
        Gson gson = new Gson();
        String content = null;

        try {
            content = Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return (gson.fromJson(content, Pile.class));
        } catch (JsonSyntaxException e) {
            return null;
        }
    }
}
