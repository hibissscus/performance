import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeCalculatorOptimizedV2 {

    public static void main(String[] args) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        for (Integer prime : getPrimes(Integer.parseInt(args[0]))) {
            System.out.println(prime);
        }
        stopwatch.stop();
        System.out.println("Duration: " + stopwatch);
    }

    private static List<Integer> getPrimes(int maxPrime) {
        List<Integer> primeNumbers = Collections.synchronizedList(
                new ArrayList<>((int) (maxPrime / Math.log10(maxPrime))));
        IntStream.rangeClosed(2, maxPrime)
                .parallel()
                .filter(PrimeCalculatorOptimizedV2::isPrime)
                .forEach(primeNumbers::add);
        return primeNumbers.stream().sorted().collect(Collectors.toList());
    }

    private static boolean isPrime(int candidate) {
        if (candidate < 2) {
            return false;
        }
        if (candidate == 2 || candidate == 3) {
            return true;
        }
        if (candidate % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= candidate; i += 2) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}