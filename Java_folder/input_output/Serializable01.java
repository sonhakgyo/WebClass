package Java_folder.input_output;

import java.io.*;

// User 클래스를 마샬링을 통해 바이트로 변환하여 파일에 저장하고
// 파일에 저장된 객체를 언마샬링을 통해 객체의 정보를 프로그램에 출력하는 코드

public class Serializable01 {
    public static void main(String[] args) {
        marshalling();
        unmarshalling();
    }
//  마샬링
//  실행시킬 때 겍체를 따로 만들지 않기 위해 static을 붙인다.
    public static void marshalling() {
    //  입출력에 관련된 메서드이기 때문에 예외처리를 해야 한다. IOException e
        try {
            FileOutputStream fos = new FileOutputStream("user.serializable"); // 바이트 기반 스트림
            BufferedOutputStream bos = new BufferedOutputStream(fos); // 바이트 기반 보조 스트림
            ObjectOutputStream out = new ObjectOutputStream(bos); // 객체를 전달할 수 있는 객체 생성
        //  out 스트림에 마샬링한 객체 전달
    
            User user1 = new User("user", "1234", "가길동");
            out.writeObject(user1); // 객체를 마샬링하여 바이트로 변환 후 버퍼스트림(bos)에 전달한다.
            out.close(); // close()를 하지 않으면 입력할 명령이 남은 줄 알기 때문에 꼭 해줘야 한다.
            System.out.println("객체 직렬화 완료");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
//  언마샬링
    public static void unmarshalling() {
        try {
            FileInputStream fis = new FileInputStream("user.serializable");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis); // 언마샬링할 파일 연결

            User user2 = (User)in.readObject(); // readObject()는 리턴타입이 Object이다.
        //  새로운 객체 = (클래스)in.readObject();
        //  정확한 타입을 지정(형변환)한다. 타입 = USer
        //  언마샬링된 객체를 읽어와 변한 후 객체에 저장한다.
            in.close();
            System.out.println(user2.toString());
            System.out.println("객체 복원 완료");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


// User 클래스로 만들어진 객체를 바이트 단위의 파일로 보내 저장한다.
class User implements Serializable {
    private String id;
    private String pw;
    private String name;
    public User(String id, String pw, String name) { // User 생성자(id, pw, name)
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
//  이클립스에서는 Source - Generate Constructor using Fields - generate를 통해 
//  private 매개변수를 자동생성할 수 있다.
    @Override
    public String toString() {
        return "User [id = " + id + ", name = " + name + ", pw = " + pw + "]"; // pw는 안 넣어도 된다.
    }
}

