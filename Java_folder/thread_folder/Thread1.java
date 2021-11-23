package Java_folder.thread_folder;

public class Thread1 {
    public static void main(String[] args) {
    //  JVM 스레드 요청
    //  1) Thread 클래스를 상속받은 클래스의 스레드를 요청한다.
        MyThread th1 = new MyThread();
        th1.start();

    //  2) Runnable 인터페이스를 구현한 클래스의 스레드를 요청한다.
        MyThread2 th2 = new MyThread2();
        Thread t = new Thread(th2); // Thread(Runnable target), Runnable 객체를 받아오는 매개변수
        t.start();

        for(int i=0; i<10; i++) {
            System.out.println("메인 함수 진행 중" + i); 
            // 스레드는 결과가 항상 동일하지 않다. main 클래스도 하나의 스레드다.
            // 때문에 th1, t(th2), main 총 세 개의 스레드가 돌아가고 있다.
        }
    }  
}

// 1) Thread 클래스를 상속받아 작업을 구현한다.
class MyThread extends Thread {
//  @run() Override(재정의)
    public void run() {
    //  스레드가 해야할 작업 구현
        for(int i=0; i<10; i++) {
            System.out.println("스레드 진행 중" + i);
        }
    }
}

// 2) Runnable 인터페이스를 구현하여 작업을 구현한다.
// 인터페이스는 오버라이딩에 '강제성'을 가진다.
class MyThread2 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("러너블 진행중" + i);
        }
    }
    
}