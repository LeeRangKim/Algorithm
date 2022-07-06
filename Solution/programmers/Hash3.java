
import java.util.HashMap;
import java.util.Map;

public class Hash3 {
    public static void main(String[] args) {
        class Solution {
            public int solution(String[][] clothes) {
                HashMap<String, Integer> classify = new HashMap<>();

                for(int i =0; i<clothes.length; i++){
                    String type = clothes[i][1];
                    classify.put(type, classify.getOrDefault(type, 0) + 1);
                }

                int answer = 1;
                for (Map.Entry<String, Integer> entry : classify.entrySet()) {
                    Integer num = entry.getValue();
                    answer *= num + 1;
                }
                return answer - 1;
            }

        }

        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution sol = new Solution();
        System.out.println(sol.solution(arr));
    }
}
