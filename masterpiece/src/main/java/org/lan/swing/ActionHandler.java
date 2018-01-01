package org.lan.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
         final int WIDTH=300;
         final int HEIGHT=200;
        JDialog jDialog=new JDialog();
        jDialog.setSize(WIDTH,HEIGHT);
        jDialog.setVisible(true);
        JLabel jLabel=new JLabel();
        jLabel.setText("单击按钮了");
        jDialog.add(jLabel);
    }
}
