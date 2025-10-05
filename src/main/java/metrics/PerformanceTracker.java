package metrics;

public class PerformanceTracker {
    public static long comparisons = 0;

    public static void reset() { comparisons = 0; }

    public static long measureTime(Runnable task) {
        reset();
        long start = System.nanoTime();
        task.run();
        return System.nanoTime() - start;
    }
}

