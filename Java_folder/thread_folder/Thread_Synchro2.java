package Java_folder.thread_folder;

// 한정된 티켓 수량을 멀티태스킹으로 티켓팅을 했을 때 발생할 수 있는 문제 확인

public class Thread_Synchro2 {
    public static void main(String[] args) {
        MyThread8 s1 = new MyThread8();

        Thread t1 = new Thread(s1, "상현");
        Thread t2 = new Thread(s1, "동원");
        Thread t3 = new Thread(s1, "윤호");

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread8 implements Runnable {
    Ticketing ticket = new Ticketing();

    @Override
    public void run() {
        ticket.ticketing();
    }
}

class Ticketing {
    int ticketNumber = 1;
    
    public void ticketing() {
        if(ticketNumber > 0) {
            System.out.println(Thread.currentThread().getName() + "이(가) 티켓팅 성공!");
            ticketNumber--;
        } else {
            System.out.println(Thread.currentThread().getName() + "이(가) 티켓팅 실패!");
        }
        System.out.println(Thread.currentThread().getName() + "이(가) 티켓팅 시도 후 티켓 수 : " + ticketNumber);
    }
}