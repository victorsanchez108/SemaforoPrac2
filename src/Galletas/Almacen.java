package Galletas;

import java.util.concurrent.Semaphore;

public class Almacen {
    public static void main(String[] args) {
        Semaphore repone = new Semaphore(0);
        Semaphore come = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        B b = new B();

        MonstruoGalletas mg = new MonstruoGalletas(repone,come,mutex,b);
        Almacenero al = new Almacenero(repone,come,mutex,b);

        mg.start();
        al.start();



    }

}
