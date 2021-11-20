package Java_folder.Exception;

public class Exception4 {
    public static void main(String[] args) {
        try {
            methodA();
        } catch(Exception e) {
            System.out.println("메인에서 처리하겠다.");
        }
    }
    // [코드 실행과정]
    // main() -> methodA() -> methodB() -> methodC()
    // [예외 던지기]
    // methodC() -> methodB() -> methodC() -> main()

    // methodA()
    public static void methodA() throws Exception {
        methodB();
    }
    // methodB()
    public static void methodB() throws Exception {
        methodC();
    }
    // methodC()
    public static void methodC() throws Exception {
        Exception e = new Exception();
        throw e; // 고의 예외 발생
    }
}
