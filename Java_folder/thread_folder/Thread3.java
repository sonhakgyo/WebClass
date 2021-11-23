package Java_folder.thread_folder;

public class Thread3 {
    public static void main(String[] args) {
    //  우선순위가 높을수록 더 빠른 순서를 잡을 수 있다.
    //  10 > 5 > 1 
    
        Runnable t = new MyThread3();         // 업캐스팅
        Thread t1 = new Thread(t, "thread1"); // new Thread(Runnable target, String name);
        t1.setPriority(1);                    // 우선순위 지정
        System.out.println("t1 우선순위 : " + t1.getPriority());

    //  우선순위를 지정하지 않으면 우선순위는 자동으로 5가 된다.
        Thread t2 = new Thread(t, "thread2");
        System.out.println("t2 우선순위 : " + t2.getPriority());

        Thread t3 = new Thread(t, "thread3");
        t3.setPriority(10);
        System.out.println("t3 우선순위 : " + t3.getPriority());

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("<" + Thread.currentThread().getName() + ">");
        }

        for(int i=0; i<1000; i++) {} // 시간 지연의 역할
    }
}