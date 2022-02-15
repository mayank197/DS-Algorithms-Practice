package arrays;

public class SearchRotatedSorted {

    private static int findPivot(int[] arr, int low, int high) {
        // To consider case of Sorted Array
        if (low > high)
            return -1;
        if (low == high)
            return low;
        int mid = low + (high-low)/2;
        // Initial Check to consider the case of Sorted Array
        if (mid < high && arr[mid] > arr[mid+1])
            return mid;
        // Same as above
        if (low < mid && arr[mid] < arr[mid-1])
            return mid-1;
        // If mid is in a sorted position, consider left and right sub-arrays
        // If right array is sorted, consider left
        if (arr[mid] <= arr[high])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid+1, high);
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;
        int mid = low + (high-low)/2;
        if (arr[mid] == key)
            return mid;
        if (arr[mid] > key)
            return binarySearch(arr, low, mid-1, key);
        return binarySearch(arr, mid+1, high, key);
    }

    private static int searchInRotatedSortedArray(int[] arr, int key) {
        int len = arr.length;
        int pivot = findPivot(arr, 0, len-1);
        // If pivot not found, means array is sorted
        if (pivot == -1)
            return binarySearch(arr, 0, len-1, key);
        if (arr[pivot] == key)
            return pivot;
        // A bit Tricky, since from arr[0] to pivot is already sorted, we have to use this check
        // to know in which subarray does the key lies
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, len-1, key);
    }

    public static void main(String[] args) {

        int[] arr = {30, 40, 50, 55, 10, 20};
        int key = 40;

        // Should return 3
        int index = searchInRotatedSortedArray(arr, key);
        System.out.printf("%d %s %d", key, index!=-1 ? "found at index" : "not found", index);

    }
}
