package com.metlife;

import java.util.PriorityQueue;
import java.util.Random;

public class QueueDemo {

    public static void main(String[] args){
          //FIFO -- normal queue
        //sorted order
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
        for(int i=0;i<100;i++){
            //adding elements to queue
            priorityQueue.offer(new Random().nextInt(1000));
        }

        while(!priorityQueue.isEmpty()){
            //removing elements from queue
            System.out.println(priorityQueue.poll());
        }


    }

}
