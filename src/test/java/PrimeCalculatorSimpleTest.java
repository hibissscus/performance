import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tested on:
 * Apple M1 Pro, 32GB
 * macOS 12.1 mac-arm-64
 * OpenJDK 64-Bit Server VM; 17.0.2
 */
public class PrimeCalculatorSimpleTest {

    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    /**
     * @param maxPrime  inserted max prime number
     * @param threshold minimal execution time in milliseconds
     */
    private static void testRun(int maxPrime, int threshold) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        PrimeCalculatorSimple.main(new String[]{String.valueOf(maxPrime)});
        stopwatch.stop();
        assertTrue("Execution time should be less then: " + threshold + "ms", stopwatch.elapsed().toMillis() < threshold);
        // Calculate the used memory
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased:" + bytesToMegabytes(usedMemoryAfter-usedMemoryBefore));
    }

    @Test
    public void testWith_100() {
        testRun(100, 15);
    }

    @Test
    public void testWith_10_000() {
        testRun(10000, 20);
    }

    @Test
    public void testWith_100_000() {
        testRun(100000, 50);
    }

    @Test
    public void testWith_1_000_000() {
        testRun(1000000, 170);
    }

    @Test
    public void testWith_10_000_000() {
        testRun(10000000, 2000);
    }

}