package Menu;

import javax.swing.*;


public class MainMenu extends JFrame {

    JLabel etiqueta;
    JButton startGame;
    JButton loadGame;
    JButton back;
    JButton viewRanking;
    public MainMenu() {

    }


    public JLabel firstText() {
        etiqueta = new JLabel();
        etiqueta.setText("Hi Gamer \n  What do you want?");
        etiqueta.setBounds(150, 100, 200, 100);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        return etiqueta;

    }

    public JButton StartGameButton() {
        startGame = new JButton();
        startGame.setText("Start Game");
        startGame.setEnabled(true);
        startGame.setBounds(180, 230, 110, 60);
        startGame.setHorizontalAlignment(SwingConstants.CENTER);

        return startGame;
    }

    public JButton LoadGameButton() {
        loadGame = new JButton();
        loadGame.setText("Load Game");
        loadGame.setEnabled(true);
        loadGame.setBounds(180, 300, 110, 60);
        loadGame.setHorizontalAlignment(SwingConstants.CENTER);

        return loadGame;
    }

    public JButton ViewRankingButton() {
        viewRanking = new JButton();
        viewRanking.setText("Rankings");
        viewRanking.setEnabled(true);
        viewRanking.setBounds(180, 370, 110, 60);
        viewRanking.setHorizontalAlignment(SwingConstants.CENTER);
        return viewRanking;
    }

    private void loadBackButton() {
        back = new JButton();
        back.setText("Back");
        back.setEnabled(true);
        back.setBounds(380, 380, 90, 60);


    }

}


