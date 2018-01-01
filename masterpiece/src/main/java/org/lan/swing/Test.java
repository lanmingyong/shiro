package org.lan.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    static final int WIDTH=500;
    static final int HEIGHT=300;
    public static void main(String[] args){


    JFrame frame=new JFrame("测试窗口");
    frame.setSize(WIDTH,HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar jMenuBar=new JMenuBar();
    frame.setJMenuBar(jMenuBar);
    JMenu menu1=new JMenu("文件");
    JMenu menu2=new JMenu("编辑");
    JMenu menu3=new JMenu("视图");
    jMenuBar.add(menu1);
    jMenuBar.add(menu2);
    jMenuBar.add(menu3);
    JMenuItem item1=new JMenuItem("打开");
    JMenuItem item2=new JMenuItem("保存");
    JMenuItem item3=new JMenuItem("打印");
    JMenuItem item4=new JMenuItem("退出");
    menu1.add(item1);
    menu1.add(item2);
    menu1.addSeparator();
    menu1.add(item3);
    menu1.add(item4);
    JPanel panel=new JPanel();
    frame.setContentPane(panel);
    JButton button1=new JButton("确定");
    JButton button2=new JButton("取消");
    panel.add(button1);
    panel.add(button2);
    frame.setVisible(true);
        ActionListener ac=new ActionHandler();
        button1.addActionListener(ac);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel jLabel=new JLabel();
                jLabel.setText("你好");
                frame.add(jLabel);

            }
        });
    }

}
