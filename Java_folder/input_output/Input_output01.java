package Java_folder.input_output;

import java.io.*;
// import java.io.BufferedInputStream;
// import java.io.BufferedOutputStream;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.IOException;

public class Input_Output01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;  // 입력 스트림
        FileOutputStream fos = null; // 출력 스트림
        fis = new FileInputStream("java_IOpackage.txt");  // 존재하는 파일과 연결
        fos = new FileOutputStream("result.txt");         // 존재하지 않다면 파일 생성, 존재한다면 덮어쓰기
    //  Input_output 폴더가 아닌 최상위 폴더 WebClass 폴더에 result.txt 파일이 생성된다.
    //  이 폴더에 생성하는 경로를 알아본다.
    //  WebClass 폴더를 기준으로 파일이 존재해야 하고 파일이 생성된다.

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int data;
    //  data에 읽어온 바이트를 저장하는데 값이 -1이 아닐 때까지 반복한다.
    //  -1은 EOF(End Of File):파일의 끝을 의미하는데 파일 마지막까지 가져오는 것을 의미한다.
        while((data = fis.read()) != -1) { // fis든 bis든 상관없다.
            bos.write(data);
        }
        
    //  파일과의 연결을 닫는 명령
    //  fis.close(); fos.close(); 
    //  이 명령은 java.io.IOException: Stream Closed 예외를 발생시킨다.
        bos.close(); bis.close(); 
    }
}
