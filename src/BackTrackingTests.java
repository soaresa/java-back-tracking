import static org.junit.Assert.*;

import org.junit.Test;

public class BackTrackingTests {
    
    // Try    
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void tryWithUmbrellasEmpty() {
        int[] u = {};
        new BackTracking(1, u);
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void tryWithZeroPeople() {
        int[] u = {1};
        new BackTracking(0, u);
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void tryWithNegativePeople() {
        int[] u = {1};
        new BackTracking(-1, u);
    }
    
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void tryWithNegativeUmbrella() {
        int[] u = {-1};
        new BackTracking(1, u);
    }

    
    // One umbrella
    
    @Test
    public void oneUmbrellaSamePeopleSize() {
        int[] u1 = {1};
        assertEquals(1, (new BackTracking(1, u1)).getSolution());
        int[] u2 = {2};
        assertEquals(1, (new BackTracking(2, u2)).getSolution());
        int[] u3 = {10};
        assertEquals(1, (new BackTracking(10, u3)).getSolution());
        int[] u4 = {1000};
        assertEquals(1, (new BackTracking(1000, u4)).getSolution());
    }
    
    @Test
    public void oneUmbrellaBiggerThanPeopleSize() {
        int[] u1 = {2};
        assertEquals(-1, (new BackTracking(1, u1)).getSolution());
        int[] u2 = {10};
        assertEquals(-1, (new BackTracking(5, u2)).getSolution());
    }
    
    @Test
    public void oneUmbrellaSmallerThanPeopleSizeButNotFits() {
        int[] u1 = {2};
        assertEquals(-1, (new BackTracking(3, u1)).getSolution());
        int[] u2 = {10};
        assertEquals(-1, (new BackTracking(15, u2)).getSolution());
    }
    
    @Test
    public void oneUmbrellaSmallerThanPeopleSizeThatFits() {
        int[] u1 = {2};
        assertEquals(2, (new BackTracking(4, u1)).getSolution());
        int[] u2 = {10};
        assertEquals(3, (new BackTracking(30, u2)).getSolution());
    }
    
    
    // Two umbrellas
    
    @Test
    public void twoUmbrellasButNoSolution() {
        int[] u1 = {3, 2};
        assertEquals(-1, (new BackTracking(1, u1)).getSolution());
        int[] u2 = {3, 5};
        assertEquals(-1, (new BackTracking(4, u2)).getSolution());
        int[] u3 = {3, 5};
        assertEquals(-1, (new BackTracking(7, u3)).getSolution());
    }
    
    @Test
    public void twoUmbrellasSmallerFits() {
        int[] u1 = {3, 2};
        assertEquals(2, (new BackTracking(4, u1)).getSolution());
        int[] u2 = {6, 4};
        assertEquals(2, (new BackTracking(8, u2)).getSolution());
        int[] u3 = {30, 10};
        assertEquals(1, (new BackTracking(10, u3)).getSolution());
    }
    
    @Test
    public void twoUmbrellasBiggerFits() {
        int[] u1 = {1, 2};
        assertEquals(1, (new BackTracking(2, u1)).getSolution());
        int[] u2 = {3, 6};
        assertEquals(2, (new BackTracking(12, u2)).getSolution());
        int[] u3 = {2, 3};
        assertEquals(3, (new BackTracking(9, u3)).getSolution());
    }
    
    
    // Three umbrellas
    
    @Test
    public void threeUmbrellasMiddleBest() {
        int[] u1 = {1, 6, 8};
        assertEquals(2, (new BackTracking(12, u1).getSolution()));
        int[] u2 = {1, 6, 8};
        assertEquals(2, (new BackTracking(12, u2).getSolution()));
    }
    
    @Test
    public void threeUmbrellasButNoSolution() {
        int[] u = {3,5,7};
        assertEquals(-1, (new BackTracking(4, u).getSolution()));
    }
}
