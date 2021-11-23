package Java_folder.thread_folder;
/*
sleep()
    스레드를 지정한 시간 동안 Block 상태로 만든다.
    시간은 1000 분의 1 초까지 지정할 수 있으며 지정된 시간이 지나면 
    다시 runnable(실행 가능한)상태로 돌아간다.
*/
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