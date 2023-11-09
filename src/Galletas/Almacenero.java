package Galletas;

import java.util.concurrent.Semaphore;

public class Almacenero extends Thread{
    Semaphore repone;
    Semaphore come;
    Semaphore mutex;
    B b;

    public Almacenero(Semaphore repone, Semaphore come, Semaphore mutex, B b) {
        this.repone = repone;
        this.come = come;
        this.mutex = mutex;
        this.b = b;
    }

    public void run() {
        while (b.repone != 10) {
            try {

                mutex.acquire();
                if (b.galletas == 0) {
                    System.out.println("Repongo las galletas ID:" +Thread.currentThread().getId());
                    b.galletas = 10;
                    b.repone++;
                    System.out.println(b.repone + " Veces");
                    come.release();
                }
                mutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
