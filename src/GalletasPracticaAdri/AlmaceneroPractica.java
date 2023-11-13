package GalletasPracticaAdri;



import java.util.concurrent.Semaphore;

public class AlmaceneroPractica extends Thread{
    Semaphore esperaFuera, almacen, mutex;
    BeanPracticaAlmacen b;
    public AlmaceneroPractica(Semaphore esperaFuera, Semaphore almacen, Semaphore mutex, BeanPracticaAlmacen b) {
        this.esperaFuera=esperaFuera;
        this.almacen=almacen;
        this.mutex=mutex;
        this.b=b;
    }

    public void run(){

        while (b.numRepuestos!=10){

            try {

                mutex.acquire();

               if(b.galletas==0){
                   esperaFuera.release();
                   almacen.acquire();
                   System.out.println("Almacenero entra en almacén");
                   b.galletas=10;
                   b.numRepuestos++;
                   System.out.println("Almacenero repone galletas. Quedan " + b.galletas + " y se ha repuesto " + b.numRepuestos + " veces");
                   System.out.println("Almacenero sale del almacén");
                   mutex.release();
                   almacen.release();
                   esperaFuera.acquire();
               } else {
                   mutex.release();
                   System.out.println("Almacenero espera fuera");
               }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        System.out.println("Programa terminado");

    }

}
