package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Countdown {
    void countdown(int minute, int second) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int minute,second;
            int countdownStarter = 60 * minute + second;

            public void run() {
                System.out.println(countdownStarter / 60 + ":" + countdownStarter % 60);
                countdownStarter--;

                if (countdownStarter < 0) {
                    System.out.println("Time Over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
}