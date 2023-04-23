import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tested on:
 * Apple M1 Pro, 32GB
 * macOS 12.1 mac-arm-64
 * OpenJDK 64-Bit Server VM; 17.0.2
 */
public class PrimeCalculatorTest {

    /**
     * @param maxPrime  inserted max prime number
     * @param threshold minimal execution time in milliseconds
     */
    private static void testRun(int maxPrime, int threshold) throws InterruptedException {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        PrimeCalculator.main(new String[]{String.valueOf(maxPrime)});
        stopwatch.stop();
        assertTrue("Execution time should be less then: " + threshold + "ms", stopwatch.elapsed().toMillis() < threshold);
    }

    @Test
    public void testWith_100() throws InterruptedException {
        testRun(100, 15);
    }

    @Test
    public void testWith_10_000() throws InterruptedException {
        testRun(10000, 800);
    }

    @Test
    public void testWith_100_000() throws InterruptedException {
        testRun(100000, 5000);
    }

    @Test(expected = OutOfMemoryError.class)
    public void testWith_1_000_000_out_of_memory() throws InterruptedException {
        testRun(1000000, 1000000);
    }

}