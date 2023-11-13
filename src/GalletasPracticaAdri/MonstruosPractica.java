package GalletasPracticaAdri;

import java.util.concurrent.Semaphore;

public class MonstruosPractica extends Thread{
    Semaphore esperaFuera, almacen, mutex;
    BeanPracticaAlmacen b;
    int galletasComidas;
    public MonstruosPractica(Semaphore esperaFuera, Semaphore almacen, Semaphore mutex, BeanPracticaAlmacen b) {
        this.esperaFuera=esperaFuera;
        this.almacen=almacen;
        this.mutex=mutex;
        this.b=b;
        galletasComidas=(int)(Math.random()*10+1);
    }

    public void run(){

        while (b.numRepuestos!=10){

            try{

                mutex.acquire();
                esperaFuera.release();
                almacen.acquire();
                System.out.println("Montruo " + Thread.currentThread().getId() + " entra en almacén");
                if(b.galletas==0){
                    mutex.release();
                    System.out.println("El monstruo " + Thread.currentThread().getId() + " sale del almacén porque no hay galletas. Galletas " + b.galletas);
                    almacen.release();
                    esperaFuera.acquire();
                } else {
                    b.galletas=b.galletas-galletasComidas;
                    if(b.galletas<0){
                        b.galletas=0;
                        System.out.println("El monstruo " + Thread.currentThread().getId() + " se ha comido todas las galletas. Galletas: " + b.galletas);
                    } else {
                        System.out.println("Monstruo " + Thread.currentThread().getId() + " se ha comido " + galletasComidas + " galletas. Quedan " + b.galletas);
                    }
                    mutex.release();
                    System.out.println("Monstruo " + Thread.currentThread().getId() + " sale del almacén");
                    almacen.release();
                    esperaFuera.acquire();
                }


            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

}
