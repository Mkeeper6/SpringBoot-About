package com.mkeeper.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 *    基于 Timer 实现的定时调度，基本就是手撸代码，目前应用较少，不是很推荐
 *
 * @author Mkeeper
 * @create 2018/9/28 11:12
 */
public class TimerDemo {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务: " + LocalDateTime.now());
            }
        };

        Timer timer = new Timer();

        // timerTask：需要执行的任务
        // delay：延迟时间（以毫秒为单位）
        // period：间隔时间（以毫秒为单位）
        timer.schedule(timerTask, 5000, 3000);

    }
}
