package Providers;
import Menu.GamePanel;
import com.google.gson.Gson;
import Table.TableManager;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;


public class GamesLoadProvider {
    Gson gson=new Gson();
String file="./GameSaved/";
    public GamesLoadProvider() {
    }

    public TableManager loadGame() {
        TableManager tableGame = new TableManager();
        try (FileReader reader = new FileReader("./GamesSaved/Partida1.json")) {
            final Type gamePanel = new TypeToken<TableManager>() {}.getType();
            tableGame = gson.fromJson(reader,gamePanel);
            if (tableGame==null){
                return new TableManager();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tableGame;
    }
    public void saveGame(TableManager gamePanel){
        try(FileWriter writer=new FileWriter("./GamesSaved/Partida1.json")) {
        writer.write(gson.toJson(gamePanel));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
