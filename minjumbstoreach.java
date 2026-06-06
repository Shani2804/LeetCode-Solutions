import java.util.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Set<Integer> forbiddenSet = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSet.add(f);
        }

        int limit = 6000;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // position, steps, lastBackward

        boolean[][] visited = new boolean[limit + 1][2];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int pos = curr[0];
            int steps = curr[1];
            int lastBackward = curr[2];

            if (pos == x) {
                return steps;
            }

            // Forward jump
            int forward = pos + a;
            if (forward <= limit &&
                !forbiddenSet.contains(forward) &&
                !visited[forward][0]) {

                visited[forward][0] = true;
                queue.offer(new int[]{forward, steps + 1, 0});
            }

            // Backward jump
            int backward = pos - b;
            if (lastBackward == 0 &&
                backward >= 0 &&
                !forbiddenSet.contains(backward) &&
                !visited[backward][1]) {

                visited[backward][1] = true;
                queue.offer(new int[]{backward, steps + 1, 1});
            }
        }

        return -1;
    }
}