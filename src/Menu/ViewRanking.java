package Menu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ViewRanking extends JFrame {
    JButton viewRanking;

    public ViewRanking() {
        viewRanking = new JButton();
        viewRanking.setText("Rankings");
        viewRanking.setEnabled(true);
        viewRanking.setBounds(180, 370, 110, 60);
        viewRanking.setHorizontalAlignment(SwingConstants.CENTER);
    loadListener();
    }

    public JButton getViewRanking() {
        return viewRanking;
    }
    private void loadListener() {
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("adios");
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
        viewRanking.addMouseListener(mouseListener);
    }
}

