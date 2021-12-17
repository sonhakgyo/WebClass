package Java_folder.study;

public class MethodTrim {
    public static void main(String[] args) {
        String string1 = "  이 문자열에서 앞, 뒤 공백을 제거해주는 메서드   ";
        System.out.println(string1);

        string1 = string1.trim();
    //  trim()은 문자 사이에 띄어쓰기 같은 공백이 아닌 앞, 뒤 공백을 제거해준다.
    //  아예 공백을 없애기 위해서는 replace(" ", "") 함수를 사용해야 한다.
        System.out.println(string1);
    }
}
