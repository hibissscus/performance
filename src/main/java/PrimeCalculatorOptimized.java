import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeCalculatorOptimized {

    public static void main(String[] args) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        for (Integer prime : getPrimes(Integer.parseInt(args[0]))) {
            System.out.println(prime);
        }
        stopwatch.stop();
        System.out.println("Duration: " + stopwatch);
    }

    private static List<Integer> getPrimes(int maxPrime) {
        List<Integer> primeNumbers = Collections.synchronizedList(new ArrayList<>(maxPrime / 2));
        IntStream.rangeClosed(2, maxPrime)
                .parallel()
                .filter(PrimeCalculatorOptimized::isPrime)
                .forEach(primeNumbers::add);
        return primeNumbers.stream().sorted().collect(Collectors.toList());
    }

    private static boolean isPrime(int candidate) {
        if (candidate < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(candidate); i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}