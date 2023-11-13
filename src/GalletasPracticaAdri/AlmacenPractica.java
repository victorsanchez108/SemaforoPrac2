package GalletasPracticaAdri;

import java.util.concurrent.Semaphore;

public class AlmacenPractica {
    /*
    * Realiza un programa que trate de un almacenero y tres monstruos. Todos entrarán de forma aleatoria, y el almacenero,
    * solamente cuando haya galletas que reponer. En caso contrario, deben esperar fuera su turno. El monstruo comerá un número de
    * galletas fijo, si no se puede comer el número de galletas correspondiente, se comerá todas. Si no hay galletas, saldrá del almacén.
    * El almacenero repondrá las galletas cuando no queden. El programa finaliza cuando el almacenero ha repuesto 10 veces.
    * */
    public static void main(String[] args) {

        Semaphore esperaFuera = new Semaphore(0);
        Semaphore almacen = new Semaphore(1);
        Semaphore mutex = new Semaphore(1);
        BeanPracticaAlmacen b = new BeanPracticaAlmacen();

        AlmaceneroPractica almacenero = new AlmaceneroPractica(esperaFuera, almacen, mutex, b);
        MonstruosPractica monstruo1 = new MonstruosPractica(esperaFuera, almacen, mutex, b);
        MonstruosPractica monstruo2 = new MonstruosPractica(esperaFuera, almacen, mutex, b);
        MonstruosPractica monstruo3 = new MonstruosPractica(esperaFuera, almacen, mutex, b);

        almacenero.start();
        monstruo1.start();
        monstruo2.start();
        monstruo3.start();

    }
}
