package Menu;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    JPanel jPanel;

    public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        jPanel=new GameWindow();
        add(jPanel);
    }
}
