package Java_folder.collection_folder;

public class Generic1 {
    public static void main(String[] args) {
        Value v = new Value();
        v.<Integer>typeSearch(3); 
    //  정확하기 전달하기 위해서는 원래 앞에 클래스 타입 <Integer>을 붙여야 한다.
    //  그러나 버젼이 바뀌면서 더 이상 <Integer>를 작성하지 않아도 된다.
        v.typeSearch(3.14);
        v.typeSearch(3.14f);
        v.typeSearch('가');
        v.typeSearch("hello");
        v.typeSearch(true);
    }
}

class Value {
//  Value 클래스 안에 <T> 타입 메서드
    public <T> void typeSearch(T x) {
        if(x instanceof Integer) {
            System.out.println(x + "는 정수입니다.");
        } else if(x instanceof Double || x instanceof Float) {
            System.out.println(x + "는 실수입니다.");
        } else if(x instanceof Character) {
            System.out.println(x + "는 문자형입니다.");
        } else if( x instanceof String) {
            System.out.println(x + "는 문자열입니다.");
        } else if(x instanceof Boolean) {
            System.out.println(x + "는 논리형입니다.");
        }
    }
}