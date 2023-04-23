import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;

public class PrimeCalculatorSimple {

    public static void main(String[] args) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        for (Integer prime : getPrimes(Integer.parseInt(args[0]))) {
            System.out.println(prime);
        }
        stopwatch.stop();
        System.out.println("Duration: " + stopwatch);
    }

    private static List<Integer> getPrimes(int maxPrime) {
        List<Integer> primeNumbers = Lists.newArrayList();
        int startNum = 2;
        while (startNum < maxPrime) {
            if (isPrime(startNum)) {
                primeNumbers.add(startNum);
            }
            startNum++;
        }

        return primeNumbers;
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