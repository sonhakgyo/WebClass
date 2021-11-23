package Java_folder.thread_folder;

public class Thread_sleep {
    public static void main(String[] args) {
        SleepThread t = new SleepThread();
        t.start();
    }
}

class SleepThread extends Thread {
    public void run() {
        System.out.println("카운트다운 5초");
        for(int i=5; i>=0; i--) {
            System.out.println(i);
            if(i!=0) {
                try {
                    Thread.sleep(1000); // 1000 = 1초
                } catch(InterruptedException ie) {
                    System.err.println(ie.toString());
                }
            }
        }
        System.out.println("프로그램 종료");
    }
}