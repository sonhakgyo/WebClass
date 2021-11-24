package Java_folder.thread_folder;

// 한정된 티켓 수량을 멀티태스킹으로 티켓팅을 했을 때 발생할 수 있는 문제 확인

// 티켓 수량이 0일 때만 티켓팅이 성공해야 하므로 '동원', '윤호'는 티켓팅이 되면 안 된다.
// 그러나 '동원', '윤호'도 티켓팅이 성공해 ticketNumber가 음수가 되는 것을 볼 수 있다.
// 이유는 조건문을 걸었지만 '상현'이 티켓팅한 후 ticketNumber를 감소시키기 전에
// '동원', '윤호'의 티켓팅 코드가 통과했기 때문에 가능한 것을 알 수 있다.

// 따라서 이런 문제를 해결하기 위해 
// 스레드가 동시에 자원을 접근하는 것을 제한하는 스레드 동기화 작업이 필요하다.

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
//      영역을 지정하여 동기화 처리로 발생할 수 있는 문제를 해결한다.  
//      synchronized(this) { // this는 현재 객체를 가리킨다.
            if(ticketNumber > 0) {
                System.out.println(Thread.currentThread().getName() + "이(가) 티켓팅 성공!");
                ticketNumber--;
            } else {
                System.out.println(Thread.currentThread().getName() + "이(가) 티켓팅 실패!");
            }
            System.out.println(Thread.currentThread().getName() + "이(가) 티켓팅 시도 후 티켓 수 : " + ticketNumber);
//      }
    }
}