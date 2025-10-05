package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoyerMooreTest {

    @Test
    void testMajorityExists() {
        int[] arr = {3, 3, 4, 2, 3, 3, 5, 3};
        assertEquals(3, BoyerMoore.findMajority(arr));
    }

    @Test
    void testNoMajority() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, BoyerMoore.findMajority(arr));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BoyerMoore.findMajority(arr));
    }

    @Test
    void testSingleElement() {
        int[] arr = {7};
        assertEquals(7, BoyerMoore.findMajority(arr));
    }
    @Test
    void testAllSameElements() {
        int[] arr = {5, 5, 5, 5};
        assertEquals(5, BoyerMoore.findMajority(arr));
    }

    @Test
    void testDuplicatesButNoMajority() {
        int[] arr = {1, 2, 1, 2, 3, 3};
        assertEquals(-1, BoyerMoore.findMajority(arr));
    }

}
