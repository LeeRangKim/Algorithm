import java.lang.reflect.Array;
import java.util.Arrays;

public class Hash2 {
    public static void main(String[] args) {
        class Solution {
            public boolean solution(String[] phone_book) {

                boolean answer = true;

                Arrays.sort(phone_book);
                for(int i = 0; i < phone_book.length-1; i++){
                    if(!phone_book[i+1].startsWith(phone_book[i])){
                        continue;
                    }
                    answer = false;
                    break;
                }
                return answer;
            }
        }

        String[] phone_book = {"1195524421", "97674223", "119"};


        Solution sol = new Solution();
        System.out.println(sol.solution(phone_book));

    }
}
