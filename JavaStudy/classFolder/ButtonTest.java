package JavaStudy.classFolder;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonTest extends Frame {
	/* ButtonTest 생성자 */
	public ButtonTest() {
		/* super는 Frame이다. */
		/* super 안의 괄호는 팝업창의 타이틀이다. */
		super("익명 클래스 테스트");
		
		/* 생성자 괄호 안(값을 넘겨준 것)은 팝업창의 내용이다. */
		Button button = new Button("누르세요!");
		
		/* Frame에 button이 추가되었다. */
		add(button);
		setSize(500, 500);
		
		/* Adapter가 왜 붙는지, 원래는 무엇이 와야되는지 복습해보자. */
		/* WindowAdapter는 익명 클래스다. */
		addWindowListener(new WindowAdapter() {
			/* WindowAdapter <= Ctrl + 클릭 */
			/* X 버튼 눌렀을 때 실행할 메서드 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("프레임 종료");
				System.exit(0);
			}
		});
		
		/* 참고로 Listener는 모두 인터페이스다. */
		button.addMouseListener(new MouseAdapter() {
			/* 클릭했을 때 실행할 메서드 */
			@Override
			public void mouseReleased(MouseEvent e) {
				/* 팝업창 안을 클릭했을 때 클릭한 커서 위치의 좌표 출력 */
				System.out.println("X 좌표 : " + e.getX());
				System.out.println("Y 좌표 : " + e.getY());
				System.out.println("각 X, Y 위치의 버튼을 눌렀습니다.");
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		/* 실행하면 중지를 눌러야 팝업창이 닫힌다. */
		new ButtonTest();
	}
}
