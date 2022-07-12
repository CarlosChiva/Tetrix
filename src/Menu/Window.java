package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Window extends JFrame implements KeyListener {
    GameWindow jPanel;

    public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setIgnoreRepaint(true);
        jPanel = new GameWindow();
        add(jPanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      jPanel.tableManager.movedPoint(e.getKeyChar());
      jPanel.validate();
      jPanel.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
