package Java_folder.thread_folder;

// 스레드를 사용해 멀티태스킹을 구현했을 때 발생하는 문제 확인

public class Thread_Synchro {
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
                Thread.sleep(1000); // 1초
            } catch(InterruptedException e) { }
        }
    }    

    void withdraw(int money) {
        Thread.yield();
        this.money -= money;
        System.out.println(Thread.currentThread().getName() + "이(가)" + money + "원 출금");
    }

    void printInfo() {
        System.out.println("현재 잔액" + money + "원");
    }
}