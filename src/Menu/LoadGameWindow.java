package Menu;

import Providers.GamesLoadProvider;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoadGameWindow extends JFrame {
    private JList gamesSaved;
    private final GamesLoadProvider gamesLoadProvider;

    public LoadGameWindow() {
        loadCaracteristicsOfJFrame();
        loadFirstComponents();
        loadList();
        gamesLoadProvider = new GamesLoadProvider();

    }


    public void loadCaracteristicsOfJFrame() {
        setTitle("Load Game");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setMinimumSize(new Dimension(500, 500));
        pack();
        setVisible(true);
    }

    public void loadFirstComponents() {
        JButton backButton = new JButton("Back");
        backButton.setBounds(380, 390, 70, 50);
        backButton.setEnabled(true);
        backButton.addActionListener(e ->
        {
            this.setVisible(false);
            setDefaultCloseOperation(HIDE_ON_CLOSE);
            new MainWindow();
        });
        add(backButton);

        JButton select = new JButton("Load");
        select.setBounds(100, 250, 70, 50);
        select.setEnabled(true);

        select.addActionListener(e ->
        {
            this.setVisible(false);
            setDefaultCloseOperation(HIDE_ON_CLOSE);
            new GameWindow(gamesLoadProvider.loadGame(gamesSaved.getSelectedValue().toString()));
        });
        add(select);
        gamesSaved = new JList<>();
        gamesSaved.setBounds(30, 30, 200, 200);
        gamesSaved.setCellRenderer(new CenteredCellRenderer());
        add(gamesSaved);

    }


    private void loadList() {
        GamesLoadProvider gamesLoadProvider = new GamesLoadProvider();
        ArrayList<String> arrayList = gamesLoadProvider.listGameSaved();
        gamesSaved.setModel(new AbstractListModel() {
            @Override
            public int getSize() {
                return arrayList.size();
            }

            @Override
            public Object getElementAt(int index) {
                return arrayList.get(index);
            }
        });
    }
}
