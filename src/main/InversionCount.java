
/**
 * @author Jacob Ho
 */
public class InversionCount {

    public static int count(int[] arr) {
        return count(arr, 0, arr.length - 1);
    }

    public static int count(int[] arr, int left, int right) {
        int count = 0;
        if (right - left == 0)
            return 0;
        if (right - left == 1) {
            if (arr[left] > arr[right]) {
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                count++;
            }
        } else {
            count = count + count(arr, left, left + (right - left) / 2);
            count = count + count(arr, left + (right - left) / 2, right);
            int[] temp = new int[right - left + 1];
            int mid = (right - left) / 2 + left;
            int k = 0;
            int l = 0;
            for (int i = left; i < right + 1; i++) {
                if (left + k == mid) {
                    temp[k + l] = arr[mid + l];
                    l++;
                } else if (arr[left + k] > arr[mid + l]) {
                    temp[k + l] = arr[mid + l];
                    l++;
                    count++;
                } else {
                    temp[k + l] = arr[left + k];
                    k++;
                }
            }
            for (int i = 0; i < temp.length; i++) {
                arr[left + i] = temp[i];
            }
        }

        return count;
    }
}
