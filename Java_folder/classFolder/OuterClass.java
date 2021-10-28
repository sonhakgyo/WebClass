package classFolder;

/* 외부 클래스 선언 */
public class OuterClass {
    int outData = 20;

    /* 외부 클래스 생성자(new 연산 객체 생성 시 기본 호출) */
    OuterClass() {
        System.out.println("외부 클래스의 '생성자' 호출됨");
    }

    public void showOuter() {
        System.out.println("외부 클래스의 '메서드' 호출됨");
    }

    /* 캡슐화 */
    /* 내부 클래스 선언 */
    public class InnerClass {
        int inData;

        /* 내부 클래스 생성자(new 연산 객체 생성 시 기본 호출) */
        public InnerClass() {
            System.out.println("내부 클래스의 '생성자' 호출됨");
        }

        /* 내부 클래스에서 외부 클래스 필드에 접근하고 있다. */
        public void showInner() {
            outData = 20;
            System.out.println("내부 클래스의 '메서드' 호출됨");
            System.out.println("outData : " + outData);
            showOuter();
        }
    }

    /* 메인 메서드 */
    public static void main(String[] args) {
        /* 외부 클래스부터 객체화한다. */
        OuterClass outer = new OuterClass();

        /* 외부 클래스 안의 내부 클래스 필드를 사용하는 방법 */
        OuterClass.InnerClass inner = outer.new InnerClass();
        /* showInner 메서드 안에 메서드는 3개다. */
        inner.showInner();
    }
}
