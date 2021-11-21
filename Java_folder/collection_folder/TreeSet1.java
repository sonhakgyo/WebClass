package Java_folder.collection_folder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet1 {
    public static void main(String[] args) {
    //  해쉬셋 생성
    //  iterator를 사용해 출력하면 순서가 없다.
        HashSet hashset = new HashSet(); 
        hashset.add("demon");  // demon은 과일 이름이다.
        hashset.add("cargo");  // cargo는 과일 이름이다.
        hashset.add("banana");
        hashset.add("tomato");
        hashset.add("apple");
        
    //  트리셋 생성
    //  iterator를 사용해 출력하면 알파벳 순서로 출력된다.
        TreeSet treeset = new TreeSet();
        treeset.add("demon");  // demon은 과일 이름이다.
        treeset.add("cargo");  // cargo는 과일 이름이다.
        treeset.add("banana");
        treeset.add("tomato");
        treeset.add("apple");
        
    //  Iterator 생성 
    //  iterator를 가지고 해쉬셋의 모든 요소들에 접근할 수 있다.
        Iterator iterator = hashset.iterator();
        System.out.println("<HashSet 출력>");
        while(iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
        
        System.out.println();

    //  iterator를 가지고 트리셋의 모든 요소들에 접근할 수 있다.
        Iterator iterator2 = treeset.iterator();
        System.out.println("<TreeSet 출력>");
        while(iterator2.hasNext()) {
            System.out.print(" " + iterator2.next());
        }

        System.out.println();
        System.out.println("현재 TreeSet의 크기 : " + treeset.size());
        System.out.println("현재 TreeSet의 크기 : " + hashset.size());
    }
}
