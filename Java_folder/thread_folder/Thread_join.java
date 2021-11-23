package Java_folder.thread_folder;

public class Thread_join {
    public static void main(String[] args) {
        MyThread6 s1 = new MyThread6();
        MyThread7 s2 = new MyThread7();

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);

        t1.start();
        try {
            t1.join(); // t1을 제외한 나머지 스레드 block
        } catch(InterruptedException ie) {
            System.out.println(ie.toString());
        }

        t2.start();
        try {
            t2.join(); // t2를 제외한 나머지 스레드 block
        } catch(InterruptedException ie) {
            System.out.println(ie.toString());
        }

        for(int i=0; i<10; i++) {
            System.out.println("메인스레드 : " + i);
        }
    }
}

class MyThread6 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("t1 : " + i);
        }        
        System.out.println("<< t1 완료 >>");
    }
}

class MyThread7 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("t2 : " + i);
        }
        System.out.println("<< t2 완료 >>");
    }
}