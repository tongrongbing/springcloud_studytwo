package com.home.springcloud.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author：tongrongbing
 * @date：created in 2020/6/9 16:27
 * @description：
 */
public class Test {
    private static final AtomicInteger serverIndexIncrement = new AtomicInteger(0); // 记录服务index
    private static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<5;i++){
            list.add(i);
        }
        for(int j = 0;j<6;j++){

            for(int i = 0;i<6;i++){
                Thread t = new Thread(()->{
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getAndincrementModulo();
                });
                t.start();
            }
            Thread.sleep(1000);
        }

        System.out.println(vector);
    }

    private static int getAndincrementModulo(){
        for(;;){
            int current = serverIndexIncrement.get();
            int next = (current+1) ;
            if(serverIndexIncrement.compareAndSet(current,next)){
                System.out.println(next);
                return current;
            }
        }
    }
}