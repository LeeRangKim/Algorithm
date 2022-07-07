import java.util.*;

public class Hash4_fail {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String[] genres, int[] plays) {
                Map<String, Integer> total = new HashMap<>();
                Map<Integer, String> orderByPlay = new HashMap<>();
                for (int i = 0; i < genres.length; i++) {
                    String genre = genres[i];
                    int play = plays[i];
                    total.put(genre, total.getOrDefault(genre, 0) + play);
                    orderByPlay.put(play, genre);
                }
                List<Map.Entry<String, Integer>> totalList = new LinkedList<>(total.entrySet());
                totalList.sort(Map.Entry.comparingByValue());
                Collections.reverse(totalList);

                List<Map.Entry<Integer, String>> playList = new LinkedList<>(orderByPlay.entrySet());
                playList.sort(Map.Entry.comparingByKey());
                Collections.reverse(playList);

                int now = 0;
                int answer_idx = 0;
                int total_sum = 0;
                int[] used = new int[playList.size()];
                int[] answer = new int[playList.size() -  playList.size() % 2];

                while (answer_idx < playList.size() -  playList.size() % 2) {
                    String most_genre = totalList.get(now).getKey();
                    int most_genre_total = totalList.get(now).getValue();
                    int temp = -1;

                    for (int i = 0; i < playList.size(); i++) {
                        if (most_genre.equals(playList.get(i).getValue()) && used[i] == 0) {
                            temp = playList.get(i).getKey();
                            used[i] = 1;
                            total_sum += temp;
                            for (int j=0;  j < playList.size(); j++){
                                if(plays[j] == temp){
                                    answer[answer_idx] = j;
                                }
                            }
//                            answer[answer_idx] = Arrays.asList(plays).indexOf(temp);
                            answer_idx += 1;
                            break;
                        }
                    }
                    if (most_genre_total - total_sum == 0) {
                        now += 1;
                    }
                }
                System.out.println(Arrays.toString(answer));
                return answer;
            }

        }
        String[] arr1 = {"classic", "pop", "classic", "classic", "pop", "classic"};
        int[] arr2 = {500, 600, 150, 800, 2500, 500};
        Solution sol = new Solution();
        System.out.println(sol.solution(arr1, arr2));
    }
}
