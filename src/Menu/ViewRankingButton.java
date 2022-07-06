package Menu;

import javax.swing.*;

public class ViewRankingButton extends JFrame {
    JButton viewRanking;

    public ViewRankingButton() {
        viewRanking = new JButton();
        viewRanking.setText("Rankings");
        viewRanking.setEnabled(true);
        viewRanking.setBounds(180, 370, 110, 60);
        viewRanking.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
