package Exception;

public class Try {
    public static void main(String[] args) {
        /* Try문 */
        /* 분모가 0이면 오류다. */
        try {
            System.out.println(10 / 0);
            /* Exception은 부모 클래스이기 때문에 오류명을 모를 때 포괄적으로 사용 */
            /* 오류 이름을 정확하게 안다면 오류 이름을 적어주면 된다. */
            /* 오류명은 ArithmeticException, 산수연산 오류다. */
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            /* 어떤 오류인지 출력해주는 메서드 */
            System.out.println(e.getMessage());
            /* 오류 내용을 정확하게 파악할 수 있는 메서드 */
            e.printStackTrace();
        }
        System.out.println("프로그램 종료");
    }
}
