package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        int button = scanner.nextInt();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> minute = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        while (button == 0) {
            String x = scanner.next();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            name.add(x);
            minute.add(y);
            second.add(z);
            i++;
            button = scanner.nextInt();
        }
        for (i = 0; name.size() > i; i++) {
            int M = minute.get(i);
            int S = second.get(i);
            final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            final Runnable runnable = new Runnable() {
                int countdownStarter = 60 * M + S;
                public void run() {
                    if (countdownStarter == 0) {
                        System.out.println("Time Over!");
                        scheduler.shutdown();
                    } else if (countdownStarter % 60 < 10) {
                        System.out.println(countdownStarter / 60 + ":0" + countdownStarter % 60);
                        countdownStarter--;
                    } else {
                        System.out.println(countdownStarter / 60 + ":" + countdownStarter % 60);
                        countdownStarter--;
                    }
                }
            };
            scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
            try {
                Thread.sleep((60 * M + S) * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}