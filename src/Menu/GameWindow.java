package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameWindow extends JFrame implements KeyListener {
    GamePanel gamePanel;
    JLabel score;
    JLabel scoreNumber;

    public GameWindow() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setMinimumSize(new Dimension(500, 500));
        pack();
        addKeyListener(this);
        setVisible(true);
        score();
        gamePanel();
        numSore();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gamePanel.tableManager.movedPoint(e.getKeyChar());
        gamePanel.validate();
        gamePanel.repaint();
        scoreNumber.setText(String.valueOf(gamePanel.tableManager.getScore()));

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void gamePanel() {
        gamePanel = new GamePanel();
        gamePanel.setBounds(10, 10, 400, 400);

        add(gamePanel);

    }

    private void score() {
        score = new JLabel("Score");
        score.setBounds(410, 100, 50, 50);

        add(score);
    }

    private void numSore() {
        scoreNumber = new JLabel();
        scoreNumber.setBounds(410, 160, 100, 50);
        scoreNumber.setText(String.valueOf(gamePanel.tableManager.getScore()));
        add(scoreNumber);

    }
}
