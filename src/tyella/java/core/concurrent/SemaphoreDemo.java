package tyella.java.core.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        MyThread thread1 = new MyThread(semaphore, "A");
        MyThread thread2 = new MyThread(semaphore, "B");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class MyThread extends Thread {

    private Semaphore semaphore;

    public MyThread(Semaphore semaphore, String name) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Starting " + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for permit.");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " get a permit.");
            Thread.sleep(1000);
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " release the permit.");
        }
    }
}