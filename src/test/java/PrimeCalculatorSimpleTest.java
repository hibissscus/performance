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

    /**
     * @param maxPrime  inserted max prime number
     * @param threshold minimal execution time in milliseconds
     */
    private static void testRun(int maxPrime, int threshold) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        PrimeCalculatorSimple.main(new String[]{String.valueOf(maxPrime)});
        stopwatch.stop();
        assertTrue("Execution time should be less then: " + threshold + "ms", stopwatch.elapsed().toMillis() < threshold);
    }

    @Test
    public void testWith_100() {
        testRun(100, 5);
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