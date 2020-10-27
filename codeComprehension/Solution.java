import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min += arr[i];
        }
        int max = min - arr[0] + arr[arr.length - 1];
        System.out.println(min + "  " + max);

    }

    static boolean isGreaterThan(int[] arr, int var) {
        for (int i : arr) {
            if (i > var) {
                return true;
            }
        }
        return false;
    }

    static boolean isLessThan(int[] arr, int var) {
        for (int i : arr) {
            if (i < var) {
                return true;
            }
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        boolean recapture = false;
        do {
            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < 5; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            recapture = isLessThan(arr, 1) || isGreaterThan(arr, 1000);

            if (recapture) {
                System.out.println("One or more values are less than 1 or greater than 1000");
            }
        } while (recapture);

        miniMaxSum(arr);

        scanner.close();
    }
}