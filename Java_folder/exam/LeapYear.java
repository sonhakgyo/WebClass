package Java_folder.exam;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
    //  연도가 4로 나눠떨어지고(&&)
    //  100으로 나눠떨어지지 않거나(||) 400으로 나눠 떨어지면 윤년
    //  그렇지 않으면(else) 평년이다.
        Scanner scan = new Scanner(System.in);

        System.out.print("연도를 입력하세요 : ");
        int year = scan.nextInt();
    //  변수에 담아두는 습관 == 유지보수(수정) 용이
        boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0; 

    //  if문
        if(isLeapYear) { 
            System.out.println(year + "년은 윤년입니다.");
        } else {
            System.out.println(year + "년은 평년입니다.");
        }

    //  삼항식
        System.out.println(year+"년은" + (isLeapYear? "윤" : "평") + "년입니다.");
        scan.close();
    }
}
