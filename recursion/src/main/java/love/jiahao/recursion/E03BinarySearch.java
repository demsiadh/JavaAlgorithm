package love.jiahao.recursion;

/**
 * 递归二分查找
 */
public class E03BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(handler(arr, 5, 0, arr.length - 1));
    }

    private static int handler(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int m = (left + right) >>> 1;
        if (target > arr[m]) {
            return handler(arr, target, m + 1, right);
        } else if (target < arr[m]) {
            return handler(arr, target, left, right - 1);
        }else return m;
    }
}
