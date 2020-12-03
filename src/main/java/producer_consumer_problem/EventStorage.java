package producer_consumer_problem;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {

    private int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        maxSize=10;
        storage = new LinkedList<>();
    }

    public synchronized void set() throws InterruptedException {
        while (storage.size() == maxSize) {
            wait();
        }
        storage.offer(new Date());
        System.out.println("set " + storage.size());
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (storage.size() == 0) {
            wait();
        }
        String el = storage.poll().toString();
        System.out.println("get " + storage.size() + " and element = " + el);
        notify();
    }
}
