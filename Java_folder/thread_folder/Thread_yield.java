package Java_folder.thread_folder;
/*
yield
    자신의 시간을 양보하는 다른 스레드에게 메서드이다.
    스레드가 작업을 수행하던 중 yield()를 만나면 자신에게 할당된 시간을
    다음 차례 스레드에게 양도한다.
*/
public class Thread_yield {
    public static void main(String[] args) {
        MyThread4 s1 = new MyThread4();
        MyThread5 s2 = new MyThread5();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);

        t1.start();
        t2.start();
    }
}

class MyThread4 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<30; i++) {
            System.out.println("★");
            Thread.yield();
        }
    }
}

class MyThread5 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<30; i++) {
            System.out.println("☆");
        }
    }
}