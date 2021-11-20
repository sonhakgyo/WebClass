package Java_folder.classFolder;

public class Anonymous3 {
    public static void main(String[] args) {
        // Inter1 it1 = new Inter1(); 
        // 인터페이스는 객체를 생성할 수 없다.

        // 익명 클래스를 사용하여 인터페이스를 일회성으로 구현할 수 있다.
        Inter1 it = new Inter1() {
            @Override
            public void f1() {
                System.out.println("Inter1 implements f1()");
            }};

            it.f1();
    }
}

interface Inter1 {
    void f1();
}

// 일반 클래스
class InterImp1 implements Inter1 {
    @Override
    public void f1() {
        // TODO Auto-generated method stub
    }
}
