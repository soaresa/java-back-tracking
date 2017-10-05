import java.util.Arrays;

public class BackTracking {
    private final int[] u;
    private boolean hasSolution;
    private int minCombinations;
    
    public BackTracking(int n, int[] sizes) {
        if (n < 1) throw new IllegalArgumentException("n must be greater than 0");
        int m = sizes.length;
        if (m == 0) throw new IllegalArgumentException("u length must be greater than 0");
        
        Arrays.sort(sizes);
        if (sizes[0] <= 0) throw new IllegalArgumentException("all umbrellas must be greater than 0");
        
        this.u = sizes.clone();
        this.hasSolution = false;
        this.minCombinations = n;
        this.calcMinCombinations(n, 0, 0);
    }
    
    private void calcMinCombinations (int n, int i, int count) {
        for (int j = i; j < u.length; j++) {
            n -= u[j];
            count++;
            if (n == 0) {
                if (count < minCombinations) {
                    minCombinations = count;
                }
                hasSolution = true;
            } else if (n > 0) {
                calcMinCombinations(n, j, count);
            }            
            n += u[j];
            count--;            
        }
    }
    
    public int getSolution() {
        if (hasSolution) return minCombinations;
        return -1;
    }
}
