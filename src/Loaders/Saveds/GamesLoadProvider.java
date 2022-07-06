package Loaders.Saveds;

import Table.TableManager;

import java.io.*;

public class GamesLoadProvider {
    File file;

    public GamesLoadProvider(File file) {
        this.file = file;
    }

    public TableManager loadGame() {
        TableManager tableManager = new TableManager();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            tableManager = (TableManager) reader.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tableManager;
    }
    public void saveGame(TableManager tableManager){
        try(ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(file))) {
        writer.writeObject(tableManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
