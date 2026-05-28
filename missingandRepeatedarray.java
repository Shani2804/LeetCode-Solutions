class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }