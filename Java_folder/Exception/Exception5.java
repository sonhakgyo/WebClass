package Java_folder.Exception;

public class Exception5 {
    public static void main(String[] args) {
        int age = -19;
        try {
            // 스태틱 메서드 ticketing
            ticketing(age);
        } catch(AgeException e ) {
            e.printStackTrace(); // 가지고 있는 오류를 출력한다.
        }
    }

    // 스태틱 메서드 ticketing
    public static void ticketing(int age) throws AgeException {
        if(age < 0) {
            throw new AgeException("나이 입력이 잘못되었습니다.");
        }
    }
    
}

// 예외클래스 Exception 상속
class AgeException extends Exception { 
    public AgeException() {}
    public AgeException(String message) {
        super(message);
    }
}