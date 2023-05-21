import org.junit.Test;

/**
 * Tested on:
 * Apple M1 Pro, 32GB
 * macOS 12.1 mac-arm-64
 * OpenJDK 64-Bit Server VM; 17.0.2
 */
public class PrimeCalculatorTest extends BaseTest {

    @Override
    void calculation(int maxPrime) {
        try {
            PrimeCalculator.main(new String[]{String.valueOf(maxPrime)});
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testWith_100() {
        testRun(100, 12);
    }

    @Test
    public void testWith_10_000() {
        testRun(10000, 640);
    }

    @Test
    public void testWith_100_000() {
        testRun(100000, 4250);
    }

    @Test(expected = OutOfMemoryError.class)
    public void testWith_1_000_000_out_of_memory() {
        testRun(1000000, 1000000);
    }

}