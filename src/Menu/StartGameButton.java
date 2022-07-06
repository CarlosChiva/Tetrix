package Menu;

import javax.swing.*;

public class StartGameButton extends JFrame {
    JButton startGame;

    public StartGameButton() {
        startGame = new JButton();
        startGame.setText("Start Game");
        startGame.setEnabled(true);
        startGame.setBounds(180, 230, 110, 60);
        startGame.setHorizontalAlignment(SwingConstants.CENTER);
    }


}
