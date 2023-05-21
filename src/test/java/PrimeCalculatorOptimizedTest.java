import org.junit.Test;

/**
 * Tested on:
 * Apple M1 Pro, 32GB
 * macOS 12.1 mac-arm-64
 * OpenJDK 64-Bit Server VM; 17.0.2
 */
public class PrimeCalculatorOptimizedTest extends BaseTest {

    @Override
    void calculation(int maxPrime) {
        PrimeCalculatorOptimized.main(new String[]{String.valueOf(maxPrime)});
    }

    @Test
    public void testWith_100() {
        testRun(100, 3);
    }

    @Test
    public void testWith_10_000() {
        testRun(10000, 11);
    }

    @Test
    public void testWith_100_000() {
        testRun(100000, 21);
    }

    @Test
    public void testWith_1_000_000() {
        testRun(1000000, 80);
    }

    @Test
    public void testWith_10_000_000() {
        testRun(10000000, 580);
    }
}