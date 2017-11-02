class MyCalculator {
    public long power(int x, int y) throws Exception {
            if (x < 0 || y < 0) {
                throw new Exception("n or p should not be negative.");
            }

            if (x == 0 && y == 0) {
                throw new Exception("n and p should not be zero.");
            }

        return (long)Math.pow(x, y);
    }

}
