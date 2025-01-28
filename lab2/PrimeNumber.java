import java.util.Scanner;

class PrimeNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();

        // Get the count of primes using the sieve
        int primeCount = countPrimes(number);
        System.out.println(primeCount);
    }

    static int countPrimes(int n) {
        if (n < 2) {
            return 0; // No primes less than 2
        }

        boolean[] isPrime = new boolean[n + 1];
        // Assume all numbers are prime initially
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Mark non-prime numbers
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}