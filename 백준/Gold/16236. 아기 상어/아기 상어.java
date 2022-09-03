import java.util.*;
import java.io.*;

public class Main {

    static int[] posI = {1,0,-1,0};
    static int[] posJ = {0,-1,0,1};

    static int[][] grid;

    static class checkInput {
        int nowSize;
        int[] start;
        int N;

        checkInput(int nowSize, int[] start, int N){
            this.nowSize = nowSize;
            this.start = start;
            this.N = N;
        }
    }

    static class checkOutput {
        int count;
        int[] finish;

        checkOutput(int count, int[] finish){
            this.count = count;
            this.finish = finish;
        }
    }

    private static checkOutput check(checkInput checkInput) {
        int[][] visited = new int[checkInput.N][checkInput.N];
        visited[checkInput.start[0]][checkInput.start[1]] = 1;

        int count = 1000 * 1000;
        int finishI = checkInput.N;
        int finishj = checkInput.N;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, checkInput.start[0], checkInput.start[1]});

        while(queue.size() > 0){
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextI = now[1] + posI[i];
                int nextJ = now[2] + posJ[i];

                if(nextI < 0 || checkInput.N <= nextI
                        || nextJ < 0 || checkInput.N <= nextJ
                        || visited[nextI][nextJ] == 1
                ){
                    continue;
                }

                if(grid[nextI][nextJ] == 0 || grid[nextI][nextJ] == checkInput.nowSize){
                    queue.add(new int[]{now[0]+1, nextI, nextJ});
                    visited[nextI][nextJ] = 1;
                } else if (grid[nextI][nextJ] < checkInput.nowSize) {
                    visited[nextI][nextJ] = 1;
                    if (now[0] + 1 < count){
                        count = now[0] + 1;
                        finishI = nextI;
                        finishj = nextJ;
                    } else if (now[0] + 1 == count) {
                        if(nextI < finishI){
                            finishI = nextI;
                            finishj = nextJ;
                        }
                    } else if (now[0] + 1 == count && finishI == nextI) {
                        if(nextJ < finishj){
                            finishj = nextJ;
                        }
                    }
                }
            }
        }
        if(count != 1000*1000){
            grid[finishI][finishj] = 0;
        }
        return new checkOutput(count, new int[]{finishI, finishj});
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        int[] start = new int[2];

        for(int i = 0; i < N; i ++){
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < N; j++){
                if(Integer.parseInt(temp[j]) != 9){
                    grid[i][j] = Integer.parseInt(temp[j]);
                } else {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int eat = 0;
        int nowSize = 2;
        int count = 0;
        checkOutput output = check(new checkInput(nowSize, start, N));

        while(output.count != 1000 * 1000){
            count += output.count;
            eat += 1;
            if(eat == nowSize){
                nowSize += 1;
                eat = 0;
            }
            output = check(new checkInput(nowSize, output.finish, N));
        }

        System.out.println(count);

    }


}
