package callbacktest;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;


public class ListenerEx extends JFrame{
    ListenerEx(){
        this.setTitle("이벤트 리스너 작성 방법");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("btn1");
        JButton btn2 = new JButton("btn2");

        MyActionListener listener = new MyActionListener();
        btn.addActionListener(listener);
        btn2.addActionListener(listener);


        this.add(btn);
        this.add(btn2);

        setSize(300,150);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ListenerEx();

    }

}

class MyActionListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        System.out.println(b.getText() + "버튼 클릭 됨");
    }

}
