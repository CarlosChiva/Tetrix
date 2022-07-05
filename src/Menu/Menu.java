package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Menu extends JFrame {
    JPanel panel = new JPanel();
    ArrayList<Component> arrayList = new ArrayList<>();

    public Menu() {
        setTitle("MainMenu");
        MainMenu mainMenu = new MainMenu();
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarPanel();
        arrayList.add(mainMenu.firstText());
        arrayList.add(mainMenu.StartGameButton());
        arrayList.add(mainMenu.LoadGameButton());
        arrayList.add(mainMenu.ViewRankingButton());
        put();
    }

    private void put() {
        for (Component compo : arrayList) {
            panel.add(compo);
        }
    }
    private void listener(){
        arrayList.get(0);
        MouseListener mouseListener=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("dsgdfgdsf");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        arrayList.get(0).add((PopupMenu) mouseListener);
    }

    public Menu(Window window) {
        panel = new JPanel();
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarPanel();

    }

    private void iniciarPanel() {
        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);

    }

}
