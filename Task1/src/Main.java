/**
 * Задача 1. Самая бесполезная коробка
 **/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        Gamer gamer = new Gamer(box);
        ToyBox toyBox = new ToyBox(box);
        Thread gamerThread = new Thread(null, gamer, "Поток игрока");
        Thread toyBoxThread = new Thread(null, toyBox, "Поток игрушки");
        gamerThread.start();
        toyBoxThread.start();
        gamerThread.join();
        toyBoxThread.interrupt();
    }
}

