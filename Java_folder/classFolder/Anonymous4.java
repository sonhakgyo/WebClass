package Java_folder.classFolder;

public class Anonymous4 {
    public static void main(String[] args) {
        // Abstract ab = new Abstract();
        // 추상 클래스 역시 객체 생성이 불가능하다.

        // 익명 클래스를 사용하여 추상 클래스를 일회성으로 구현할 수 있다.
        Abstract ab = new Abstract() {
            @Override
            void f2() {
                System.out.println("Abstract extends f2()");
            }
        };  // 세미콜론

        ab.f2();
    }
}

abstract class Abstract{
    abstract void f2();
}