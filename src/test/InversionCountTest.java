import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Jacob Ho
 */
public class InversionCountTest {
    @Test
    public void count() {
        int[] ints = {1};
        assertEquals(0, InversionCount.count(ints));
        ints = new int[]{1, 2};
        assertEquals(0, InversionCount.count(ints));
        ints = new int[]{2, 1};
        assertEquals(1, InversionCount.count(ints));
        ints = new int[]{3, 2, 1};
        assertEquals(3, InversionCount.count(ints));
        ints = new int[]{3, 1, 2};
        assertEquals(2, InversionCount.count(ints));
        ints = new int[]{1, 3, 5, 2, 4, 6};
        assertEquals(3, InversionCount.count(ints));
        ints = new int[]{1, 2, 3, 4, 5, 6};
        assertEquals(0, InversionCount.count(ints));
        ints = new int[]{2, 4, 1, 3, 5};
        assertEquals(3, InversionCount.count(ints));
        ints = new int[]{6, 5, 4, 3, 2, 1};
        assertEquals(12, InversionCount.count(ints));
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.txt");
    }

}