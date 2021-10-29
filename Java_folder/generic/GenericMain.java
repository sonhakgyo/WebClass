package Java_folder.generic;

/* raw */
/* 1. 익히지 않은, 날것의 */
/* 2. 원자재의, 가공되지 않은 */
/* 3. 가공[처리]되지 않은 */

public class GenericMain {
    public static void main(String[] args) {
        /* 제네릭은 Wrapper 클래스를 써야한다? */
        Generic<String> g_String = new Generic<>();
        Generic<Integer> g_Integer = new Generic<>();
        Generic<Integer> g_Integer2 = new Generic<>();

        g_String.setData("스트링 타입의 제네릭");
        g_Integer.setData(11111111); /* 1이 10자리까지 정수 범위 허용 */
        g_Integer2.setData(new Integer(22)); /* 박싱 혹 랩핑 */

        System.out.println(g_String);
        System.out.println(g_String.getData()); /* 출력: 0 */
        System.out.println(g_String.getDataT());
        System.out.println(g_Integer);
        System.out.println(g_Integer.getData());
        System.out.println(g_Integer.getDataT()); /* 출력: null */
        System.out.println(g_Integer2);
        System.out.println(g_Integer2.getData()); /* 출력: 0 */
        System.out.println(g_Integer2.getDataT());

        /* GenericMethod 클래스 */
        System.out.println(GenericMethod.functuon(11.02));
        System.out.println(GenericMethod.functuon('Z'));
        System.out.println(GenericMethod.functuon("하늘"));
        System.out.println(GenericMethod.functuon(410));
    }
}
