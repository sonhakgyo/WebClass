package Java_folder.Exception;

public class Rethrow {
    public static void main(String[] args) {
        // 1. 외부 try문 실행
        // 2. 내부 try문 실행
        // 3. 내부 catch문 실행
        // 4. 내부 finall문 실행
        // 5. 외부 catch문 실행
        
        try {
            System.out.println("외부 try ···");
            // 외부 try문 안에 내부 try문
            try {
                System.out.println("내부 try ···");
                Exception e = new Exception();
                throw e;
            } catch(Exception e) {
                System.out.println("(내부 try_catch) exception: " + e);
                System.out.println("예외던지기 한 번 더 : ");
                throw e;
            } finally {
                System.out.println("finally 구문 출력");
            }
        } catch(Exception e) {
            System.out.println("(외부 try_catch) exception: " + e);
        }
        System.out.println("종료");
    }
}
