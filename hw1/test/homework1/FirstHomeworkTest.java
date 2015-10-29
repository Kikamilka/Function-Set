package homework1;

import org.junit.Test;
import static org.junit.Assert.*;

public class FirstHomeworkTest {
    
    private final double EPSILON = 0.00001;

    public FirstHomeworkTest() {
    }

    @Test
    public void testCountSymbols() {
        System.out.println("Testing of  countSymbols");
        assertEquals(0, FirstHomework.countSymbols("", ' '));
        assertEquals(2, FirstHomework.countSymbols("Hello word!!!", 'o'));
        assertEquals(3, FirstHomework.countSymbols("Hello word!!!", '!'));
        assertEquals(3, FirstHomework.countSymbols("!!1234532557745!fet6664", '4'));
        assertEquals(3, FirstHomework.countSymbols(" hi  man", ' '));
    }

    @Test
    public void testEqualStrings() {
        System.out.println("Testing of equalStrings");
        assertEquals(false, FirstHomework.equalStrings(null));
        assertEquals(true, FirstHomework.equalStrings(new String[]{"Cat", "Dog", "Banana", "Banana", "10"}));
        assertEquals(true, FirstHomework.equalStrings(new String[]{"Cat", "Cat", "Banana", "10", "10"}));
        assertEquals(false, FirstHomework.equalStrings(new String[]{"1", "2", "Banana", "sun", "Java"}));
        assertEquals(true, FirstHomework.equalStrings(new String[]{" ", "211133!!", " ", "sun", "Java"}));
        assertEquals(false, FirstHomework.equalStrings(new String[]{"1", "11", "111", "1 ", "  1"}));
    }

    @Test
    public void testMultiplyMatrixs() {
        System.out.println("Testing of multiplyMatrixs");
        try {
            FirstHomework.multiplyMatrixs(null, null);
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }

        int[][] result = FirstHomework.multiplyMatrixs(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});
        int[][] expResult = new int[][]{{14, 32, 50}, {32, 77, 122}, {50, 122, 194}};
        assertArrayEquals(expResult, result);
        
        result = FirstHomework.multiplyMatrixs(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{4, 5}, {7, 8}, {4, 1}});
        expResult = new int[][]{{30, 24}, {75, 66}};
        assertArrayEquals(expResult, result);
        
        result = FirstHomework.multiplyMatrixs(new int[][]{{0, 0}, {0, 0}}, new int[][]{{4, 5}, {1, 2}});
        expResult = new int[][]{{0, 0}, {0, 0}};
        assertArrayEquals(expResult, result);
        
        try {
            FirstHomework.multiplyMatrixs(new int[][]{{1, 2}, {4, 5}}, new int[][]{{1, 4, 0}});
            fail("Matrix's dimension doesn't correct!");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testIntersectArrays() {
        System.out.println("Testing intersectArrays");
        assertArrayEquals(new double[]{}, FirstHomework.intersectArrays(null, null), EPSILON);
        assertArrayEquals(new double[]{}, FirstHomework.intersectArrays(null,  new double[]{}), EPSILON);
        assertArrayEquals(new double[]{}, FirstHomework.intersectArrays(new double[]{},  new double[]{}), EPSILON);
        assertArrayEquals(new double[]{3.0, 6.0, 7.0, 7.0}, FirstHomework.intersectArrays(new double[]{2, 3, 6, 7, 7},  new double[]{3, 3, 7, 7, 9, 6}), EPSILON);
        assertArrayEquals(new double[]{1.00001, 7.7, 8, 8.23}, FirstHomework.intersectArrays(new double[]{1.00001, 1.3, 7.7, 8, 8.23},  new double[]{3, 8, 7.7, 8.23, 1.001, 5, 1.00001}), EPSILON);
        assertArrayEquals(new double[]{0.0}, FirstHomework.intersectArrays(new double[]{1.01, 0.1, 0, 1.01},  new double[]{0.01, 0.0, 0.001}), EPSILON);
    }

}
