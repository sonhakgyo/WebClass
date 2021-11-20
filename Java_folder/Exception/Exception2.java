package Java_folder.Exception;

public class Exception2 {
    public static void main(String[] args) {
        try {
            int[] a = {2, 0};        // 배열 길이 오류 발생
            // int[] a = {2, 0, 0};  // 산술 오류 발생
            int b = 4;
            int c = b/a[2];   // 배열의 index는 [0], [1] 뿐이다.
            System.out.println(c);
        } catch(ArithmeticException e) {               // ArithmeticException
            System.out.println("산술 오류 발생");
        } catch(ArrayIndexOutOfBoundsException e) {    // ArrayIndexOutOfBoundsException
            System.out.println("배열 길이 오류 발생");
        }
        System.out.println("예외처리 공부 중");
    }
}
