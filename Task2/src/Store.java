import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Store implements Runnable {
    private final LongAdder amount = new LongAdder();

    @Override
    public void run() {

        for (long bit : arrayOfProceeds()) {
            System.out.print(bit + " ");
            amount.add(bit);
        }
        System.out.println();
    }

    public long[] arrayOfProceeds() {
        Random random = new Random();
        final int numberOfGoods = 9;
        final int  maxProductPrice  = 1500;
        long[] proceeds = new long[numberOfGoods];
        for (int i = 0; i < proceeds.length; i++) {
             proceeds[i] = random.nextInt(maxProductPrice);
        }
        return proceeds;
    }

    public long getCurrentResult() {
        return amount.sum();
    }
}
