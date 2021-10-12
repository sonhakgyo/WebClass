package JavaStudy.API;

public class ObjectClass {
    public static void main(String[] args) {
        /* 오브젝트 클래스(=최상위 클래스, 항상 상속받고 있다.) */

        /* 1. equals()와 "==" */
        /* 두 주소값이 같은지 확인하는 메서드 → 값을 비교하는 메서드로 재정의! */
        /* 자세히로는 String 클래스에서 equals()를 재정의하였기 때문에 */
        /* String타입이라면 값을 비교한다. */

        /* 실습 예시 */
        String data1 = new String("ABC");
        String data2 = new String("ABC");
        String data3 = "ABC";
        String data4 = "ABC";

        System.out.println(data1 == data2);             // false 주소
        System.out.println(data1.equals(data2));        // true 값
        System.out.println(data3 == data4);             // true
        System.out.println(data3.equals(data4));        // true
        
    /* 💎.intern() : constant pool에서 같은 값을 검색하여 그 주소값을 반환해준다. */
        System.out.println(data1.intern() == data2);    // false
        System.out.println(data1.equals(data2));        // true
        System.out.println(data3.intern() == data4);    // true
        System.out.println(data3.equals(data4));        // true


        /* 2. hashCode() */
        /* 두 객체가 같은지 확인하는 메서드(컬렉션 수업에서 한번 더 다룰 예정). */
        /* 데이터관리 기법 중 하나이며 다량의 데이터 저장과 빠른 검색이 가능하다. */
        /* String 클래스에서 오버라이딩 했으며 값이 같으면 같은 해쉬코드를 갖는다. */

        /* 실습 예시 */
        System.out.println(data1.hashCode()); // 64578
        System.out.println(data2.hashCode()); // 64578
        System.out.println(data3.hashCode()); // 64578
        System.out.println(data4.hashCode()); // 64578

        /* 객체명을 출력할 때, 뒤에 toString()이 항상 생략된 것이다. */
        ObjectClass o = new ObjectClass();
        char[] word = {'안', '녕'};
        /* 일반 타입과 배열 타입의 toString은 차이가 있다. */
        System.out.println(word);
        System.out.println(o.toString());
        System.out.println(o);
    }
    
    /* toString() 오버라이딩 */
    @Override
    public String toString() {
        return super.toString(); /* ← 재정의 할 수 있다. */
    }
}
