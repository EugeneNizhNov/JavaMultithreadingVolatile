import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Store implements Runnable {
    private final LongAdder amount = new LongAdder();
    private static final int NUMBER_OF_GOODS = 9;
    private static final int MAX_PRODUCT_PRICE = 1500;

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

        long[] proceeds = new long[NUMBER_OF_GOODS];
        for (int i = 0; i < proceeds.length; i++) {
            proceeds[i] = random.nextInt(MAX_PRODUCT_PRICE);
        }
        return proceeds;
    }

    public long getCurrentResult() {
        return amount.sum();
    }
}
