package Galletas;

import java.util.concurrent.Semaphore;

public class Almacen {
    public static void main(String[] args) {
        Semaphore almacens = new Semaphore(1);
        Semaphore espera = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        B b = new B();

        MonstruoGalletas mg = new MonstruoGalletas(almacens,espera,mutex,b);
        MonstruoGalletas mg2 = new MonstruoGalletas(almacens,espera,mutex,b);
        MonstruoGalletas mg3 = new MonstruoGalletas(almacens,espera,mutex,b);
        Almacenero al = new Almacenero(almacens,espera,mutex,b);


        mg.start();
        mg2.start();
        mg3.start();
        al.start();



    }

}
