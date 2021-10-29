package Java_folder.set;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class WhySet {
    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        final List<Integer> arrayList = new ArrayList<>(SIZE);
        final Set<Integer> hashSet = new HashSet<>(SIZE);

        final int data = 9_000_000;

        /* 순차 병렬 집계연산 */
        IntStream.range(0, SIZE).forEach(value ->{
            arrayList.add(value);
            hashSet.add(value);
        });

        /* 끝 시간 - 시작 시간 = 걸린 시간 */
        /* arrayList 검색 */ 
        Instant start = Instant.now();
        arrayList.contains(data);
        Instant end = Instant.now();
        long eTime = Duration.between(start, end).toMillis();
        System.out.println("array list search time : " + (eTime/1000.0) + "초");
        
        /* haseSet 검색 */ 
        /* haseSet 검색속도가 arrayList 검색속도보다 빠르다는 걸 알 수 있다. */ 
        start = Instant.now();
        hashSet.contains(data);
        end = Instant.now();
        eTime = Duration.between(start, end).toMillis();
        System.out.println("array list search time : " + (eTime / 1000.0) + "초");

        /* 시간 복잡도 : 속도의 효율성 */
        /* 공간 복잡도 : 메모리 사용의 효율성 */ 
    }
}
