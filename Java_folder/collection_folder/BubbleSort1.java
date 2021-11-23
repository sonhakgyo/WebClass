package Java_folder.collection_folder;

public class BubbleSort1 {
    public static void main(String[] args) {
        int ar[] = {6, 4, 7, 8, 3};
        int tmp;

    //  i 초기값이 'ar.length-1'인 이유
    //  마지막 인덱스 값 고정
        for(int i=ar.length-1; i>=0; i--) { // i=4, 3, 2, 1, 0; i--; i는 제일 큰 값이 올 위치
            for(int j=0; j<i; j++) {        // j=0, j<4, 3, 2, 1, 0; j는 비교할 인덱스
                if(ar[j]>ar[j+1]) { // 앞에 위치한 수가 뒤에 위치한 수보다 크다면
                    tmp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = tmp;
                }
            }
        }
        for(int i=0; i<ar.length; i++) {
            System.out.println(ar[i] + " ");
        }
        System.out.println();
    }   
}
