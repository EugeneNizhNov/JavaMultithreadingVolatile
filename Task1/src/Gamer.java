public class Gamer extends Thread {

    final private Box box;

    public Gamer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        box.buttonOn();
    }
}