/** Задача 2. Отчет для налоговой **/
public class Main {
    public static void main(String[] args) throws  InterruptedException{
        Store store = new Store();
        Thread thread = new Thread(null,()->store.total(store.addToArrayProceeds()),"Первый магазин");
        Thread thread1 = new Thread(null,()->store.total(store.addToArrayProceeds()),"Второй магазин");
        Thread thread2 = new Thread(null,()->store.total(store.addToArrayProceeds()),"Третий магазин");
        thread.start();
        Thread.sleep(100);
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.join();
        thread.join();
        thread2.join();
        System.out.println("Итого сумма выручки с трех магазинов: " + store.getCurrentResult());
    }
}
