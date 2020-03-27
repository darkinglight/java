import java.util.*;
import java.util.stream.*;
import static java.util.stream.LongStream.*;
import java.io.*;
import java.nio.file.*;

public class ParallelPrime {
    static final int COUNT = 100_000;
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long)Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        List<String> primes = iterate(2, i -> i + 1)
            .parallel()
            .filter(ParallelPrime::isPrime)
            .limit(COUNT)
            .mapToObj(Long::toString)
            .collect(Collectors.toList());
        long endTime =  System.currentTimeMillis();
        System.out.println(endTime - startTime);
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
    }
}
