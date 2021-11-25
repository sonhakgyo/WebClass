package Java_folder.input_output;

import java.io.*;

public class Input_Output02 {
    public static void main(String[] args) {
    //  문자 기반 스트림
        FileReader fr;
        FileWriter fw; 
        
        BufferedReader br;
        BufferedWriter bw;

        try {
            fr = new FileReader("java_IOpackage.txt");
            fw = new FileWriter("result2.txt");

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            String line;
            while((line = br.readLine()) != null) { 
            //  br.readLine()은 문자열의 한 줄 전체를 읽어온다.
            //  (line = br.readLine()) != null은 더 이상 읽은 값(라인)이 없다는 의미다.
                bw.write(line);
            }
            bw.close();
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
