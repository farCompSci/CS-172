public class Recursion {

    /**
     * Compute the sum of the first n natural numbers.
     * @param n a number >= 0
     * @return the sum of the first n natural numbers
     */
    public static int sumRange(int n) {
        /**int sum = 0;
        // ...

        for ( int i = 1 ; i <= n; i++){
            sum += i;
        }
        return sum;*/

        if ( n == 0 ){ return 0;}
        return sumRange(n-1) + n ;

    }

    /**
     * Compute the factorial of n.
     *
     * factorial n = 1 * 2 * 3 * ... * n
     *
     * @param n a number >= 1
     * @return factor of n
     */
    public static int fac(int n) {
        /**int fac = 1;
        // ...

        for ( int i = 1 ; i <= n ; i++){

            fac *= i;

        }
        return fac;*/

        if ( n == 1 ){ return 1;}
        return fac(n-1)*n;
    }

    /**
     * Compute the n-th harmonic number.
     *
     * H(n) = 1 + 1/2 + 1/3 + ... + 1/n
     *
     * @param n a number >= 1
     * @return the n-th harmonic number
     */
    public static double harmonic(int n) {
        /**double h = 0.0;
        // ...

        int j = 1;
        double numerator = 1.0;

        for ( int i = 1 ; i <= n ; i++){

            h += numerator/i ;

        }

        return h;*/

        if ( n == 1 ){ return 1.0;}
        return harmonic(n-1)+1.0/n;
    }

}
