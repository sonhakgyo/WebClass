package Java_folder.thread_folder;

// 은행 계좌 인출 스레드를 사용해 멀티태스킹을 구현했을 때 발생하는 문제 확인

public class Thread_Synchro1 {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread mom = new Thread(atm, "엄마");
        Thread son = new Thread(atm, "아들");

        mom.start();
        son.start();
    }
}

class ATM implements Runnable {
    int money = 10000;
    public void run() {
        for(int i=0; i<5; i++) {
            withdraw(1000);
            printInfo();
            try {
                Thread.sleep(500); // 0.5초
            } catch(InterruptedException e) { }
        }
    }    

//  다른 스레드가 접근 못하도록 동기화하는 synchronized 키워드 붙이기
//  돈을 뽑는 작업을 동기화처리하여 멀티태스킹의 문제를 해결한다.
//  synchronized void withdraw(int money) {
    void withdraw(int money) {
        Thread.yield();
        this.money -= money;
        System.out.println(Thread.currentThread().getName() + "이(가)" + money + "원 출금");
    }

    void printInfo() {
        System.out.println("현재 잔액" + money + "원");
    }
}