package Galletas;

import java.util.concurrent.Semaphore;

public class MonstruoGalletas extends Thread {
    Semaphore repone;
    Semaphore come;
    Semaphore mutex;
    B b;
    int galletascomidas;

    public MonstruoGalletas(Semaphore repone, Semaphore come, Semaphore mutex, B b) {
        this.repone = repone;
        this.come = come;
        this.mutex = mutex;
        this.b = b;
        galletascomidas=(int)(Math.random()*10)+1;

    }

    public void run() {
        while (b.repone != 10) {
            try {

                mutex.acquire();

            mutex.release();

              mutex.acquire();
                if (b.galletas < galletascomidas) {
                    System.out.println("Quiero comerme " + galletascomidas + " pero no quedan me como las que hay " + b.galletas + " ID:" + Thread.currentThread().getId());
                    b.galletas = 0;


                }else{
                    System.out.println("Entro a comer estas galletas" + galletascomidas + " ID:" + Thread.currentThread().getId());
                    b.setGalletas(b.getGalletas() - galletascomidas);
                    repone.release();


                }
                mutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}