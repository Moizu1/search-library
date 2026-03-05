package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class searchTest {

	
	@Test
    public void testBinarySearch() {
        int[] arr = {1, 3, 5, 7, 9, 11};

        int result = unittesting.binarySearch(arr, 7);
        assertEquals(6, result);

        assertEquals(-1, unittesting.binarySearch(arr, 4));
    }
    @Test
    public void testLinearSearch() {
        int[] arr = {10, 20, 30, 40, 50};

        // Element exists
        int result = unittesting.linearSearch(arr, 30);
        assertEquals(3, result);

        // Element does not exist
        assertEquals(-1, unittesting.linearSearch(arr, 99));
    }

    @Test
    public void testJumpSearch() {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};

        // Element exists
        int result = unittesting.jumpSearch(arr, 10);
        assertEquals(4, result);

        // Element does not exist
        assertEquals(-1, unittesting.jumpSearch(arr, 5));
    }
    }
