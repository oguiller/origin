package com.guille.origin.concurrency;

/**
 * Created by grodrigu on 11/12/2015.
 */
import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable{

    String name;
    private BlockingQueue<Coffee> queue;

    public Waiter(BlockingQueue<Coffee> q, String name){
        this.queue=q;
        this.name = name;
    }

    public void run() {
        try{
            Coffee msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
                Thread.sleep(10);
                System.out.println(this.name + " Delivering coffee to table "+ msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name){
        this.name = name;
    }
}
