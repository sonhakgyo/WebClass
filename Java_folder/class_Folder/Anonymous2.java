package Java_folder.class_Folder;

import javax.swing.event.SwingPropertyChangeSupport;

public class Anonymous2 {
    public static void main(String[] args) {
        // 객체를 생성해서 void a()를 다시 정의한다.
        OuterClass3 o = new OuterClass3() {
            void a() {
                System.out.println("새롭게 정의된 익명클래스 메서드입니다.");
            }
        };     // 중괄호'}' 끝에 세미콜론(;)을 붙인다.
        o.a(); // 새롭게 정의한 내용이 출력된다.

        // 객체를 그대로 생성한다.
        OuterClass3 ok = new OuterClass3();
        ok.a(); 
        // 익명클래스가 일회성임을 알 수 있다. 
        // 다시 사용하기 위해서는 다시 정의해야 한다.
    }
}

class OuterClass3 {
    void a() {System.out.println("Method a");}
    void b() {}
}
