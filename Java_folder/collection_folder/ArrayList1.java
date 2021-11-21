package Java_folder.collection_folder;

import java.util.ArrayList;

public class ArrayList1 {
    public static void main(String[] args) {
    //  ArrayList arraylist1 = new ArrayList<>(initialCapacity);
        ArrayList arraylist1 = new ArrayList<>(10);
        arraylist1.add("A");
        arraylist1.add("B");
        arraylist1.add("E");
        arraylist1.add("D");

        System.out.print("arraylist1 초기 상태 : ");
        System.out.println(arraylist1);

    //  arraylist1[1] 위치에 "B"를 추가한다.
        System.out.print("인덱스[1] 위치에 B 추가 : ");
        arraylist1.add(1, "B");
        System.out.println(arraylist1);

    //  arraylistp[2] 위치한 값을 삭제한다.
        System.out.println("인덱스[2] 위치의 값 삭제 : ");
        arraylist1.remove(2);
        System.out.println(arraylist1);
    
    //  arraylistp[2] 위치한 값을 반환한다.
        System.out.println("인덱스[2] 위치의 값 반환 : " + arraylist1.get(2));
    }
}
