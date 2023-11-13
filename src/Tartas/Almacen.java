package Tartas;

import java.util.concurrent.Semaphore;

public class Almacen {
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        Semaphore pasteleros = new Semaphore(0);
        Semaphore Dependiente = new Semaphore(1);



    }
}
