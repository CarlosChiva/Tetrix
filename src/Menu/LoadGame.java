package Menu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoadGame extends JFrame {
    JButton loadGame;

    public LoadGame() {
        loadGame = new JButton();
        loadGame.setText("Load Game");
        loadGame.setEnabled(true);
        loadGame.setBounds(180, 300, 110, 60);
        loadGame.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public JButton getLoadGame() {
        return loadGame;
    }

}
