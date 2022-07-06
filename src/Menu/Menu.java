package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static Menu.MenuEnums.PRINCIPAL;
import static Menu.MenuEnums.STARTGAME;

public class Menu extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    ArrayList<Component> arrayList = new ArrayList<>();

    JButton boton;
    JButton boton2;

    public Menu() {
        setTitle("MainMenu");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarPanel();
        loadComponents(PRINCIPAL);
//        put();
        //arrayList.add(mainMenu.firstText());
        //arrayList.add(mainMenu.StartGameButton());
        //arrayList.add(mainMenu.LoadGameButton());
        //arrayList.add(mainMenu.ViewRankingButton());

        //iniciarBoton();
    }

    private void iniciarPanel() {
        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);


    }

    private void iniciarBoton() {
        boton = new JButton("Finalizar");
        boton.setBounds(300, 250, 100, 30);
        panel.add(boton);
        boton.addActionListener(this);
        setVisible(true);

        boton2 = new JButton("EYY");
        boton2.setBounds(300, 350, 100, 30);
        panel.add(boton2);
        boton2.addActionListener(this);
        setVisible(true);
    }

    private void put() {


        for (Component compo : arrayList) {
            add(compo);
        }
    }


    /* public refresh(Enum enums) {
         panel = new JPanel();
         setSize(500, 500);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setResizable(false);
         iniciarPanel();
         loadComponents(enums);
     }
 */
    private void loadComponents(Enum enums) {
        if (enums == PRINCIPAL) {
            arrayList = new MainMenu().getArrayList();

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == arrayList.get(1)) {
            System.out.println("asdf");
            ;
        }

    }
}
