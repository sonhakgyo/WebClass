package Java_folder.collection_folder.Set_Map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest{
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("AB");
        set.add("B");
        set.add("O");
        set.add("O");
        
        /* 사이즈 총 수 : 4 */
        /* 중복된 데이터는 사이즈 추가에 영향을 주지 않는다. */
        System.out.println("총 수 : " + set.size()); 
        /* set의 toString을 재정의되었다. */
        System.out.println(set); 


        /* 반복자 : Itertor : 반복해서 값을 순서대로 뽑을 때 사용한다. */
        /* 반복자 : Itertor : 순서를 부여한다. */
        Iterator<String> iter = set.iterator();

        /* while(iter.hasNext()) : 다음 데이터가 없을 때까지 출력하고 반복한다. */
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        /* set에서 "AB"를 지운다. */
        set.remove("AB");
        System.out.println(set.size());
        /* set의 순서를 부여한다. */
        iter = set.iterator();
        
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}