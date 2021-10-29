package Java_folder.study;

public class foreach {
    public static void main(String[] args) {
        String[] arData = { "씨쁠쁠", "루비", "자바", "파이썬" };

        /* 빠른 for문 */
        for (String i : arData) {
            System.out.println(i);
        }

        /* 2차원 배열 안에는 1차원 배열이 있다. */
        int[][] arrScore = { 
            { 10, 20, 30 }, 
            { 11, 22, 33 }, 
            { 12, 23, 34 }, 
            { 13, 24, 35 } 
        };
        /* 빠른 for문으로 학생별 총점과 평균 출력 */
        int count = 0;
        int total = 0;
        double avg = 0.0;

        /* 2차원 배열 안에는 1차원 배열이 있다. */
        for (int[] arScore : arrScore) {
            total = 0;  /* 총점 반복마다 초기화 */
            count++;    /* 학생 번호 반복마다 증가 */
            for (int score : arScore) {
                total += score;
            }
            System.out.println(count + "번 총점 : " + total + "점");
            avg = Double.parseDouble(String.format("%.2f", (double) total / arScore.length));
            System.out.println(count + "번 평균 : " + avg + "점");
        }
    }
}
