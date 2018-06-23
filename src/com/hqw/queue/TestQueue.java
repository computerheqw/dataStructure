package com.hqw.queue;

import java.util.*;
/**
 * @author hqw521@qq.com
 * @date 2018/6/6 20:39
 */
public class TestQueue {
    public static void testLoopQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
