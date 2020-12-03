package producer_consumer_problem;

public class Consumer implements Runnable{

    EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                eventStorage.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
