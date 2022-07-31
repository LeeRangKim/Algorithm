import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Main {

    static boolean[][] edges;
    static boolean[] visited;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        edges = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];


        for(int i=0; i<M; i++){
            String[] temp2 = br.readLine().split(" ");
            int u = Integer.parseInt(temp2[0]);
            int v = Integer.parseInt(temp2[1]);

            edges[u][v] = true;
            edges[v][u] = true;
        }

        int answer = 0;

        for(int i = 1; i < N+1; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);


    }

    private static void bfs(int i) {
        visited[i] = true;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(i);

        while (!deque.isEmpty()){
            int now  = deque.poll();
            for(int j =1; j<N+1; j++){
                if (Objects.equals(edges[now][j], true) && Objects.equals(visited[j], false)){
                    visited[j] = true;
                    deque.add(j);
                }
            }
        }
        
    }
}
