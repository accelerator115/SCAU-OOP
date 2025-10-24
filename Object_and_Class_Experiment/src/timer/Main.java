package timer;

import timer.data.StopWatch;

public class Main {
    public static void main(String[] args) {
        // 创建计时器对象
        StopWatch stopWatch = new StopWatch();

        // 执行耗时较多的语句（循环很多次）
        stopWatch.start();
        for (long i = 0; i < 100000000; i++) {
            // 空循环
        }
        stopWatch.end();
        System.out.println("循环100000000次, 执行了" + stopWatch.getElapsedTime() + "毫秒");

        // 再次启动计时器
        stopWatch.start();
        for (long i = 0; i < 1000000000; i++) {
            // 空循环
        }
        stopWatch.end();
        System.out.println("循环1000000000次, 执行了" + stopWatch.getElapsedTime() + "毫秒");
    }
}