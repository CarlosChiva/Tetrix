package Providers;

import com.google.gson.Gson;
import Table.TableManager;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class GamesLoadProvider {
    Gson gson = new Gson();
    String nameFile = "./GamesSaved/";
    File fil = new File(nameFile);
    File[] arrayFiles;

    public GamesLoadProvider() {
    }

    public TableManager loadGame(String game) {
        String urlGame = nameFile.concat(game);
        TableManager tableGame = new TableManager();
        try (FileReader reader = new FileReader(urlGame)) {
            final Type gamePanel = new TypeToken<TableManager>() {
            }.getType();
            tableGame = gson.fromJson(reader, gamePanel);
            if (tableGame == null) {
                return new TableManager();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tableGame;
    }

    public void saveGame(TableManager gamePanel, String namFile) {
        String newFile = nameFile.concat(namFile);
        try (FileWriter writer = new FileWriter(newFile+".json")) {
            writer.write(gson.toJson(gamePanel));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> listGameSaved() {

        arrayFiles = fil.listFiles();
        ArrayList<String> list = new ArrayList<>();
        if (arrayFiles != null) {
            for (File arrayFiles : arrayFiles) {
                list.add(arrayFiles.getName().replace(".json",""));
            }
        }
        return list;
    }
}
