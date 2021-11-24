package Java_folder.thread_folder;

public class Thread_Synchro3 {
    public static void main(String[] args) {
        Account account = new Account();

        Son son = new Son(account);
        Mom mom = new Mom(account);

        son.start();
        mom.start();
    }
}

class Account {
    int money = 0;

//  현재 Money를 반환하는 메서드
    public int showMoney() {
        return money;
    }
//  입금 setMoeny() 메서드
    public synchronized void setMoney() {
        try {
            Thread.sleep(500); // 0.5초 sleep
        } catch(InterruptedException ie) {
            System.out.println(ie.toString());
        }
        this.money += 2000;
        System.out.println("어머니가 용돈을 입금했습니다. 현재 잔액 : " + this.showMoney());
        this.notify(); // 자고 있는 객체를 깨운다.
    }
//  출금 getMoney() 메서드
    public synchronized void getMoney() {
        while(money <= 0) { // money가 0보다 작거나 같아진다면 작업내용 수행
            try {
                System.out.println("통장잔고가 없어 아들 대기 중");
                this.wait(); // notify() 메서드가 깨울 때까지 대기한다.
            } catch(InterruptedException ie) {}
        }
        this.money -= 2000;
        System.out.println("아들이 용돈을 출금했습니다. 현재 잔액 : " + this.showMoney());
    }
}

class Son extends Thread {
    private Account account;

    Son(Account account) {
        this.account = account;
    }

    public void run() {
        for(int i=0; i<10; i++) {
            account.getMoney();
        }
    }
}

class Mom extends Thread {
    private Account account;

    Mom(Account account) {
        this.account = account;
    }

    public void run() {
        for(int i=0; i<10; i++) {
            account.setMoney();
        }
    }
}