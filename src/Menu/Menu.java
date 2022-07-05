package Menu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Menu.MenuEnums.*;

public class Menu extends JFrame {
    JPanel panel = new JPanel();

    public Menu() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        loadMainPanel();
        loadComponentsFirstWindow();

    }

    public void loadMainPanel() {
        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
    }

    public void load(Enum enums) {
        if (enums == PRINCIPAL) {
            loadMainPanel();
        } else if (enums == RANKING) {
            // loadRankingMenu();
        } else if (enums == LOADGAME) {
            //loadLoadGame();
        } else if (enums == STARTGAME) {
            //loadGameMenu();
        }
    }

    public void loadComponentsFirstWindow() {
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Hi Gamer \n  What do you want?");
        etiqueta.setBounds(150, 100, 200, 100);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);
        loadButtonOfFirstWindow();
    }

    public void loadButtonOfFirstWindow() {
        StartGame startGame = new StartGame();
        LoadGame loadGame = new LoadGame();
        ViewRanking viewRanking = new ViewRanking();
        panel.add(startGame.getStartGame());
        panel.add(loadGame.getLoadGame());
        panel.add(viewRanking.getViewRanking());

    }

}
