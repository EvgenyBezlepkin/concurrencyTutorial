package producer_consumer_problem;

public class Producer implements Runnable{

    EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                eventStorage.set();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
