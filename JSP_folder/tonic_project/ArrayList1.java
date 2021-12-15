import java.util.ArrayList;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
    //  ArrayList : 요소 추가 시 0번 인덱스부터 차례대로 요소 저장(배열에서 발전된 형태)
        list1.add("A");
        list1.add("C");
        list1.add("E");
        list1.add("D");

        System.out.println("초기 상태 : " + list1);
        System.out.print("인덱스[1] 위치에 B 추가 : ");
        list1.add(1, "B");
        System.out.println(list1);

        System.out.print("인덱스[2] 위치의 값 삭제 :");
        list1.remove(2);
        System.out.println(list1);

        System.out.println("인덱스[2] 위치의 갑 반환 : " + list1.get(2));
    }
}
