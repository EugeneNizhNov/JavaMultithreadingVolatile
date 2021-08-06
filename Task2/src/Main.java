/**
 * Задача 2. Отчет для налоговой
 **/

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        int timeOut = 100;
        int numberOfStores = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < numberOfStores; i++) {
            System.out.println("Выручка магазина " + (i + 1));
            executorService.submit(new Thread(store));
            Thread.sleep(timeOut);
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("Итого сумма выручки с трех магазинов: " + store.getCurrentResult());
    }
}
