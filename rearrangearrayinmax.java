class Solution {
    public static void rearrange(int arr[]) {
        int n = arr.length;
        int[] temp = new int[n];

        int left = 0;
        int right = n - 1;
        int index = 0;

        while (left <= right) {
            if (left != right) {
                temp[index++] = arr[right--];
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[left++];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}