package com.sensetime.thinkJava.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description：</p>
 * <p>Copyright：Copyright (c) 2016</p>
 * <p>Company：SenseTime</p>
 * <p>Email：shaohaiyan@sensetime.com</p>
 *
 * @author shaohaiyan
 * @date 16-4-7:上午11:31
 */
public class Exercise21 {
public static void main(String [] args){
    ExecutorService executorService= Executors.newCachedThreadPool();
    Runnable task1=new Task1();
    Runnable task2=new Task2(task1);
    executorService.execute(task1);
    executorService.execute(task2);
    Thread.yield();
    executorService.shutdown();
}


}

//一开始就wait
class Task1 implements Runnable{


    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
                System.out.println("离开letWait（）");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Task2 implements Runnable{
    private Runnable  runnable;
    public Task2(Runnable runnable){
        this.runnable=runnable;
    }
    @Override
    public void run() {
        try {
            System.out.println("Task2开始执行");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("开始唤醒  "+runnable);

        }catch (Exception e){
            e.printStackTrace();
        }

        synchronized (runnable){
            runnable.notifyAll();
        }
    }
}
