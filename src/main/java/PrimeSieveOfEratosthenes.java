import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class PrimeSieveOfEratosthenes {

    public static void main(String[] args) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        for (Integer prime : getPrimes(Integer.parseInt(args[0]))) {
            System.out.println(prime);
        }
        stopwatch.stop();
        System.out.println("Duration: " + stopwatch);
    }

    public static List<Integer> getPrimes(int maxPrime) {
        BitSet sieve = new BitSet(maxPrime + 1);
        sieve.set(2, maxPrime + 1);

        for (int i = 2; i * i <= maxPrime; i++) {
            if (sieve.get(i)) {
                for (int j = i * i; j <= maxPrime; j += i) {
                    sieve.clear(j);
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= maxPrime; i++) {
            if (sieve.get(i)) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }
}
