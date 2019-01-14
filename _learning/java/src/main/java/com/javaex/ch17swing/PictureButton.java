package com.javaex.ch17swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Icon icon = new ImageIcon("rhino.gif");
        JButton button = new JButton(icon);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Urp!");
            }
        });

        frame.getContentPane().add(button);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
