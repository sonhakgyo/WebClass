package Java_folder.class_Folder;

public class InnerClass1 {
    
}


class A {
    // static 클래스와 인스턴스 클래스는 멤버변수 자리에 선언한다.
    static class StaticInner { } // 스태틱 클래스
    class InstanceInner { }      // 인스턴스 클래스
    
    StaticInner st1 = new StaticInner();
    InstanceInner ii1 = new InstanceInner();

    static void StaticMethod() {
        // 스태틱 클래스
        StaticInner st2 = new StaticInner();
        // InstanceInner ii2 = new InstanceInner(); // 오류 발생
        // 스태틱 메서드 내에서는 인스턴스 멤버를 호환(접근)할 수 없다.
    }

    void InstanceMethod() {
        StaticInner st3 = new StaticInner();
        InstanceInner ii3 = new InstanceInner();
        // 인스턴스 메서드는 스태틱 클래스, 인스턴스 클래스 모두 접근 가능하다.
    }
}