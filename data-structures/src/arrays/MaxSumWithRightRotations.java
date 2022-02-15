package arrays;

public class MaxSumWithRightRotations {

    private static int maxSumRotations(int[] arr) {
        int len = arr.length;
        int arrSum = 0, currComputedValue = 0;
        for(int i=0;i<len;i++){
            arrSum += arr[i];
            currComputedValue += (i * arr[i]);
        }
        int maxSum = currComputedValue;
        for(int j=1;j<len;j++) {
            currComputedValue += (arrSum - len*arr[len-j]);
            maxSum = Math.max(maxSum, currComputedValue);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 10};
        // Max Sum should be 72
        int maxSumWithRotations = maxSumRotations(arr);
        System.out.printf("Maximum Sum with Right Rotations Allowed : %d", maxSumWithRotations);
    }

}
