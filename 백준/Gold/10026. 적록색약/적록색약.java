import java.util.*;
import java.io.*;


public class Main {

    static int[] pos_i = {1, -1, 0, 0};
    static int[] pos_j = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] grid = new String[N][N];
        String[][] blindGrid = new String[N][N];

        for(int i = 0 ; i < N; i++){
            String[] temp = br.readLine().split("");
            for(int j =0; j < N; j++){
                grid[i][j] = temp[j];
                if(Objects.equals(temp[j], "G")){
                    blindGrid[i][j] = "R";
                } else {
                    blindGrid[i][j] = temp[j];
                }
            }
        }

        //각각 bfs로 구하기
        int answer = bfs(N, grid);
        int blindAnswer = bfs(N, blindGrid);

        System.out.println(answer+" "+blindAnswer);
    }

    private static int bfs(int n, String[][] grid) {
        int count = 0;
        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0){
                    count += 1;
                    visited[i][j] = 1;
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.add(new int[]{i, j});
                    String nowColor = grid[i][j];

                    while (deque.size() > 0){
                        int[] now = deque.poll();

                        for(int k = 0; k < 4; k++){
                            int next_i = now[0] + pos_i[k];
                            int next_j = now[1] + pos_j[k];

                            if(0 <= next_i && next_i < n && 0 <= next_j && next_j < n && visited[next_i][next_j] == 0 && Objects.equals(nowColor, grid[next_i][next_j])){
                                visited[next_i][next_j] = 1;
                                int[] next = {next_i, next_j};
                                deque.add(next);
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
