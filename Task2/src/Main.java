/**
 * Задача 2. Отчет для налоговой
 **/

import java.util.concurrent.*;

public class Main {
    final static int TIMEOUT = 100;
    final static int NUMBER_OF_STORES = 3;

    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < NUMBER_OF_STORES; i++) {
            System.out.println("Выручка магазина " + (i + 1));
            executorService.submit(new Thread(store));
            Thread.sleep(TIMEOUT);
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("Итого сумма выручки с трех магазинов: " + store.getCurrentResult());
    }
}
