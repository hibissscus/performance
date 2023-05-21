import com.google.common.base.Stopwatch;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public abstract class BaseTest {

    abstract void calculation(int maxPrime);

    /**
     * @param maxPrime  inserted max prime number
     * @param threshold minimal execution time in milliseconds
     */
    protected void testRun(int maxPrime, int threshold) {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
            }
        }));
        final Stopwatch stopwatch = Stopwatch.createStarted();
        calculation(maxPrime);
        stopwatch.stop();
        assertTrue("Minimal execution time should be less then: " + threshold + "ms", stopwatch.elapsed().toMillis() <= threshold);
    }
}
