package Galletas;

import java.util.concurrent.Semaphore;

public class Almacen {
    public static void main(String[] args) {
        Semaphore almacen = new Semaphore(0);
        Semaphore galletas = new Semaphore(1);
        Semaphore mutex = new Semaphore(1);
        B b = new B();

        MonstruoGalletas mg = new MonstruoGalletas(almacen,galletas,mutex,b);
        MonstruoGalletas mg2 = new MonstruoGalletas(almacen,galletas,mutex,b);
        MonstruoGalletas mg3 = new MonstruoGalletas(almacen,galletas,mutex,b);
        Almacenero al = new Almacenero(almacen,galletas,mutex,b);

        al.start();
        mg.start();
        mg2.start();
        mg3.start();




    }

}
