package com.publicept.hello;

import com.publicept.helloGui.HelloFrame;

public class HelloWorld {

    public static void main(String[] args) {
        HelloFrame frame = new HelloFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(HelloFrame.EXIT_ON_CLOSE);
        var txt = "Text";
        frame.setText(txt);
        frame.sprich();
        frame.setVisible(true);
    }
}
