class Even extends Thread {
    int n;
    Even(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Odd extends Thread {
    int n;
    Odd(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd: " + i);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class EvenOddThreadDemo {
    public static void main(String[] args) {
        int limit = 10;
        Even evenThread = new Even(limit);
        Odd oddThread = new Odd(limit);
        evenThread.start();
        oddThread.start();
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

