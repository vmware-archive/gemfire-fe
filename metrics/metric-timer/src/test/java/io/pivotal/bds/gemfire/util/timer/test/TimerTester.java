package io.pivotal.bds.gemfire.util.timer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.pivotal.bds.metrics.timer.Timer;

public class TimerTester {

    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        List<Runner> list = new ArrayList<>();

        for (int i = 1; i <= 3; ++i) {
            Timer t = new Timer("timer-" + i, true);
            Runner r = new Runner(t, i * 100, i * 100 + 100);
            list.add(r);
        }

        for (Runner r : list) {
            r.start();
        }

        Thread.sleep(10000L);

        for (Runner r : list) {
            r.kill();
        }
    }

    private static class Runner extends Thread {

        private Timer timer;
        private int min;
        private int max;
        private boolean running = true;

        public Runner(Timer timer, int min, int max) {
            this.timer = timer;
            this.min = min;
            this.max = max;
        }

        public void kill() {
            running = false;
        }

        @Override
        public void run() {
            try {
                while (running) {
                    timer.start();
                    long t = min + random.nextInt(max - min);
                    Thread.sleep(t);
                    timer.end();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
