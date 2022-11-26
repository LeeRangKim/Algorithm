import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i = 0; i < answers.length; i ++){
            int answer = answers[i];
            
            // 1번 로직
            if(answer % 5 == (i + 1) % 5) one++;
            
            
            // 2번 로직
            if(i % 2 == 0) {
                if(answer == 2) two++;
            } else {
                if(answer == 1 && i % 8 == 1
                  || answer == 3 && i % 8 == 3
                  || answer == 4 && i % 8 == 5
                  || answer == 5 && i % 8 == 7
                  ) two ++;
            }
            
            // 3번 로직
            if(answer == 1 && 2 <= i % 10 && i % 10 < 4
              || answer == 2 && 4 <= i % 10 && i % 10 < 6
              || answer == 3 && 0 <= i % 10 && i % 10< 2
              || answer == 4 && 6 <= i % 10 && i % 10 < 8
              || answer == 5 && 8 <= i % 10 && i % 10 < 10
              ) three ++;
        }
        
        int maxNum = Math.max(one, Math.max(two, three));
        List<Integer> temp = new ArrayList<>();

        if(maxNum == one) temp.add(1);
        if(maxNum == two) temp.add(2);
        if(maxNum == three) temp.add(3);
        
        int[] answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}