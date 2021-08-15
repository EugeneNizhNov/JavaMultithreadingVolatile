import java.util.Random;

public class Box extends Thread {
    private volatile static boolean button;
    private static final int MAX_PAUSE_AMOUNT = 2500;
    private static final int TOGGLE_SWITCH_COUNT = 5;

    public void buttonOn() {
        int count = 0;

        try {
            while (!isInterrupted()) {
                while (!button) {
                    System.out.println("Игрок включает тумблер ");
                    Thread.sleep(timeOut());
                    button = true;
                    count++;
                }
                if (count == TOGGLE_SWITCH_COUNT) {
                    return;
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
                    System.out.println("Игрушка из коробки выключает тумблер ");
                    Thread.sleep(timeOut());
                    button = false;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " остановлен");
        }
    }

    public int timeOut() {
        Random random = new Random();
        return random.nextInt(MAX_PAUSE_AMOUNT);
    }
}
