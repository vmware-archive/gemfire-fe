package io.pivotal.bds.gemfire.util.timer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.pivotal.bds.metrics.rater.Rater;

public class RaterTester {

    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        List<Runner> list = new ArrayList<>();

        for (int i = 1; i <= 3; ++i) {
            Rater r = new Rater("rater-" + i);
            Runner rn = new Runner(r, i * 10, i * 10 + 10);
            list.add(rn);
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

        private Rater rater;
        private int min;
        private int max;
        private boolean running = true;

        public Runner(Rater rater, int min, int max) {
            this.rater = rater;
            this.min = min;
            this.max = max;
        }

        public void kill() {
            running = false;
        }

        public void run() {
            try {
                while (running) {
                    if (random.nextInt(100) < 10) {
                        long t = min + random.nextInt(max - min);
                        Thread.sleep(t);
                    }

                    rater.increment();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
