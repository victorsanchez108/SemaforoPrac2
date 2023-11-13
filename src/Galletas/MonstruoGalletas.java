package Galletas;

import java.util.concurrent.Semaphore;

public class MonstruoGalletas extends Thread {
    Semaphore almacens;
    Semaphore galletas;
    Semaphore mutex;
    B b;
    int galletascomidas;

    public MonstruoGalletas(Semaphore repone, Semaphore come, Semaphore mutex, B b) {
        this.almacens = repone;
        this.galletas = come;
        this.mutex = mutex;
        this.b = b;
        galletascomidas=(int)(Math.random()*10)+1;

    }

    public void run() {
        while (b.repone <10) {
            try {
              galletas.acquire();
              mutex.acquire();
                if (b.galletas <=galletascomidas && b.galletas!=0) {
                    System.out.println("Quiero comerme " + galletascomidas + " pero no quedan me como las que hay " + b.galletas + " ID:" + Thread.currentThread().getId());
                    b.galletas = 0;

                    if(b.repone ==10){
                     galletas.release();
                    }else {
                        almacens.release();
                    }


                } else if (b.galletas ==0) {
                    
                } else{
                    System.out.println("Entro a comer estas galletas" + galletascomidas + " ID:" + Thread.currentThread().getId());
                    b.setGalletas(b.getGalletas() - galletascomidas);
                  galletas.release();


                }
                mutex.release();
                //almacens.release();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}