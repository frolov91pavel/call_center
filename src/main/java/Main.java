import java.util.ArrayList;
import java.util.List;
 
public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        ATC atc = new ATC();
        Operator operator1 = new Operator(atc, "Оператор №1");
        Operator operator2 = new Operator(atc, "Оператор №2");
        Operator operator3 = new Operator(atc, "Оператор №3");

        Runnable logicATC = () -> {
            atc.run();
        };

        Runnable logicOperator1 = () -> {
            operator1.run();
        };

        Runnable logicOperator2 = () -> {
            operator2.run();
        };

        Runnable logicOperator3 = () -> {
            operator3.run();
        };

        threads.add(new Thread(logicATC));
        threads.add(new Thread(logicOperator1));
        threads.add(new Thread(logicOperator2));
        threads.add(new Thread(logicOperator3));

        for (Thread thread : threads) {
            thread.start();
        }

    }

}