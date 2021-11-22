package Java_folder.collection_folder;
/* 고객관리 프로그램 */
// HashMap을 활용하여 사용자의 이름과 전화번호를 저장하는 전화번호부 만들기

/* 전화번호부 기능 */
// 1. 고객 저장
// 2. 고객 검색
// 3. 전체 보기
// 4. 끝내기

/* HashMap 메서드 정리 */
// 1. 생성         : HashMap 객체명 = new HashMap();
// 2. 삽입         : 객체명.put(Key, Value);
// 3. 가져오기     : 객체명.get(key);
// 4. Key 존재확인 : 객체명.containsKey(Key);

// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.Scanner;
// import java.util.Set;
import java.util.*;

public class Map2PhoneBookMain {
    static Scanner scan = new Scanner(System.in);
    static HashMap<String, String> hashmap = new HashMap<>();
    public static void main(String[] args) {
        int choice;

        while(true) {
            System.out.println("전화번호부");
            System.out.println("1. 고객 정보 저장");
            System.out.println("2. 고객 정보 검색");
            System.out.println("3. 고객 정보 출력");
            System.out.println("4. 끝내기");
            System.out.print("번호 입력");

            choice = scan.nextInt();

            if(choice == 1) {
                System.out.println("고객 정보 저장");
                insert();
            } else if(choice == 2) {
                System.out.println("고객 정보 검색");
                search();
            } else if(choice == 3) {
                System.out.println("고객 정보 출력");
                show();
            } else if(choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else { System.out.println("잘못 입력하셨습니다.");}
        }
    }

    public static void insert() {
        String insertName, insertPhone;

        System.out.print("저장할 고객 성함 : ");
        insertName = scan.next();
        
        //  insertName이 Key이므로 중복이 불가능하다.
        if (hashmap.containsKey(insertName)) {
            System.out.println("이미 존재하는 사람이므로 저장할 수 없습니다.");
            return; // 저장하지 않는다.
        } else {
            System.out.println("저장할 고객 번호 : ");
            insertPhone = scan.next();
            hashmap.put(insertName, insertPhone);
            System.out.println("저장이 완료되었습니다.");
        }
    }

    public static void search() {
        String searchName;

        System.out.println("검색 이름 : ");
        searchName = scan.next();

    //  searchName이 hashmap에 존재해야 검색이 가능하다.
        if (hashmap.containsKey(searchName)) {
            System.out.println("검색 완료!");
            System.out.println("검색된 전화번호 : " + hashmap.get(searchName));
        } else {
            System.out.println("존재하지 않는 이름입니다.");
        }
    }

    public static void show() {
    //  Iterator를 가져오기 위해 hashMap의 Key들을 Set으로 가져온다.
    //  가져온 keySet으로 Iterator 선언 후 다음 요소가 존재할 때까지 반복해서 전체 요소를 가져온다.
        Set<String> keySet = hashmap.keySet();
        Iterator iterator = keySet.iterator();

        System.out.println("-----전체 고객 조회-----");
        while(iterator.hasNext()) {
            String curName = (String)iterator.next(); 
        //  next()는 Object를 반환하기 때문에 (String)으로 명시적 형변환을 해주어야 한다.
            System.out.println("Name : " + curName + ", Phone : " + hashmap.get(curName));
        }
    }
}
