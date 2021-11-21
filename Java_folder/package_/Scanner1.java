package Java_folder.package_;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Ctrl + Shift + O : Organize Import(자동 임포트)
        String name = scan.nextLine();
        
        System.out.println("이름을 입력하세요.");
        System.out.println(name + "님 환영합니다.");

        scan.close();
    }
}
