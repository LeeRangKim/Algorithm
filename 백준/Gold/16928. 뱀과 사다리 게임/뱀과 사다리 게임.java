import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMinput = br.readLine().split(" ");
        int N = Integer.parseInt(NMinput[0]);
        int M = Integer.parseInt(NMinput[1]);

        Map<Integer, Integer> ladders = new HashMap<>();
//        Map<Integer, Integer> snakes = new HashMap<>();

        for(int i =0; i < M + N ; i++){
            String[] XYinput = br.readLine().split(" ");
            ladders.put(Integer.parseInt(XYinput[0]), Integer.parseInt(XYinput[1]));
        }

//        for(int i =0; i < N ; i++){
//            String[] XYinput = br.readLine().split(" ");
//            snakes.put(Integer.parseInt(XYinput[0]), Integer.parseInt(XYinput[1]));
//        }

        int[] visited = new int[101];
        int[] count = new int[101];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        visited[1] = 1;
        int answer = 0;
        int flag = 0;
        while(deque.size() > 0){
            int now = deque.poll();
            for(int i = 1; i < 7; i++){
                int next = ladders.getOrDefault(now + i, now + i);
                if(visited[next] != 1 && next != 100){
                    visited[next] = 1;
                    count[next] = count[now] + 1;
                    deque.addLast(next);
                } else if (next == 100) {
                    answer = count[now] + 1;
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
        }

        System.out.println(answer);




    }
}
