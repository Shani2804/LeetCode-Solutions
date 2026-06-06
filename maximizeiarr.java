class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;

        int arrSum = 0;
        int currVal = 0;

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currVal += i * arr[i];
        }

        int result = currVal;

        for (int i = 1; i < n; i++) {
            currVal = currVal + arrSum - n * arr[n - i];
            result = Math.max(result, currVal);
        }

        return result;
    }
}