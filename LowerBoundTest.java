import org.junit.* ;
import static org.junit.Assert.*;

public class LowerBoundTest {

    @Test
    public void testEntropy1() {
        char[] testArray = "ccccdddd".toCharArray();
        double entropy = LowerBound.entropy(testArray);
        assertTrue(entropy == 1.0);
    }

    @Test
    public void testLB2() {
        char[] testArray = "".toCharArray();
        double entropy = LowerBound.entropy(testArray);
        assertTrue(entropy == 0.0);
    }

    @Test
    public void testLB3() {
        char[] testArray = "aaaaaaaa".toCharArray();
        double entropy = LowerBound.entropy(testArray);
        assertTrue(entropy == 0.0);
    }

    @Test
    public void testLB4() {
        char[] testArray = "12345678".toCharArray();
        double entropy = LowerBound.entropy(testArray);
        assertTrue(entropy == 3.0);
    }
}
