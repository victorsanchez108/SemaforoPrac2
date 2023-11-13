package Galletas;

import java.util.concurrent.Semaphore;

public class Almacenero extends Thread{
    Semaphore almacens;
    Semaphore galletas;
    Semaphore mutex;
    B b;

    public Almacenero(Semaphore repone, Semaphore come, Semaphore mutex, B b) {
        this.almacens = repone;
        this.galletas = come;
        this.mutex = mutex;
        this.b = b;
    }

    public void run() {
        try {

            while (b.repone <10) {
                almacens.acquire();
                if (b.galletas == 0) {
                    mutex.acquire();
                    b.galletas = 10;
                    b.repone++;
                    System.out.println("Repongo las galletas ID:" + Thread.currentThread().getId());
                    mutex.release();
                    System.out.println(b.repone + " Veces");
                    galletas.release();

                }
                //galletas.release();

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }

