import static java.lang.System.*;

class Prime {
    public void checkPrime(int... values) {
        for (int i = 0; i < values.length; i++) {
            if (PrimeChecker.isPrime(values[i])) {
                System.out.print(values[i] + " ");
            }
        }
        System.out.print("\n");
    }
}

class PrimeChecker {
    public static boolean isPrime(int n) {
        if (n <= 1) { return false; }
        for (int i = 2; i <= (int)(n/2); i++) {
            if (n % i == 0) { return false; }
        }

        return true;
    }
}
