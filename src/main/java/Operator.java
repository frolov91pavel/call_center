public class Operator implements Runnable {

    ATC atc;
    int sleep = 3000;
    String name;

    public Operator(ATC atc, String name) {
        this.atc = atc;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < atc.count; i++) {
            try {
                if (atc.calls.isEmpty()) {
                    System.out.println("Для " + name + " нет свободных звонков.");
                    Thread.sleep(1000);
                } else {
                    System.out.println(name + " обработал " + atc.calls.take());
                    Thread.sleep(sleep);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
