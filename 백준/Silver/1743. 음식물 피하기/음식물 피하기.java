import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[][] edges;
    static int[][] check;

    static int[] posI = {0, 0, -1, 1};
    static int[] posJ = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int K = sc.nextInt();

        edges = new int[N+1][M+1];

        for(int i = 0; i < K; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            edges[r][c] = 1;
        }

        check = new int[N+1][M+1];
        int maxSize = -1;

        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < M + 1; j++){
                if(edges[i][j] == 0 || check[i][j] == 1) continue;

                int nowSize = bfs(i, j);
                if(nowSize > maxSize) maxSize = nowSize;
            }
        }

        System.out.println(maxSize);
    }

    private static int bfs(int i, int j) {
        int count = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        check[i][j] = 1;
        count++;

        while (deque.size() > 0){
            int[] now = deque.pollFirst();

            for(int k = 0; k < 4; k++){
                int nextI = now[0] + posI[k];
                int nextJ = now[1] + posJ[k];

                if(nextI < 1 || nextI > N || nextJ < 1 || nextJ > M) continue;
                if(edges[nextI][nextJ] == 0 || check[nextI][nextJ] == 1) continue;

                check[nextI][nextJ] = 1;
                count++;
                deque.add(new int[]{nextI, nextJ});
            }

        }


        return count;
    }
}
