package arrays;

public class RotationCountRotatedSorted {

    private static int getRotationCount(int[] arr, int low, int high) {
        if (low == high)
            return low;
        int mid = low + (high-low)/2;
        // Compare with right
        if (arr[mid] > arr[mid+1])
            return (mid+1);
        // Compare with left
        if (arr[mid] < arr[mid-1])
            return mid;
        // If mid is at a sorted position, consider left and right subarrays
        // If right end is sorted, check left one
        if (arr[mid] < arr[high])
            return getRotationCount(arr, low, mid-1);
        // Else, Check left
        return getRotationCount(arr, mid+1, high);
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};
        // Rotation Count should be 2

        int rotationCount = getRotationCount(arr, 0, arr.length - 1);
        System.out.printf("Array is rotated by %d", rotationCount);

    }

}
