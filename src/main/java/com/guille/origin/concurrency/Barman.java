package com.guille.origin.concurrency;

/**
 * Created by grodrigu on 11/12/2015.
 */
import java.util.concurrent.BlockingQueue;

public class Barman implements Runnable {

    private BlockingQueue<Coffee> queue;

    public Barman(BlockingQueue<Coffee> q){
        this.queue=q;
    }

    public void run() {
        //produce messages
        for(int i=0; i<10; i++){
            Coffee msg = new Coffee("Table "+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Coffee msg = new Coffee("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}