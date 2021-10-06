package JavaStudy;

public class ObjectTest {
    int data1 = 10;
    int data2 = 20;
    int data3 = 30;

    public ObjectTest(int data1){
        this.data1 = data1;
    }

    @Override
    public String toString(){ // 접근제어자 리턴타입 메서드명()
        return ""+data1+data2+data3;
    }

    public static void main(String[] args){
        char[] word = {'안', '녕'}; // java에서 char는 2바이트이기 때문에 한글 가능.
        ObjectTest o = new ObjectTest(90);
        System.out.println(o);
        
        //일반*원시 타입과 클래스*오브젝트 타입의 toString() 차이

        //일반*원시 타입이고, 클래스가 아니다. 때문에 toString() 생략되지 않는다.
        System.out.println(word.toString()); // 주소값이 출력되었다.

        //배열명을 출력하면 배열 시작 주소값이 나온다.
        System.out.println(word); //배열이 출력된다

        /*
        객체명을 출력할 때 항상 뒤에 toString()이 생략되어 있다.
        때문에 toString()을 재정의하면 객체명만 출력했을 때 원하는 값을 출력할 수 있다.
        */

        //클래스(String) 타입에서는 인덱스([]) 대신 charAt()을 쓴다.
        String dataHi = "안녕";
        System.out.println(dataHi.charAt(0));

        //equalsIgnoreCase()는 대소문자 구분없이 값을 비교하고 논리값을 출력한다. 
        //위 함수에서 Case는 UpperCase, LowerCase처럼 대문자, 소문자를 말한다.
        String dataAlpha = "AbCdEfG";
        System.out.println(dataAlpha.equalsIgnoreCase("abcdefg"));
    }
}


