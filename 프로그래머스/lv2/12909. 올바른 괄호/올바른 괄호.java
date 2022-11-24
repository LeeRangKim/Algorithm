class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if(count == 0 && now == ')') return answer;
            if(now == '(') count++;
            else count--;
        }

        if(count != 0) return answer;
        
        answer = true;
        return answer;
    }
}