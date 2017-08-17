
/**
 * @author Jacob Ho
 */
public class InversionCount {

    public static long count(long[] arr) {
        long count = count(arr, 0, arr.length - 1);
        return count;
    }

    public static long count(long[] arr, int left, int right) {
        if (right - left == 0)
            return 0;
        if (right - left == 1) {
            if (arr[left] > arr[right]) {
                long t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                return 1;
            }
            return 0;
        } else {
            long count = 0;
            int mid = (right - left) / 2 + left;
            count = count + count(arr, left, mid);
            count = count + count(arr, mid, right);
            long[] temp = new long[right - left + 1];
            int k = 0;
            int l = 0;
            for (long i = left; i < right + 1; i++) {
                if (left + k == mid) {
                    temp[k + l] = arr[mid + l];
                    l++;
                } else if (arr[left + k] > arr[mid + l]) {
                    temp[k + l] = arr[mid + l];
                    l++;
                } else {
                    temp[k + l] = arr[left + k];
                    count = count + l;
                    k++;
                }
            }
            for (int i = 0; i < temp.length; i++) {
                arr[left + i] = temp[i];
            }
            return count;
        }
    }
}
