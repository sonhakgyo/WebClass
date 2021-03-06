package Java_folder.Java_GUI_Programming;

// import javax.swing.JFrame;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JMenuItem;
// import javax.swing.JOptionPane;
import javax.swing.*;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.*;

public class MenuTest extends JFrame {
    public static void main(String[] args) {
        new MenuTest();
    }

//  생성자
    MenuTest() {
        setTitle("메뉴 만들기");
        createMenu();
        setSize(400, 200);
        setVisible(true);
    }
//  MenuTest 생성자의 createMenu() 
    private void createMenu() {
        JMenuBar mb = new JMenuBar();              // 메뉴바 생성

        JMenu screenMenu = new JMenu("메뉴바1");   // 메뉴 생성

        screenMenu.add(new JMenuItem("류상현"));   // 메뉴에 부착할 아이템 생성
        screenMenu.add(new JMenuItem("김지나"));
        screenMenu.add(new JMenuItem("장지원"));
        screenMenu.addSeparator(); // 구분선
        screenMenu.add(new JMenuItem("김태현"));

        JMenu screenMenu2 = new JMenu("메뉴바2");   // 메뉴 생성

        screenMenu2.add(new JMenuItem("한윤호"));   // 메뉴에 부착할 아이템 생성
        screenMenu2.add(new JMenuItem("김훈진"));
        screenMenu2.addSeparator(); // 구분선
        screenMenu2.add(new JMenuItem("루삥뽕"));

    //  mb.add(screenMenu);         // 메뉴바에 'screenMenu' 추가
    //  mb.add(screenMenu2);        // 메뉴바에 'screenMenu2' 추가
    //  mb.add(new JMenu("편집"));  // 메뉴바에 "문자열" 메뉴 추가
    //  mb.add(new JMenu("실행"));                      
    //  mb.add(new JMenu("도움말"));           
        
        JMenuItem item = new JMenuItem("팝업");
        item.addActionListener(new ActionListener() { // 익명클래스, 아래 인터페이스를 구현하는 것보다 이렇게 쓰는 경우가 많다.
            @Override
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "팝업"); // 간단한 알림창 메서드
            }
        }); // 마지막 ')' 익명클래스
        
        mb.add(screenMenu);    // 위에 한 번에 해주었던 명령들을 한 번씩 더 작성했다.
        screenMenu.add(item); 
        mb.add(screenMenu2);   // 위에 한 번에 해주었던 명령들을 한 번씩 더 작성했다.
        mb.add(new JMenu("편집"));  // 메뉴바에 "문자열" 메뉴 추가
        mb.add(new JMenu("실행"));                      
        mb.add(new JMenu("도움말"));           

        setJMenuBar(mb); // 메뉴바를 현재 프레임의 메뉴로 지정한다.
    }
}
/*
class MenuActionListener implements ActionListener { // import java.awt.event.ActionListener;
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "팝업"); // 간단한 알림창 메서드
    } 
}
*/