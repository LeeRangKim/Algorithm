import java.io.*;
import java.util.*;

public class Main {

    static int default_value = 1000*1000 + 1;
    static int minDis = default_value;
    static int N;
    static int M;

    static int[][] grid;

    static int[] pos_i = {0, 0, 1, -1};
    static int[] pos_j = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        grid = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bfs(grid);

        if(minDis == default_value) minDis = -1;

        System.out.println(minDis);
    }

    public static void bfs(int[][] grid){
        int[][][] visited = new int[N][M][2];

        Deque<int[]> queue = new ArrayDeque<>();
        int[] start = {0, 0, 0};
        visited[0][0][0] = 1;
        queue.add(start);

        while (queue.size() > 0){
            int[] now = queue.pollFirst();
            int now_i = now[0];
            int now_j = now[1];
            int isBroken = now[2];

            for(int i = 0; i < 4; i++){
                int next_i = now_i + pos_i[i];
                int next_j = now_j + pos_j[i];

                if(next_i < 0 || N <= next_i ||
                        next_j < 0 || M <= next_j) continue;

                // 벽이 아닐떄
                if( grid[next_i][next_j] == 0) {
                    if(visited[next_i][next_j][isBroken] == 0 ||
                            visited[next_i][next_j][isBroken] > visited[now_i][now_j][isBroken] + 1){
                        visited[next_i][next_j][isBroken] = visited[now_i][now_j][isBroken] + 1;
                        queue.add(new int[]{next_i, next_j, isBroken});
                    }
                } else {
                    // 벽일 떄
                    if(isBroken == 0){
                        visited[next_i][next_j][isBroken+1] = visited[now_i][now_j][isBroken] + 1;
                        queue.add(new int[]{next_i, next_j, isBroken+1});
                    }
                }
            }
        }

        if(visited[N-1][M-1][0] != 0 && visited[N-1][M-1][0] < minDis) minDis = visited[N-1][M-1][0];
        if(visited[N-1][M-1][1] != 0 && visited[N-1][M-1][1] < minDis) minDis = visited[N-1][M-1][1];
    }
}
