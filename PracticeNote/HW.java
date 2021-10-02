package PracticeNote;
import java.util.*;

public class HW {
  public static void main(String[] args) {
    /*
    [문제]동일 값의 요소가 여러 개 있으면 '가장 앞에 위치한 요소를 찾는 프로그램'

    1. '스캐너 유틸' 불러오고, 요소 수 입력 받기
    2. 입력받은 요소 수로 배열 만들기
    3. 배열 공간만큼 '랜덤 유틸의 난수'를 넣거나 임의로 입력하기
    4. 동일 값이 있다면
    5. 가장 앞에 위치한 요소를 찾는 프로그램 & 뒤에 있는 요소를 찾는 프로그램 작성
    */
    Scanner scan = new Scanner(System.in); 
    Random random = new Random();

    System.out.print("저장공간의 요소 수를 입력하세요 : ");
    int num = scan.nextInt();
    int[] numArray = new int[num];
    for( int i=0; i<num; i++) {
      numArray[i] = random.nextInt(50);
    }

    System.out.print("생성된 배열 : ");
    System.out.println(Arrays.toString(numArray)); // 이거 진짜 중요하다.

    for( int i = 0; i<num ; i++) {
      for( int j = 1; j<num ; j++) {
        if( numArray[i] == numArray[j] ) {
          if( i != j) System.out.println(numArray[i]);
        }
      }
    }
    scan.close();
  }
}
