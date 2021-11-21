package Java_folder.collection_folder;

public class GenericMethod {
//  static 메서드는 이미 메모리에 올라가 있기 때문에 객체화할 필요가 없다.
    public static <T> T functuon(T data) {
        T resultT;
        if (data instanceof Integer) {
            resultT = (T)"정수"; /* 강제형변환 */
        } else if (data instanceof Double || data instanceof Float) {
            resultT = (T)"실수"; /* 강제형변환 */
        } else if (data instanceof Character) {
            resultT = (T)"문자"; /* 강제형변환 */
        } else if (data instanceof String) {
            resultT = (T)"문자열"; /* 강제형변환 */
        } else {
            resultT = null;
        }
        return resultT;
    }

//  static 메서드는 이미 메모리에 올라가 있기 때문에 객체화할 필요가 없다. 
    public static String function(String data) {
        String result;
        result = "정수";
        return result;
    //  정수, 실수, 문자, 문자열 총 4개를 만들어야 한다. 번거로운 일이다. 
    //  때문에 제네릭을 사용한다. 
    }
}
