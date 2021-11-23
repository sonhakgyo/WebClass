package Java_folder.collection_folder;

public class InsertionSort1 {
    public static void main(String[] args) {
        int ar[] = {8, 1, 2, 5, 4, 3, 6, 7};
        int tmp, idx;

        for(int i=1; i<ar.length; i++) {
            idx = 1; // idx = 1~7, 7번 반복
            for(int j=i-1; j>=0; j--) { 
                if(ar[idx]<ar[j]) { // 앞에 있는 값이 뒤에 있는 값보다 크다면
                    tmp = ar[idx];
                    ar[idx] = ar[j];
                    ar[j] = tmp;
                    idx = j;
                } else {   // 그렇지 않다면
                    break; // 반복을 종료한다.
                }
            }
        }
        for(int i=0; i<ar.length; i++) {
            System.out.println(ar[i] + " ");
        }
    }
}
