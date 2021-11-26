package Java_folder.Java_GUI_Programming;

// import javax.swing.JButton;
// import javax.swing.JCheckBox;
// import javax.swing.JFrame;
// import javax.swing.JSlider;
// import javax.swing.JTextField;
import javax.swing.*;
import java.awt.FlowLayout; // VSC에서 자동완성이 안 되어 직접입력

public  class AddFrame2 {
    public static void main(String[] args) {
        new SwingFrame();
    }
}

class SwingFrame extends JFrame {
    public SwingFrame() {
        setTitle("JFrame");
        setSize(300, 300);

    //  컴포넌트 객체 생성
        JButton button = new JButton("Button");
        JCheckBox box = new JCheckBox("Check Box");
        JSlider slide = new JSlider();
        JTextField textfield = new JTextField("input text", 20); // 20칸 크기
        this.setLayout(new FlowLayout());

    //  컴포넌트 객체 추가
        this.add(button);
        this.add(box);
        this.add(slide);
        this.add(textfield);

        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
