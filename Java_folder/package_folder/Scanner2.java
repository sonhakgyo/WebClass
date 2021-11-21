package Java_folder.package_folder;

import java.io.FileInputStream;
import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("java_folder//package_//java.util.패키지3.txt");
            Scanner scan = new Scanner(fis);
            while(scan.hasNext()) {
                System.out.println(scan.nextLine()); // 한 줄씩 입력받는다.
            }
            scan.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
