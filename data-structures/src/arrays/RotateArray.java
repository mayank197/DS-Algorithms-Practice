package arrays;

public class RotateArray {

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    static void rotateArr(int[] arr, int d, int n) {
        // Corner Case : d > n
        d = d % n;
        int gcd = gcd(n, d);
        for(int i=0; i<gcd; i++){
            int temp = arr[i];
            int trackIndex = i;
            while(true){
                int newIndex = trackIndex + d;
                if (newIndex >= n)
                    newIndex -= n;
                if (newIndex == i)
                    break;
                arr[trackIndex] = arr[newIndex];
                trackIndex = newIndex;
            }
            arr[trackIndex] = temp;
        }
    }

    static void printArr(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

       int[] arr = {1,2,3,4,5,6};
       int d = 2;

       printArr(arr);

       rotateArr(arr, d, arr.length);

       printArr(arr);
    }
}