import java.util.Random;

public class Box extends Thread {
    private volatile static boolean button;


       public void buttonOn() {
        int count = 0;
        int iteration = 5;
        try {
            while (!isInterrupted()) {
                while (!button) {
                    System.out.println("Игрок включает тумблер");
                    Thread.sleep(timeOut());
                    button = true;
                    count++;
                }
                if (count == iteration) {
                    interrupt();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buttonOff() {

        try {
            while (!isInterrupted()) {
                while (button) {
                    System.out.println("Игрушка из коробки выключает тумблер");
                    Thread.sleep(timeOut());
                    button = false;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " has been interrupted");
        }
    }

    public int timeOut(){
        Random random = new Random();
        int bound = 2500;
        return random.nextInt(bound);

    }

}
