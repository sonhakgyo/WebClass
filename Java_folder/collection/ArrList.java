package Java_folder.collection;

import java.util.ArrayList;
import java.util.Collections;
/*
'ArrayList'
	컬렉션 클래스 중 가장 많이 사용되는 클래스
	배열을 이용해서 값을 저장한다.
	
	인덱스를 이용해서 배열 요소에 빠르게 접근 가능하지만
	크기를 늘리기 위해서는 새로운 배열을 생성하고 기존의 값들을 옮겨야하므로 느리다.
	
	우리가 기존에 알고 썼던 배열은 정적배열이다. 정적배열: 크기가 고정되었다.
	우리가 이제 배울 배열은 동적배열이다. 동적배열: 크기가 고정되어 있지 않다.
	
	배열: 속도가 빠르지만 고정된 메모리양으로 인해서 나중에 늘릴 수가 없다.
	ArrayList: 배열보다 느리지만 메모리양을 맘대로 늘리고 줄일 수 있다.
　			   정확히는 기존의 배열이 5칸이라면 6칸 배열의 주소로 이동한다.
*/
public class ArrList {
	public static void main(String[] args) {
		/* 클래스 이름과 컬렉션 프레임워크명과 동일하지 않게 하고 */
		/* ArrayList를 import 해야 한다. */
		ArrayList<Integer> list = new ArrayList<>(); 
		/* for문으로 빠르게 넣을 수 있긴 하다. */
		list.add(10); //0
		list.add(20); //1
		list.add(30); //2
		list.add(40); //3
		list.add(50); //4
		
		/* 원래 배열만 출력하면 0번째 위치한 값의 주소값이 반환되지만 */
		/* ArrayList는 배열 안에 값(요소)들이 반환된다. */
		System.out.println(list);
		System.out.println(list.toString());
		
		ArrayList<Integer> list2 = null; 
		ArrayList<Integer> list3 = null; 
		ArrayList<Integer> list4 = null; 
		/* subList(시작인덱스, 끝인덱스): 시작인덱스부터 끝인덱스 -1까지 가져와 저장 */
		list2 = new ArrayList<>(list.subList(2, 5)); /* 30, 40, 50 저장 */
		list3 = new ArrayList<>(list.subList(2, 4)); /* 30, 40 저장 */
		list4 = new ArrayList<>(list.subList(2, 3)); /* 30 저장 */
		
		System.out.println(list2);
		System.out.println(list3);
		
		/* ArrayList의 인덱스에 위치한 값을 가져오는 메서드 */
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		/* ArrayList의 저장공간을 반환하는 메서드 */
		System.out.println(list.size());
		
		/* Collections을 import 해야 한다. */
		/* Collection.sort(ArrayList객체명) */
		ArrayList<Integer> list5 = new ArrayList<>(); 
		list5.add(21); //0
		list5.add(80); //1
		list5.add(18); //2
		list5.add(10); //3
		list5.add(44); //4
		
		System.out.println("정렬 메서드 전 : " + list5); //21, 80, 18, 10, 44
		Collections.sort(list5);                      
		System.out.println("정렬 메서드 후 : " + list5); //10, 18, 21, 44, 80
		/* 규칙성, 순서없이 어지렵혀져 있는 데이터들을 정리하고 */
		/* 데이터화, 정보로 만드는 것을 '알고리즘'이라고 한다. */
		
		
		/* Collections.reverse(): 가운데를 기준으로 양 옆 자리만 바꿔주는 메서드 */                    
		/*                        정렬을 내림차순으로 바꿔주는 것이 아니다. */                    
		/* 때문에 내림차순으로 만드려면 정렬(sort)을 먼저 하고 reverse를 사용한다. */                    
		Collections.reverse(list5);                      
		System.out.println("리버스 메서드 후 : " + list5); //80, 44, 21, 18, 10
		
		/* 섞기: Collections.shuffle() */
		/* 실행할 때마다 셔플이 된다. */
		Collections.shuffle(list5); 
		System.out.println(list5);
	}
}
