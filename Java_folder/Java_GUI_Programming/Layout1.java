package Java_folder.Java_GUI_Programming;

import javax.swing.*;
import java.awt.*;

public class Layout1 {
    public static void main(String[] args) {
    //  new FlowWindow();
    //  new BorderWindow();
        new GridWindow();
    }
}

class FlowWindow extends JFrame {
    FlowWindow() { // 나열식 버튼
        setTitle("Flow window");
        setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        this.add(button1);
        this.add(button2);
        this.add(button3);

        this.setLayout(new FlowLayout());

        setVisible(true);
    }
}

class BorderWindow extends JFrame {
    BorderWindow() { // 동서남북 배치식 버튼
        setTitle("Border window");
        setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        JButton button4 = new JButton("button4");
        JButton button5 = new JButton("button5");
        
        this.setLayout(new BorderLayout());
        this.add(button1, BorderLayout.EAST);
        this.add(button2, BorderLayout.WEST);
        this.add(button3, BorderLayout.SOUTH);
        this.add(button4, BorderLayout.NORTH);
        this.add(button5, BorderLayout.CENTER);

        setVisible(true);
    }
}

class GridWindow extends JFrame {
    GridWindow() { // 격자 배치식 버튼
        setTitle("Grid window");
        setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        this.add(button1);
        this.add(button2);
        this.add(button3);

        this.setLayout(new GridLayout(2, 2));

        setVisible(true);
    }
}