package Galletas;

import java.util.concurrent.Semaphore;

public class MonstruoGalletas extends Thread {
    Semaphore almacens;
    Semaphore espera;
    Semaphore mutex;
    B b;
    int galletascomidas;

    public MonstruoGalletas(Semaphore repone, Semaphore come, Semaphore mutex, B b) {
        this.almacens = repone;
        this.espera = come;
        this.mutex = mutex;
        this.b = b;
        galletascomidas=(int)(Math.random()*10)+1;

    }

    public void run() {
try {

        while (b.repone != 10) {

            espera.acquire();

            if (b.galletas <=galletascomidas) {

                mutex.acquire();
                System.out.println("Quiero comerme " + galletascomidas + " pero no quedan me como las que hay " + b.galletas + " ID:" + Thread.currentThread().getId());
               // b.setGalletas(b.getGalletas() - galletascomidas);
                b.galletas = 0;
                mutex.release();

            } else {
                mutex.acquire();
                System.out.println("Entro a comer estas galletas" + galletascomidas + " ID:" + Thread.currentThread().getId());
                b.setGalletas(b.getGalletas() - galletascomidas);
                mutex.release();


            }
            almacens.release();

        }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
