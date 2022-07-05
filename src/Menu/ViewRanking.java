package Menu;

import javax.swing.*;

public class ViewRanking extends JFrame {
    JButton viewRanking;

    public ViewRanking() {
        viewRanking = new JButton();
        viewRanking.setText("Rankings");
        viewRanking.setEnabled(true);
        viewRanking.setBounds(180, 370, 110, 60);
        viewRanking.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public JButton getViewRanking() {
        return viewRanking;
    }
}

