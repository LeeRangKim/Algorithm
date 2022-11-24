import java.util.*;

class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        int[] visited = new int[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == 1) continue;

            answer++;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = 1;

            while (queue.size() != 0) {
                int now = queue.poll();

                for (int j = 0; j < computers.length; j++) {
                    if (visited[j] == 1 || computers[now][j] != 1) continue;
                    queue.add(j);
                    visited[j] = 1;
                }
            }
        }

        return answer;
    }

}