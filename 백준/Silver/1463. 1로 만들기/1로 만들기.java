import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] visited = new int[N+1];


        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        while(queue.size() > 0){
            int now = queue.poll();
            if (now == 1){
                break;
            }

            for(int i = 0; i < 3; i++){
                if(i == 0){
                    if (now % 3 == 0 && visited[now/3] == 0) {
                        visited[now / 3] = visited[now] + 1;
                        queue.add(now / 3);
                    }
                } else if (i == 1){
                    if (now % 2 == 0 && visited[now/2] == 0) {
                        visited[now/2] = visited[now] + 1;
                        queue.add(now/2);
                    }
                } else {
                    if(visited[now-1] == 0) {
                        visited[now - 1] = visited[now] + 1;
                        queue.add(now - 1);
                    }
                }

            }
        }
        System.out.println(visited[1]);
    }
}
