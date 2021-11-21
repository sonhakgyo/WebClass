package Java_folder.package_folder;

import java.math.BigDecimal;

public class BigDecimal1 {
    public static void main(String[] args) {
        // BigDecimal 클래스
        // 정확한 소수점 연산을 해야할 때 사용한다.

        double a = 24.3953;
        double b = 50.343998;
        System.out.println(a + b); // 출력 : 74.739297999999

        BigDecimal number = new BigDecimal(String.valueOf(a));
        BigDecimal number2 = new BigDecimal(String.valueOf(b));
        // 객체이기 때문에 메서드를 호출해야 한다.
        System.out.println(number.add(number2)); // 출력 : 74.739298 정확한 소수점 연산을 한다.
    }
}
