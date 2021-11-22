package Java_folder.collection_folder;

import java.util.HashMap;
import java.util.Scanner;

public class Map1 {
    public static void main(String[] args) {
    /*  HashMap을 사용하여 간단하게 사전(Dictionary) 프로그램 만들기  */
    //  HashMap을 만들 때 제네릭 기법을 사용한다. 적는 것이 안전하다.
        HashMap<String, String> hashmap = new HashMap<>();

        Scanner scan = new Scanner(System.in);

    //  1. put(Key, Value)
    //  hashmap.put("Key", "Value");
        hashmap.put("apple", "사과");
        hashmap.put("paper", "종이");
        hashmap.put("flower", "꽃");

        String voca;
        System.out.println("알고싶은 단어를 입력하세요 : ");
        voca = scan.nextLine();
        
    //  2. containsKey(Key) : Key가 HashMap에 존재하면 true
        if(hashmap.containsKey(voca)) {
        //  3. get(Key) : value 값 반환
            System.out.println("해당 단어의 뜻은 : " + hashmap.get(voca) + "입니다.");
        } else {
            System.out.println("해당 단어는 테이블(데이터베이스)에 없습니다.");
        }
    }
}
