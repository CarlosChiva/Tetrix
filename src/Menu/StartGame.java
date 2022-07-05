package Menu;

import javax.swing.*;

public class StartGame extends  Button {
    JButton startGame;
    public StartGame(){
        startGame=new JButton();
        startGame.setText("Start Game");
        startGame.setEnabled(true);
        startGame.setBounds(180, 230, 110, 60);
        startGame.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public JButton getStartGame() {
        return startGame;
    }

}
