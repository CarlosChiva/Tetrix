package Menu;

import javax.swing.*;

public class Back extends Button {
    JButton back;

    public Back() {
        back = new JButton();
        back.setText("Back");
        back.setEnabled(true);
        back.setBounds(380, 380, 90, 60);
    }

    public JButton getBack() {
        return back;
    }

}
