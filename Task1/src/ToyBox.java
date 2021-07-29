public class ToyBox extends Thread {
    final Box box;

    public ToyBox(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        box.buttonOff();
    }
}


