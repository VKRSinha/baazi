import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedArrayTest {
    private BalancedArray test;
    private int arr[];
    private final int n = 5;

    @Test
    void balancedSum() {
       assertEquals(test.balancedSum(arr),3);
    }

    @BeforeEach
    void setUp() {
         test = new BalancedArray();
         arr = new int[]{1, 2, 3, 10, 6};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testBalancedSum() {
    }
}