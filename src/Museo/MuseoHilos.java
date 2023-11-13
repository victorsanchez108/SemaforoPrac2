package Museo;

import java.util.concurrent.Semaphore;

public class MuseoHilos extends Thread{

    Semaphore visita;
    Semaphore aforo;
    Semaphore sala;
    Semaphore puerta;

    Semaphore bus;

    Semaphore mutex;
    Bean b;


    public MuseoHilos(Semaphore visita, Semaphore aforo, Semaphore sala, Semaphore puerta, Semaphore bus, Bean b,Semaphore mutex) {
        this.visita = visita;
        this.aforo = aforo;
        this.sala = sala;
        this.puerta = puerta;
        this.bus = bus;
        this.b = b;
        this.mutex = mutex;

    }

    public void run(){
        try {
            if(b.visita==9){
                Thread.sleep(100);
                for (int i = 0;i<=b.visita;i++){
                    visita.release(9);
                }
                System.out.println("Hemos llegado todos");

            }else{
                mutex.acquire();
                b.visita++;
                mutex.release();
                System.out.println("Llegamos de visita " + Thread.currentThread().getId());
                visita.acquire();

            }
            aforo.acquire();
            System.out.println("Entro al museo" + Thread.currentThread().getId());
            puerta.acquire();
            System.out.println("Entro por la puerta" + Thread.currentThread().getId());
            puerta.release();
            sala.acquire();
            System.out.println("entro en la sala"+ Thread.currentThread().getId());
            sala.release();
            System.out.println("Salgo de la sala"+ Thread.currentThread().getId());
            aforo.release();
            if (b.bus == 9) {
                for (int x = 0; x <=9; x++) {
                    bus.release();

                }
                System.out.println("Nos vamos" + Thread.currentThread().getId());
            } else {
                mutex.acquire();
                b.bus++;
                mutex.release();
                System.out.println("Espero a que lleguen todos al bus" + Thread.currentThread().getId());
                bus.acquire();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

