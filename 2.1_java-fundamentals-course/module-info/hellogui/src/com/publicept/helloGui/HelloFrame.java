package com.publicept.helloGui;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.publicept.helloInt.HelloInt;

public class HelloFrame extends JFrame implements HelloInt {
    private JLabel label;
    
    public HelloFrame() {
        label = new JLabel();
        this.add(label);
        this.setLayout(new GridBagLayout());
    }
    
    public void setText(String txt) {
        label.setText(txt);
    }

    public void sprich() {
        System.out.println("Hallo Welt!");
    }
}
