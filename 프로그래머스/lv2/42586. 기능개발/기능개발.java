import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] dates = new int[progresses.length];
               
        
        for(int i = 0; i < progresses.length; i ++){
            if((100 - progresses[i]) % speeds[i] != 0 ){
                dates[i] = (100 - progresses[i]) / speeds[i] + 1;
            } else {
                dates[i] = (100 - progresses[i]) / speeds[i];
            }
            
        }
        
        List<Integer> listAnswer = new ArrayList<>();
        
        int big = dates[0];        
        listAnswer.add(1);
        int idx = 0;
        
        for(int i = 1; i < dates.length; i ++){
            if(big >= dates[i]) listAnswer.set(idx, listAnswer.get(idx) + 1);
            else{
                big = dates[i];
                listAnswer.add(1);
                idx++;
            }
        }
        
        
        int[] answer = new int[listAnswer.size()];

        for(int i = 0; i < listAnswer.size(); i ++){
            answer[i] = listAnswer.get(i);
        }
        return answer;
    }
}