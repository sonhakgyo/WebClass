package Java_folder.collection_folder;

import java.util.*;

public class LinkedList1 {
    public static void main(String[] args) {
    //  TimeCheck, ArrayList와 LinkedList의 작업시간 차이 구하기
        ArrayList arraylist2 = new ArrayList();
        LinkedList linkedlist2 = new LinkedList<>();

    //  '현재 시간'의 밀리초 단위를 정수값으로 저장(반환)한다.
    //  ArrayList
    //  start
        long start = System.currentTimeMillis(); 
        for(int i = 0; i < 100000; i++) {
            arraylist2.add(0, String.valueOf(i));
        }
    //  end
        long end = System.currentTimeMillis();
        System.out.println("ArrayList 작업시간 : " + (end - start)); // 출력 : 908
        

    //  LinkedList
    //  start
        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            linkedlist2.add(0, String.valueOf(i));
        }
    //  end
        end = System.currentTimeMillis();
        System.out.println("ArrayList 작업시간 : " + (end - start)); // 출력 : 5
    }
}
