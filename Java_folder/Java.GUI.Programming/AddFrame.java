import javax.swing.JFrame;

public class AddFrame extends JFrame {
    public static void main(String[] args) {
        new AddFrame(); 
        // 실행하면 JFrame이 실행되는데 VSC에서는 AddFrame 클래스를 찾을 수 없다.
        // 300*300 사이즈의 타이틀은 "JFrame" 
    }

    AddFrame() {
        setTitle("JFrame");
        setSize(300, 300);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫는 기능을 JFrame.EXIT_ON_CLOSE으로 설정
    }
}
