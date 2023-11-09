package Museo;

import java.util.concurrent.Semaphore;

public class MuseoMain {
    public static void main(String[] args) {

        Semaphore visita = new Semaphore(10);
        Semaphore aforo = new Semaphore(5);
        Semaphore puerta = new Semaphore(2);
        Semaphore sala = new Semaphore(1);
        MuseoHilos h1 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h2 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h3 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h4 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h5 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h6 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h7 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h8 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h9 = new MuseoHilos(visita,aforo,puerta,sala);
        MuseoHilos h10 = new MuseoHilos(visita,aforo,puerta,sala);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();
        h7.start();
        h8.start();
        h9.start();
        h10.start();

    }
}
