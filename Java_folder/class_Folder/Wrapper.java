package Java_folder.class_Folder;

/*
Wrapper 클래스를 사용하는 이유 :
	01. 기본형 타입을 '객체'로 다뤄야할 때
	02. 매개변수를 '객체'로 넘길 때
	03. 기본형 타입이 아닌 '객체'로 저장해야 할 때
	04. '객체'간의 비교가 필요할 때
*/
public class Wrapper {
    public static void main(String[] args) {
        /* jdk 1.5버젼 전에는 무조건 이렇게 사용해야 했다. */
        String string = new String("2");
        System.out.println(string);

        /* 오토박싱 */
        String string2 = "7";
        System.out.println(string2);

        /* 오토언박싱 */
        Integer data = 10;  // 1. 오토 박싱 후
        int data2 = data;   // 2. 오토 언박싱

        Object[] arData = { "1", 10, 20.1 };
        System.out.println(arData[0]);
        System.out.println(arData[1]);
        System.out.println(arData[2]);

        Object[] arData2 = { 
                new Integer(7),     /* Wrapping */
                new Double(7.7),    /* Wrapping */
                new String("안녕")  /* Wrapping */
        };
        System.out.println(arData2[0]);
        System.out.println(arData2[1]);
        System.out.println(arData2[2]);

        /* Integer타입으로 넣었지만 메서드 정의는 String으로 변환하여 출력 */
        add(new Integer(10), new Integer(20));
        add("안녕", "하세요");
    }

    /* 그냥 void만 써서 정의했는데 main 메서드에서 쓸 수가 없었다. */
    /* static 혹은 public static을 추가해야 쓸 수 있었는데 왜일까. */
    /* 접근 제어자와 final, static에 대해서는 알고 있긴 하다. */
    public static void add(Object a, Object b) {
        /* 문자열(String타입 혹은 클래스)로 바꿔준 후 연결해주는 메서드 */
        System.out.println(String.valueOf(a) + String.valueOf(b));
        System.out.println(a + ", " + b);
    }
}
