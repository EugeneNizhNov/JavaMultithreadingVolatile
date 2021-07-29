import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Store {
    private AtomicLong amount = new AtomicLong(0);

    public void total(long[] proceeds) {
        System.out.println("Выручка " + Thread.currentThread().getName());
        for (long bit : proceeds) {
            System.out.print(bit + " ");
            amount.getAndAdd(bit);
        }
        System.out.println();
    }

    public long[] addToArrayProceeds() {
        Random random = new Random();
        int bound = 1500;
        long[] proceeds = new long[9];
        for (int i = 0; i < proceeds.length; i++) {
            proceeds[i] = random.nextInt(bound);
        }
        return proceeds;
    }

    public long getCurrentResult() {
        return amount.get();
    }
}
