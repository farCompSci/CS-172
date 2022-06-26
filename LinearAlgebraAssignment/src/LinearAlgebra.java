/**
 * Various functions dealing with vectors and matrices.
 *
 * Farjad Madataly
 */
class LinearAlgebra {

    /**
     * Returns the magnitude of the vector v (which may be of any length).
     * This is found by adding up the squares of all of the elements of v
     * and taking the square root of the total.
     */
    static double magnitude(double[] v) {

        // Initializing the sum variables

        double sumSquared = 0.0;
        double finalSum;

        int i = 0;
        while (i < v.length){
            sumSquared += v[i]*v[i];    // This loop calculates the square of the sums of the magnitude
            i++;
        }

        finalSum = Math.sqrt(sumSquared); // Final step to find the magnitude is to find the square root

        return finalSum;
    }

    /**
     * Returns the sum of vectors v and w. This is a vector of the same
     * length, each of whose elements is the sum of the corresponding
     * elements in v and w.
     */
    static double[] sum(double[] v, double[] w) {

        double[] sumVector = new double[v.length]; // setting the answer array to the length of the input array

        int i = 0;
        while(i<v.length){
            sumVector[i] = v[i] + w[i]; // summing
            i++;
        }

        return sumVector;

    }

    /**
     * Returns the difference between vectors v and w. This is a vector
     * of the same length, each of whose elements is the difference
     * between the corresponding elements in v and w.
     */
    static double[] difference(double[] v, double[] w) {

        double[] difference = new double[v.length];

        int j = 0;
        while(j<w.length){
            difference[j] = v[j] - w[j]; // repeat process as for sum, but change it to a subtraction
            j++;
        }

        return difference;

    }

    /**
     * Returns the element-wise between vectors v and w. This is a vector
     * of the same length, each of whose elements is the product of the
     * corresponding elements in v and w.
     */
    static double[] elementwiseProduct(double[] v, double[] w) {

        double[] product = new double[v.length];

        int i=0;
        while(i < v.length){
            product[i] = v[i]*w[i];     // finding the values that correspond to the coordinates and multiplying them
            i++;
        }

        return product;
    }

    /**
     * Returns the dot product of vectors v and w. This is the sum of
     * the products of the corresponding elements.
     */
    static double dotProduct(double[] v, double[] w) {
        double productV = 1;
        double productW = 1;
        double sum = 0;

        int i = 0;
        while (i < v.length){
            productV *= v[i];       // incrementing the product of the terms in v[]
            i++;
        }

        sum += productV;

        int j = 0;                  // incrementing product of the terms in w[]. Because not mentioned, I assume they can be different
        while (j < w.length){
            productW *= w[j];
            j++;
        }

        sum += productW;  // adding the product of the terms in v[] to those in w[]


        return sum;
    }

    /**
     * Returns, as an array of two elements, the dimensions of matrix m.
     */
    static int[] dimensions(double[][] m) {
        int[] result = new int[]{m.length,m[0].length};  // m.length refers to the rows
        return result;                                   // m[0].length refers to the columns

    }

    /**
     * Returns the element-wise sum of matrices m and n.
     */
    static double[][] sum(double[][] m, double[][] n) {
        int i = 0;
        double[][] result = new double[m[0].length][m.length];

        while (i < m.length){

            int j = 0;
            while (j < m[i].length){
                result[i][j] = m[i][j] + n[i][j]; // finding the coordinates of the terms and adding them to each other
                j++;
            }
            i++;
        }
        return result;
    }

    /**
     * Returns the element-wise product of matrices m and n.
     */
    static double[][] elementwiseProduct(double[][] m, double[][] n) {
        int i = 0;
        double[][] product = new double[m[0].length][m.length];

        while (i < m.length){
            int j = 0;
            while (j < m[i].length){
                product[i][j] = m[i][j] * n[i][j]; // same process as for addition, but multiply
                j++;
            }
            i++;
        }
        return product;
    }

    /**
     * Returns the transpose of m, that is, a matrix where element
     * i, j is element j, i from m.
     */
    static double[][] transpose(double[][] m) {
        double[][] result = new double[m[0].length][m.length];

        int i = 0;
        while (i < m.length){
            int j = 0;
            while (j < m[0].length){
                result[j][i] = m[i][j]; // this line shows how to inverse i and j's values in a new array
                j++;                    // thus, transposition is accomplished
            }
            i++;
        }
        return result;
    }

    /**
     * Returns the matrix product of m and n. (Search the web for a
     * definition.)
     */
    static double[][] product(double[][] m, double[][] n) {
        double answerMatrix[][] = new double[m.length][n[0].length];
        int sum = 0;

        if (m[0].length == n.length) {
            for (int rows = 0; rows < m.length ; rows++){
                for (int columns = 0; columns < n[0].length; columns++){ // this is the order that has to be followed
                    for (int i = 0; i < m[0].length; i++ ){  // necessary loop to use the matrix product formula
                        sum += m[rows][i] * n[i][columns]; // formula for multiplication of matrices
                    }
                    answerMatrix[rows][columns] = sum; // assigning the value to the answer matrix
                    sum = 0; // resetting sum to 0 so that it can produce values for other coordinates in the result matrix
                }
            }
        }

        return answerMatrix;
    }

}