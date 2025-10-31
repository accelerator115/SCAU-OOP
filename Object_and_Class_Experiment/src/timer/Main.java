package timer;

import timer.data.StopWatch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        for (long i = 0; i < 100000000; i++) {

        }
        stopWatch.end();
        System.out.println("循环100000000次, 执行了" + stopWatch.getElapsedTime() + "毫秒");

        stopWatch.start();
        for (long i = 0; i < 1000000000; i++) {

        }
        stopWatch.end();
        System.out.println("循环1000000000次, 执行了" + stopWatch.getElapsedTime() + "毫秒");
    }
}