package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {

    private static void pairWithGivenSumApproach1(int[] arr, int sum) {
        // Sort First
        Arrays.sort(arr);
        // Start from leftmost and rightmost indices simultaneously
        int low = 0, end = arr.length - 1;
        while(low != end) {
            if (arr[low] + arr[end] == sum) {
                System.out.printf("Pair with sum %d is found : (%d, %d)\n", sum, arr[low], arr[end]);
                break;
            } else if (arr[low] + arr[end] > sum) {
                end --;
            } else {
                low ++;
            }
        }
    }

    private static void pairWithGivenSumApproach2(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            int diff = sum - j;
            if (set.contains(diff)) {
                System.out.printf("Pair with sum %d is found : (%d, %d)\n", sum, diff, j);
            }
            set.add(j);
        }
    }

    public static void main(String[] args) {

        int[] arr = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        pairWithGivenSumApproach1(arr, sum);
        pairWithGivenSumApproach2(arr, sum);

    }
}
