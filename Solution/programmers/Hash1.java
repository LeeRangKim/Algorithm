import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hash1 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        class Solution {
            public String solution(String[] participant, String[] completion) {
                Arrays.sort(participant);
                Arrays.sort(completion);

                String answer = participant[participant.length-1];
                for(int i = 0; i < completion.length; i++){
                    if(!participant[i].equals(completion[i])){
                        answer = participant[i];
                        break;
                    }
                }
                return answer;
            }
        }

        Solution solution = new Solution();

        System.out.println(solution.solution(participant, completion));

    }
}
