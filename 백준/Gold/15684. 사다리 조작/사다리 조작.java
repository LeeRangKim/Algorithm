import java.io.*;
import java.util.*;
class Main{

    static int answer = -1;
    static int N, M, H;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] t = br.readLine().split(" ");
        N = Integer.parseInt(t[0]);
        M = Integer.parseInt(t[1]);
        H = Integer.parseInt(t[2]);

        grid = new int[H+1][N];

        for(int i = 0; i < M; i++){
            String [] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);
            int b = Integer.parseInt(tt[1]);

            grid[a][b] = 1;
        }

        checkLadder(grid, 0);
        makeLadder(0, 1, 1);


        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static void makeLadder(int nowLadderCnt, int changeRow, int changeCol) {
        if(answer != -1 && nowLadderCnt >= answer) return;
        if(nowLadderCnt > 2) return;

        for(int i = changeRow; i < H+1; i++){
            changeCol = 1;
            for(int j = changeCol; j < N; j++){

                if(grid[i][j-1] != 1 && grid[i][j] != 1){
                    if(j != N-1 && grid[i][j+1] == 1) continue;

                    grid[i][j] = 1;
                    if(j == N-1){
                        makeLadder(nowLadderCnt+1, i + 1, 1);
                    } else {
                        makeLadder(nowLadderCnt+1, i, j + 1);
                    }
                    checkLadder(grid, nowLadderCnt + 1);
                    grid[i][j] = 0;
                }
            }
        }

    }

    private static void checkLadder(int[][] grid, int nowLadderCnt) {
        for (int startJ = 1; startJ < N; startJ++) {
            int i = 1;
            int checkJ = startJ;
            while (i < H + 1) {
                if(checkJ == 1){
                    if (grid[i][checkJ] == 1) checkJ++;
                } else if (checkJ == N) {
                    if (grid[i][checkJ - 1] == 1) checkJ--;
                } else {
                    if (grid[i][checkJ] == 1) checkJ++;
                    else if (grid[i][checkJ - 1] == 1) checkJ--;
                }
                i++;
            }
            if (checkJ != startJ) return;
        }
        answer = nowLadderCnt;
    }
}