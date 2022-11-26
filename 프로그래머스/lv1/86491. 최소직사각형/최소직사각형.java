import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int big = 0;
        int small = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int temp1 = Integer.max(sizes[i][0], sizes[i][1]);
            int temp2 = Integer.min(sizes[i][0], sizes[i][1]);

            if(temp1 > big) big = temp1;
            if(temp2 > small) small = temp2;
        }
        
        return big*small;
    }
}