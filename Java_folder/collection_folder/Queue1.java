package Java_folder.collection_folder;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {
    //  링크드리스트를 사용해 큐의 객체를 생성(사용)한다.
        Queue<String> queue = new LinkedList<>();
        
    //  1. add(e)
    //  rear 위치에 e를 삽입(추가)한다.
        queue.add("apple");
        queue.add("banana");
        queue.add("cherry");
        queue.add("tomato");
        System.out.println(queue);
    
    //  2. element
    //  front(최상단)에 위치한 데이터를 반환한다.
        System.out.println("element : " + queue.element());
    
    //  3. remove
    //  front에 위치한 데이터를 반환 후 삭제한다.
        System.out.println("remove : " + queue.remove());
        System.out.println(queue);
    
    //  4. offer(e)
    //  rear 위치에 데이터를 삽입(추가)한다.
        queue.offer("peach");
        System.out.println(queue);

    //  5. peek()
    //  front에 위치한 데이터 값을 반환한다.
        System.out.println("peek : " + queue.peek());
        System.out.println(queue);

    //  6. poll()
    //  front에 위치한 데이터를 반환 후 삭제한다.
        System.out.println("poll : " + queue.poll());
    }
}
