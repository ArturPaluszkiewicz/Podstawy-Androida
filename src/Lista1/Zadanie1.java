class Zadanie1.java {
    public static BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        BigInteger aBig = BigInteger.valueOf(a);
        while (!aBig.equals(BigInteger.ZERO)) {
            result = result.multiply(aBig);
            aBig = aBig.subtract(BigInteger.ONE);
        }
        return result;
    }
}
