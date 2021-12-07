package Java_folder.exam;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("세 과목 점수를 입력하세요 : ");
        int korean = scan.nextInt();
        int english = scan.nextInt();
        int programming = scan.nextInt();
        int tot = korean + english + programming;
        double avg = tot/3.0; 

        System.out.println("총점 : " + tot);
        System.out.printf("평균 : %.2f\n", avg); // 알아두자.

    //  성적처리 if문
        if(avg >= 90) {
            System.out.println("if문 : 수");
        } else if(avg >= 80) {
            System.out.println("if문 : 우");
        } else if(avg >= 70) {
            System.out.println("if문 : 미");
        } else if(avg >= 60) {
            System.out.println("if문 : 양");
        } else {
            System.out.println("if문 : 가");
        }

    //  Key값은 "정수"를 기억하는 변수 또는 연산결과가 "정수"인 수식
    //  자바 1.7부터는 문자열도 가능하다.
    /*  Switch(Key) {
            case Value: 
                Key와 Value가 일치할 경우 실행할 문장;
                [break;]
            [default:]
                Key와 일치하는 Value가 없을 경우 실행할 문장;
                [break;]
    }*/
        switch((int)avg/10) {
            case 10: 
                System.out.println("case문 : 만점자"); // break;를 작성하지 않았기 때문에 '수'까지 출력
            case 9:
                System.out.println("case문 : 수"); break;
            case 8:
                System.out.println("case문 : 우"); break;
            case 7:
                System.out.println("case문 : 미"); break;
            case 6:
                System.out.println("case문 : 양"); break;
            case 5: default: // 같은 작업을 하는 case는 나열할 수 있다.
                System.out.println("case문 : 가"); break;
        }
    }
}
