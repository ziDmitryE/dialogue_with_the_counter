import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> myCallable = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(myCallable);
        tasks.add(myCallable2);
        tasks.add(myCallable3);

        System.out.println("Создаю потоки...");
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);

        // запуск invokeAll
        int msg = 0;
        final List<Future<Integer>> list = threadPool.invokeAll(tasks);
        for (Future<Integer> integerFuture : list) {
            msg += integerFuture.get();
        }
        System.out.println("кол-во выведенных в консоль сообщений: " + msg);

        // запуск invokeAny
        final int res = threadPool.invokeAny(tasks);
        System.out.println("кол-во выведенных в консоль сообщений: " + res);

        System.out.println("Завершаю все потоки.");
        threadPool.shutdown();
    }
}
