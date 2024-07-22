import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> nums = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> setOfNums = nums.stream()
                .distinct()
                .collect(Collectors.toList());

        int answer = 0;

        if (setOfNums.size() == 1) {
            answer = N;
        } else {
            for (int i = 0; i < setOfNums.size() - 1; i++) {
                for (int j = i + 1; j < setOfNums.size(); j++) {
                    int firstNum = setOfNums.get(i);
                    int secondNum = setOfNums.get(j);

                    int consecutiveCount = 0;

                    for (int idx = 0; idx < N; idx++) {
                        if (nums.get(idx) == firstNum || nums.get(idx) == secondNum) {
                            consecutiveCount++;
                        } else {
                            if (answer < consecutiveCount) {
                                answer = consecutiveCount;
                            }
                            consecutiveCount = 0;
                        }
                    }

                    if (answer < consecutiveCount) {
                        answer = consecutiveCount;
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}