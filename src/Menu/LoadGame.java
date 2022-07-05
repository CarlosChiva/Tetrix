package Menu;

import javax.swing.*;

public class LoadGame extends JFrame{
    JButton loadGame;
    public LoadGame(){
        loadGame=new JButton();
        loadGame.setText("Load Game");
        loadGame.setEnabled(true);
        loadGame.setBounds(180, 300, 110, 60);
        loadGame.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public JButton getLoadGame() {
        return loadGame;
    }
}
