package PracticeNote;

import java.util.Scanner;

public class HW6_8 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("요소 수 : ");
    int num = scan.nextInt(); // 요소 수 입력
    int[] arr = new int[num]; // 배열 생성

    for(int j=0; j<num; j++) {
      System.out.println("a[" + j + "] =");
      arr[j] = scan.nextInt();
    }
    scan.close();
    
    System.out.print("찾을 숫자 : ");
    int findNum = scan.nextInt();

    int i;
    for ( i=0; i<num; i++) {
      if (arr[i] == findNum) { 
        break;
      }
    }
    if ( i<num ) {
      System.out.println("그 값은 a[" + i + "]에 있습니다.");
    } else {
      System.out.println("해당 값은 존재하지 않습니다.");
    }
    scan.close();
  }
}
