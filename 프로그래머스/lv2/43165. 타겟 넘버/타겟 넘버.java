import java.util.*;

class Solution {

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        Deque<List<Integer>> deque = new ArrayDeque<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        deque.add(start);

        while (deque.size() != 0) {
            List<Integer> now = deque.poll();
            int idx = now.get(0);
            int sum = now.get(1);

            if (idx != numbers.length) {
                for (int i = 0; i < 2; i++) {
                    List<Integer> next = new ArrayList<>();
                    if (i == 0) {
                        next.add(idx + 1);
                        next.add(sum + numbers[idx]);
                        deque.add(next);
                        continue;
                    }
                    next.add(idx + 1);
                    next.add(sum - numbers[idx]);
                    deque.add(next);
                }
            } else if (sum == target) {
                answer++;
            }
        }

        return answer;
    }
}