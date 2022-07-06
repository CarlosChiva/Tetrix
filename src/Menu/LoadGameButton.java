package Menu;

import javax.swing.*;

public class LoadGameButton extends JFrame {
JButton loadGameButton;
public LoadGameButton() {
    loadGameButton = new JButton();
    loadGameButton.setText("Load Game");
    loadGameButton.setEnabled(true);
    loadGameButton.setBounds(180, 300, 110, 60);
    loadGameButton.setHorizontalAlignment(SwingConstants.CENTER);
}
}
