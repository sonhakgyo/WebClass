package Java_folder.collection_folder;

public class SelectionSort1 {
    public static void main(String[] args) {
        int ar[] = {9, 2, 3, 6, 5, 4, 7, 8};
        int min, tmp;

        for(int i=0; i<ar.length-1; i++) { // 0<7; 7번 반복
        //  i = 최소값을 위치시킬 가장 앞에 있는 index
        //  i의 범위 : 0 ~ 마지막 index-1
            min = i; 
            for(int j=i+1; j<ar.length; j++) { // 1<8; 7번 반복
                //  j = 맨앞에 있는 index[i]와 비교할 index
                //  j의 범위 : i+1 ~ 마지막 index
                if(ar[min] > ar[j]) { // min=0, j=1, if(ar[0]이 ar[1]보다 값이 크다면)
                //  [min] = 0~6, [j] = 1~7
                    tmp = ar[min];     // tmp에 ar[0] = 8을 저장한다.
                    ar[min] = ar[j];   // ar[0]에 ar[1] = 1을 저장한다.
                    ar[j] = tmp;       // ar[1]에 tmp = 8을 저장한다.
                    
                    System.out.println("바로바로 확인");
                    for(int k=0; k<ar.length; k++) {
                        System.out.print(ar[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("최종 정렬");
        for(int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}
