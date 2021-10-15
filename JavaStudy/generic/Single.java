package generic;

public class Single {
    /* 복습 */
    /* 이름이 클래스명과 같고, 리턴타입이 없다 = 생성자 */
    /* 생성자에 private 접근제어자는 외부에서 이용하지 말라는 뜻이다. */
    private Single() {
    }

    /* Single 타입의 instance라는 이름으로 객체화했다. */
    /* 같은 클래스 {}에 있기 때문에 private임에도 안에서는 객체화가 가능하다. */
    private static Single instance = new Single();

    /* private에 접근 */
    public static Single getInstance() {
        return instance;
    }

    public void sayHello() {
        System.out.println("안녕");
    }
}
