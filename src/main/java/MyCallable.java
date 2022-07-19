import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        int i = new Random().nextInt(2) + 3;
        for (int x = 1; x <= i; x++) {
            Thread.sleep(2500);
            System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
        }
        System.out.printf("%s завершен\n", Thread.currentThread().getName());
        return i;
    }
}
