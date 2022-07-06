package Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MainMenu extends JFrame {
    ArrayList<Component> arrayList = new ArrayList<>();
    JLabel etiqueta;
    JButton startGame;
    JButton loadGame;
    JButton viewRanking;

    public MainMenu() {
        inicializeButtons();
    }


    private void inicializeButtons() {
        arrayList.add(firstText());
        arrayList.add(startGameButton());
        arrayList.add(loadGameButton());
        arrayList.add(viewRankingButton());


    }

    public ArrayList<Component> getArrayList() {
        return arrayList;
    }

    public JLabel firstText() {
        etiqueta = new JLabel();
        etiqueta.setText("Hi Gamer \n  What do you want?");
        etiqueta.setBounds(150, 100, 200, 100);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
        return etiqueta;

    }

    public JButton startGameButton() {
        startGame = new JButton();
        startGame.setText("Start Game");
        startGame.setEnabled(true);
        startGame.setBounds(180, 230, 110, 60);
        startGame.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);

        return startGame;
    }

    public JButton loadGameButton() {
        loadGame = new JButton();
        loadGame.setText("Load Game");
        loadGame.setEnabled(true);
        loadGame.setBounds(180, 300, 110, 60);
        loadGame.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
        return loadGame;
    }

    public JButton viewRankingButton() {
        viewRanking = new JButton();
        viewRanking.setText("Rankings");
        viewRanking.setEnabled(true);
        viewRanking.setBounds(180, 370, 110, 60);
        viewRanking.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
        return viewRanking;
    }
/*
    private void loadBackButton() {
        back = new JButton();
        back.setText("Back");
        back.setEnabled(true);
        back.setBounds(380, 380, 90, 60);


    }
*/
}


