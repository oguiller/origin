package com.guille.origin.concurrency;

/**
 * Created by grodrigu on 11/12/2015.
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Coffee> queue = new ArrayBlockingQueue<>(10);
        Barman barman = new Barman(queue);
        Waiter waiter1 = new Waiter(queue, "Waiter1");
        Waiter waiter2 = new Waiter(queue, "Waiter2");
        //starting producer to produce messages in queue
        new Thread(barman).start();
        //starting consumer to consume messages from queue
        new Thread(waiter1).start();
        new Thread(waiter2).start();
        System.out.println("Barman and Waiters has been started");
    }

}
