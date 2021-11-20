package Java_folder.Exception;

public class Exception3 {
    public static void main(String[] args) {
        try {
            Exception e = new Exception("고의 예외");
            // Exception 생성자 호출 시 전달했던 문자열("고의 예외")이 내부적으로 저장되어
            // 객체.getMessage()를 호출하면 출력된다.
            
            throw e; // = 고의적으로 예외를 발생시키겠다.
            
        } catch(Exception e) {
            System.out.println("예외발생");
            System.out.println(e.getMessage()); // 전달받은 "고의 예외"가 출력된다.
        }
    }
}
