package Java_folder.classFolder;

public class InnerClass2 {
    public static void main(String[] args) {
        // 1. OuterClass 객체 생성 후 멤버에 접근
        OuterClass2 oc = new OuterClass2();
        // 인스턴스 멤버 접근 : 인스턴스명.변수명
        System.out.println("OuterCLass의 a의 값 : " + oc.a);
        // static 멤버 접근 : 클래스명.변수명
        System.out.println("OuterCLass의 b의 값 : " + OuterClass2.b); // 객체를 생성하지 않고도 출력 가능

        // 2. 인스턴스 내부 클래스 접근
        System.out.println("=== Inner 클래스 접근하기 ===");
        // 외부 클래스 객체 생성 
        OuterClass2 oc2 = new OuterClass2();
        // 외부 클래스 객체로 내부 클래스 객체 생성
        OuterClass2.Inner i = oc2.new Inner();
        System.out.println("Inner의 c의 값 : " + i.c);
        // 내부 클래스 객체로 메서드 호출
        i.innerMethod();

        // 3. 스태틱 내부 클래스 접근
        // 스태틱 클래스 객체 생성
        OuterClass2.StaticInner si = new OuterClass2.StaticInner();
        System.out.println("StaticInner의 d의 값 : " + si.d);
        
        // 스태틱 클래스로 스태틱 메서드 호출
        si.staticMethod(); 
        // 스태틱 멤버는 객체를 생성하지 않고도 클래스명으로 호출 가능하다.
        OuterClass2.StaticInner.staticMethod(); 
    }
}

class OuterClass2 {
    int a = 3;        // 인스턴스 변수
    static int b = 4; // 스태틱 변수

    // 내부 인스턴스 클래스
    class Inner {
        int c = 5;
        // 내부 인스턴스 클래스 안의 인스턴스 메서드
        public void innerMethod() {
            System.out.println("<Inner Class>");
        }
    }

    // 내부 스태틱 클래스
    static class StaticInner {
        int d = 6;
        static int stat = 10;
        // 내부 스태틱 클래스 안의 스태틱 메서드
        public static void staticMethod() {
            System.out.println("Static Inner Class>");
        }
    }
}
