package Museo;

import java.util.concurrent.Semaphore;

public class MuseoHilos extends Thread{

    Semaphore visita;
    Semaphore aforo;
    Semaphore sala;
    Semaphore puerta;

    public MuseoHilos(Semaphore visita, Semaphore aforo, Semaphore sala, Semaphore puerta) {
        this.visita = visita;
        this.aforo = aforo;
        this.sala = sala;
        this.puerta = puerta;
    }

    public void run(){
        try {
        

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
