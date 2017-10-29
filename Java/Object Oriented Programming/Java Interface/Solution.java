class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        if (n == 1) {
            return 1;
        }
        int counter = 0;
        int i = 1;
        while(i <= (int)Math.ceil(n/2.0)) {
            if (n % i == 0) { counter += i; }
            i++;
        }

        if (i != n) { counter += n; }

        return counter;
    }
}
