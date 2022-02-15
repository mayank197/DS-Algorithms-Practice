package arrays;

public class SortedRotatedPairSum {

    private static boolean checkIfSumPairExists(int[] arr, int sum) {
        boolean pairExists = false;
        // Find Pivot
        int i, n = arr.length;
        for(i=0;i<n-1;i++) {
           if(arr[i] > arr[i+1])
               break;
        }
        int smallIndex = (i+1)%n;
        int largeIndex = i;

        while(smallIndex != largeIndex) {
            if(arr[smallIndex] + arr[largeIndex] == sum){
                pairExists = true;
                break;
            } else if(arr[smallIndex] + arr[largeIndex] > sum){
                largeIndex = (n + largeIndex - 1)%n;
            } else {
                smallIndex = (smallIndex + 1)%n;
            }
        }
        return pairExists;
    }

    public static void main(String[] args) {

        // Sorted and Rotated Array
        int[] arr = {11, 15, 26, 38, 9, 10};
        int sum = 35;

        boolean pairExists = checkIfSumPairExists(arr, sum);
        System.out.printf("Pair with sum %d %s in the array", sum, pairExists ? "exists" : "doesn't exist");
    }

}
