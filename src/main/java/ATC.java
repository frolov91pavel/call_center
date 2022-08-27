import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ATC implements Runnable {

    int count = 60;
    int sleep = 1000;
    BlockingQueue<String> calls = new ArrayBlockingQueue<>(60);

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            try {
                calls.offer("Звонок № " + i);
                System.out.println("Поступил звонок №" + i);
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
