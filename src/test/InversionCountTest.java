import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Jacob Ho
 */
public class InversionCountTest {
    @Test
    public void count() {
        long[] ints = {1};
        assertEquals(0, InversionCount.count(ints));
        ints = new long[]{1, 2};
        assertEquals(0, InversionCount.count(ints));
        ints = new long[]{2, 1};
        assertEquals(1, InversionCount.count(ints));
        ints = new long[]{3, 1, 2};
        assertEquals(2, InversionCount.count(ints));
        ints = new long[]{1, 3, 5, 2, 4, 6};
        assertEquals(3, InversionCount.count(ints));
        ints = new long[]{1, 2, 3, 4, 5, 6};
        assertEquals(0, InversionCount.count(ints));
        ints = new long[]{2, 4, 1, 3, 5};
        assertEquals(3, InversionCount.count(ints));
        ints = new long[]{1, 0, 0, 0, 0, 0, 0};
        assertEquals(6, InversionCount.count(ints));
        ints = new long[]{0, 0, 0, 0, 0, 0, 0};
        assertEquals(0, InversionCount.count(ints));
        int n = 100;
        long[] ns = new long[n];
        for (int i = 0; i < n; i++) {
            ns[i] = n - i;
        }
        assertEquals(n * (n - 1) / 2, InversionCount.count(ns));
    }

    @Test
    public void sorting() throws Exception {
        int loop = 100;
        while (loop > 0) {
            loop--;
            long[] longs = getRandomArray(100);
            InversionCount.count(longs);
            for (int i = 0; i < longs.length; i++) {
                assertEquals(i + 1, longs[i]);
            }
        }
    }

    @Test
    public void bruteForce() {
        for (int k = 0; k < 100; k++) {
            long[] randomArray = getRandomArray(1000);
            long count = 0;
            for (int i = 0; i < randomArray.length; i++) {
                for (int j = i + 1; j < randomArray.length; j++) {
                    if (randomArray[i] > randomArray[j])
                        count++;
                }
            }
            assertEquals(count, InversionCount.count(randomArray));
        }
    }

    private long[] getRandomArray(int len) {
        Random random = new Random();
        long[] ints = new long[len];
        for (int i = 0; i < len; i++) {
            int position = random.nextInt(len - i);
            for (int j = 0; j < len; j++) {
                if (ints[j] == 0) {
                    if (position == 0) {
                        ints[j] = i + 1;
                        break;
                    }
                    position--;
                }
            }
        }
        return ints;
    }
}