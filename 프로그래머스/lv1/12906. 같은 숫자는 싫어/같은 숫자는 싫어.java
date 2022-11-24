import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        answer.add(arr[0]);

        for(int i = 1; i < arr.length; i++){
            if(answer.get(idx) == arr[i]) continue;
            answer.add(arr[i]);
            idx++;
        }
        
        int[] returnAns = new int[answer.size()];
        
        for(int i = 0; i < returnAns.length; i++){
            returnAns[i] = answer.get(i);
        }
        

        return returnAns;
    }

}