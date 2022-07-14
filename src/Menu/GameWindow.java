package Menu;

import Providers.GamesLoadProvider;
import Table.TableManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    GamePanel gamePanel;
    JLabel score;
    JLabel scoreNumber;
    JButton pause;
    JButton aContinue;
    JButton saveGame;
    JButton save;
    JTextField jTextField;
    ActionListener actionListener = new ActionListener();

    public GameWindow() {
        loadCaracteristicsOfJFrame();
        loadFirstComponents();

    }

    public GameWindow(TableManager tableManager) {
        loadCaracteristicsOfJFrame();
        this.gamePanel = new GamePanel(tableManager);
        gamePanel.setVisible(true);
        gamePanel.setBounds(10, 10, 370, 400);
        requestFocus();
        add(gamePanel);
        score();
        numSore();
        button();
    }

    public void loadCaracteristicsOfJFrame() {
        setTitle("Tetrix");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setMinimumSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        this.addKeyListener(new KeyListenerr());

    }

    public void loadFirstComponents() {
        gamePanel();
        score();
        numSore();
        button();
    }

    private void gamePanel() {
        gamePanel = new GamePanel();
        gamePanel.setBounds(10, 10, 370, 400);
        gamePanel.setVisible(true);
        requestFocus();
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
        pause.addActionListener(actionListener);
        ImageIcon icono = new ImageIcon("./Images/pause.png");
        pause.setIcon(new ImageIcon(icono.getImage().getScaledInstance(pause.getWidth(), pause.getHeight(), Image.SCALE_SMOOTH)));
        pause.setContentAreaFilled(false);
        pause.setBorder(null);
        add(pause);
    }

    private void paus() {
        aContinue = new JButton("Continue");
        saveGame = new JButton("Save Game");
        aContinue.setBounds(150, 150, 150, 50);
        aContinue.setVisible(true);
        saveGame.setBounds(150, 220, 150, 50);
        aContinue.setEnabled(true);
        saveGame.setEnabled(true);
        aContinue.addActionListener(actionListener);
        saveGame.addActionListener(actionListener);
        add(aContinue);
        add(saveGame);

    }

    private void saved() {
        jTextField = new JTextField();
        save = new JButton("Save");
        save.setBounds(150, 220, 150, 50);
        save.setEnabled(true);
        jTextField.setBounds(150, 130, 150, 50);
        jTextField.setVisible(true);
        save.addActionListener(actionListener);
        add(save);
        add(jTextField);
    }

    private void gameOver() {
        this.setVisible(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        try {
            new RankingWindows();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    class KeyListenerr implements java.awt.event.KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            {
                gamePanel.tableManager.movedPoint(e.getKeyChar());
                gamePanel.validate();

                if (gamePanel.tableManager.isGameOver()) {
                    gameOver();
                }
                gamePanel.repaint();

                scoreNumber.setText(String.valueOf(gamePanel.tableManager.getScore()));
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class ActionListener implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(pause) && gamePanel.isVisible()) {
                gamePanel.setVisible(false);
                pause.setVisible(false);
                paus();
                pack();
                requestFocus();
                validate();

            } else if (e.getSource().equals(aContinue)) {
                aContinue.setVisible(false);
                saveGame.setVisible(false);
                gamePanel.setVisible(true);
                gamePanel.addKeyListener(new KeyListenerr());
                pause.setVisible(true);
                remove(aContinue);
                remove(saveGame);
                requestFocus();


            } else if (e.getSource().equals(saveGame)) {
                saveGame.setVisible(false);
                saveGame.setEnabled(false);
                aContinue.setVisible(false);
                aContinue.setEnabled(false);
                saved();
            } else if (e.getSource().equals(save)) {
                GamesLoadProvider gamesLoadProvider = new GamesLoadProvider();
                gamesLoadProvider.saveGame(gamePanel.tableManager, jTextField.getText());

            }
        }
    }
}
