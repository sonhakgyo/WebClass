package Java_folder.Java_GUI_Programming;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvent1 extends JFrame {
    public static void main(String[] args) {
        new MouseEvent1();
    }

    JPanel p = new JPanel();
    JLabel l;

//  MouseEvent1 생성자
    MouseEvent1() {
        setTitle("Mouse 이벤트 창");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(p);

        p.addMouseListener(new MouseListener1());
        p.addMouseMotionListener(new MouseListener1());
        l = new JLabel("마우스를 올려보세요.");
        p.add(l);
        setSize(300, 300);
        setVisible(true);
    }

    class MouseListener1 implements MouseListener, MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            l.setText("Mouse Dragged(" + e.getX() +", " + e.getY() + ")" );
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            l.setText("Mouse Moved(" + e.getX() +", " + e.getY() + ")" );
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            l.setText("마우스 클릭 횟수 : "+e.getClickCount());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JPanel p = (JPanel)e.getSource();
            p.setBackground(Color.RED); // 패널(판)의 배경색을 빨강색으로 설정한다.
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            JPanel p = (JPanel)e.getSource();
            p.setBackground(Color.YELLOW); // 패널(판)의 배경색을 노랑색으로 설정한다.
        }
    }
}
