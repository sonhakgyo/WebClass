package Java_folder.collection_folder;

import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
    //  스택 생성
        Stack<String> stack = new Stack<>();

    //  1. push() : 데이터 삽입
        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");
        System.out.println(stack);

    //  2. pop() : top의 데이터 삭제
        System.out.println("pop : " + stack.pop()); // 출력 : cherry
        System.out.println(stack);

    //  3. peek() : top의 데이터 보기
        System.out.println("peek : " + stack.peek());

    //  4. search()
    //  데이터가 있는지 위치를 반환한다.
    //  배열의 인덱스와 다르게 top에서 1부터 시작한다.
        System.out.println(stack.search("apple"));
        System.out.println(stack.search("banana"));
    }
}
