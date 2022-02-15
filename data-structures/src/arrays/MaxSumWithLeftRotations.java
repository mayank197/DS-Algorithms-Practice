package arrays;

public class MaxSumWithLeftRotations {

    private static int maxSumRotations(int[] arr) {
        int len = arr.length;
        int arrSum = 0, currComputedValue = 0;
        for(int i=0;i<len;i++) {
            arrSum += arr[i];
            currComputedValue += (i*arr[i]);
        }
        int maxSum = currComputedValue;
        for(int j=1;j<len;j++){
            currComputedValue = currComputedValue - arrSum + (len * arr[j-1]);
            maxSum = Math.max(maxSum, currComputedValue);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 2};
        int maxSumWithRotations = maxSumRotations(arr);
        System.out.printf("Maximum Sum with Left Rotations Allowed : %d", maxSumWithRotations);
    }

}
