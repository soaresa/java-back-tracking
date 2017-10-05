/**
 * @author Adalberto Soares
 * 
 */


/**
 * Calculates the exact minimum number of umbrellas to cover n people.
 */
public class BackTracking {
    private boolean hasSolution;
    private int minUmbrellas;
    
    /**
     * Instantiate solution
     * 
     * @param n             number of people
     * @param umbrellas     array with umbrellas sizes
     */
    public BackTracking(int n, int[] umbrellas) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        int m = umbrellas.length;
        if (m == 0) throw new IllegalArgumentException("umbrellas length must be greater than 0");
        for (int i = 0; i < m; i++) {
            if (umbrellas[i] <= 0) {
                throw new IllegalArgumentException("all umbrellas must be greater than 0");
            }
        }
        
        this.hasSolution = false;
        this.minUmbrellas = n;
        this.calcMinUmbrellas(n, umbrellas, 0, 0);
    }
    
    /**
     * Recursive method to calculate minimum number of umbrellas to cover exact n people
     * 
     * @param n     number of people
     * @param i     index to access umbrellas
     * @param count number of umbrellas
     */
    private void calcMinUmbrellas(int n, int[] umbrellas, int i, int count) {
        for (int j = i; j < umbrellas.length; j++) {
            int residual = n - umbrellas[j];
            int newCount = count + 1;
            if (residual == 0) {
                if (newCount < minUmbrellas) {
                    minUmbrellas = newCount;
                }
                hasSolution = true;
            } else if (residual > 0 && newCount < minUmbrellas) {
                calcMinUmbrellas(residual, umbrellas, j, newCount);
            }         
        }
    }
    
    /**
     * Get solution of calcMinUmbrellas
     * 
     * @return minimum number of umbrellas or -1 if it has no solution
     */
    public int getSolution() {
        if (hasSolution) {
            return minUmbrellas;
        }
        return -1;
    }
}
