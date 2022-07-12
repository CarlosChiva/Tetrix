package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameWindow extends JFrame implements KeyListener {
    GamePanel gamePanel;
    JLabel score;
    JLabel scoreNumber;
    JButton pause;

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
        button();

    }

    private void gamePanel() {
        gamePanel = new GamePanel();
        gamePanel.setBounds(10, 10, 370, 400);
        add(gamePanel);
    }

    private void score() {
        score = new JLabel("Score");
        score.setBounds(410, 100, 50, 50);

        add(score);
    }

    private void numSore() {
        scoreNumber = new JLabel();
        scoreNumber.setBounds(410, 130, 100, 50);
        scoreNumber.setText(String.valueOf(gamePanel.tableManager.getScore()));
        add(scoreNumber);

    }

    private void button() {
        pause = new JButton("Pause");
        pause.setBounds(380, 300, 70, 50);
        pause.setEnabled(true);
        add(pause);
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paus();

            }
        });
    }

    private void paus() {

        JButton aContinue = new JButton("Continue");
        JButton saveGame = new JButton("Save Game");
        aContinue.setBounds(380, 350, 70, 50);
        aContinue.setVisible(true);
        saveGame.setBounds(380, 380, 70, 50);
        add(aContinue);
        aContinue.setEnabled(true);
        saveGame.setEnabled(true);
        add(saveGame);

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

}
