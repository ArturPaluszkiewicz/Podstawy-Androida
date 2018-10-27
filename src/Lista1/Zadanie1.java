package Lista1;
import java.math.BigInteger;

class Zadanie1 {
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
