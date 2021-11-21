package Java_folder.collection_folder;

public class Generic2 {
    public static void main(String[] args) {
        A<Integer> a1 = new A<>(); //new A<>()에서 <> 안에 Integer를 적지 않아도 자동으로 인식된다.
        a1.x = 10;
        a1.y = 20;
        System.out.println(a1.x + a1.y);

        A<String> a2 = new A<>();
        a2.x = "Hello";
        a2.y = "World";
        System.out.println(a2.x+a2.y);
    }
}

//<T> 타입의 클래스 A
class A<T> {
    T x; // T 타입의 변수 x
    T y; // T 타입의 변수 y
}