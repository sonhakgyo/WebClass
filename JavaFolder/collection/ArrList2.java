package collection;

import java.util.ArrayList;

public class ArrList2 {
    public static void main(String[] args) {
        /* for문을 이용해 list에 add 메서드를 사용해 값을 넣기. */
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            list.add(i * 10);
        }
        System.out.println(list); /* 기존 8칸의 ArrayList */
        list.add(90); /* 9칸 째에 90을 추가하는 add 메서드 */
        System.out.println(list); /* 9칸의 ArrayList로 주소가 이동한 것이다. */

        /* indexOf(): 값이 있으면 그 값이 들어있는 방번호를 반환한다. */
        /* 값이 없다면 -1을 반환한다. */

        /* indexOf(10): 배열 안에 10이라는 숫자가 없다면 인덱스가 아닌 -1을 반환한다. */
        int index = list.indexOf(10);
        if (index != -1) { /* (= 배열 안에 10이 있다면) */
            list.add(index + 1, 15); /* 10 다음 인덱스에 15를 추가한다. */
        } else {
            list.add(0, 15);
        }
        System.out.println(list);

        System.out.println(1);

        /* 실습: 위 배열에서 60을 600으로 바꾸기 */
        /* set(index, value): 인덱스 번호에 위치한 값을 value로 바꿔준다. */
        list.set(list.indexOf(60), 600);
        System.out.println(list);

        /* 실습: 위 배열에서 값 지우기 */
        // list.remove(600); /* 값을 바로 넣어줬을 때, jdk 1.5버젼 이상 */
        // System.out.println(list);
        list.remove(new Integer(70)); /* 값을 바로 넣어줬을 때 */
        System.out.println(list);
        System.out.println(list.size());
        list.remove(list.indexOf(15)); /* 인덱스 번호를 넣어줬을 때 */
        System.out.println(list);
        System.out.println(list.size());
    }
}
