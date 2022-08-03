import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N][N];

        for(int i = 0; i < N; i++){
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        
        for(int i =0; i < N; i++){
            boolean[] visited = new boolean[N];
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);

            while(!deque.isEmpty()){
                int now = deque.poll();
                for(int j =0; j < N ; j ++){
                    if(Objects.equals(grid[now][j], 1) && visited[j] == false){
                        visited[j] = true;
                        grid[i][j] = 1;
                        deque.add(j);
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j=0; j < N; j++){
                System.out.printf(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}
