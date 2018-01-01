package org.lan.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loggins extends JPanel {
    static final int WIDTH=300;
    static final int HEIGHT=150;
    JFrame loginframe;

    public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h){
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridheight=h;
        constraints.gridwidth=w;
        add(c,constraints);
    }
    Loggins(){
        loginframe=new JFrame();
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout lay=new GridBagLayout();
        setLayout(lay);
        loginframe.add(this,BorderLayout.WEST);
        loginframe.setSize(WIDTH,HEIGHT);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int width=screenSize.width;
        int height=screenSize.height;
        int x=(width-WIDTH)/2;
        int y=(height-HEIGHT)/2;
        loginframe.setLocation(x,y);
        JButton ok=new JButton("登录");
        JButton cancel=new JButton("放弃");
        JLabel title=new JLabel("通讯录系统登录窗口");
        JLabel name=new JLabel("用户名");
        JLabel password=new JLabel("密码");
        final JTextField nameinput=new JTextField(15);
        final JPasswordField passwordinput=new JPasswordField(15);
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.EAST;
        constraints.weightx=4;
        constraints.weighty=4;
        add(title,constraints,2,0,2,1);
        add(name,constraints,1,1,2,1);
        add(password,constraints,3,1,2,1);
        add(nameinput,constraints,3,1,2,1);
        add(passwordinput,constraints,3,2,2,1);
        add(ok,constraints,1,3,1,1);
        add(cancel,constraints,3,3,1,1);
        loginframe.setResizable(false);
        loginframe.setVisible(true);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nametext=nameinput.getText();
                String passwordtext=passwordinput.getText();
                String str=new String(passwordtext);
                boolean x=(nametext.equals("admin"));
                boolean y=(str.equals("admin"));
                boolean z=(x&&y);
                if(z){
                    new JFrame().setVisible(true);
                    loginframe.dispose();
                }else {
                    nameinput.setText("");
                    passwordinput.setText("");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginframe.dispose();

            }
        });
    }
    public static void main(String[] args){
        new Loggins();
    }
}
