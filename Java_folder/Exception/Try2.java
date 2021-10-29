package Java_folder.Exception;

public class Try2 {
    public static void main(String[] args) {
        int[] arData = new int[5];

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                arData[i] = i + 1;
            } catch (Exception e) {
                /* try문이 6번쨰까지 실행된다. 막을 방법이 있을까. */
                break;
            }
        }
        System.out.println("프로그램 정상 종료");
    }
}
