/**
 * Задача 2. Отчет для налоговой
 **/

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 3; i++) {
            System.out.println("Выручка магазина " + (i + 1));
            executorService.submit(new Thread(store));
            Thread.sleep(100);
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("Итого сумма выручки с трех магазинов: " + store.getCurrentResult());
    }
}
