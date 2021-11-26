package Java_folder.Java_GUI_Programming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.FlowLayout; // VSC에서 자동완성이 안 되어 직접입력

public class AddFrame3 extends JFrame {
    public static void main(String[] args) {
        new AddFrame3();
    }

    AddFrame3() {
        setTitle("JFrame");
        setSize(300, 300);

        // 컴포넌트 객체 생성
        JButton button = new JButton("Button");
        JCheckBox box = new JCheckBox("Check Box");
        JSlider slide = new JSlider();
        JTextField textfield = new JTextField("input text", 20); // 20칸 크기
        this.setLayout(new FlowLayout());

        // 컴포넌트 객체 추가
        this.add(button);
        this.add(box);
        this.add(slide);
        this.add(textfield);

        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //  버튼 컴포넌트(객체)에 액션이벤트리스너
        button.addActionListener(new Listener1());
    }
}

class Listener1 implements ActionListener { // import java.awt.event.ActionListener;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource(); // 이벤트 발생한 컴포넌트
        button.setText("버튼 클릭"); 
    //  버튼 문자열 재지정
    //  클릭하면 버튼 안의 "button"이 "버튼 클릭"으로 텍스트 변경된다.
    } 
}
