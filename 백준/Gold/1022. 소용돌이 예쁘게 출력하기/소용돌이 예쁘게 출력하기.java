import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int r1 = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int r2 = Integer.parseInt(input[2]);
        int c2 = Integer.parseInt(input[3]);


        int[][] answer = new int[r2-r1+1][c2-c1+1];

        int max = -1;

        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                int level = Math.max(Math.abs(i), Math.abs(j));
                int now = 0;
                // 아래쪽
                if(i == level){
                    int temp = (int)Math.pow((level * 2 + 1), 2);
                    now = temp - (level - j);
                // 맨위
                } else if (-i == level) {
                    int temp = (int)Math.pow((2 * level - 1), 2) + 2*level;
                    now = temp + (level - j);
                // 오른쪽
                } else if (j == level) {
                    int temp = (int)Math.pow((level * 2 - 1), 2);
                    now = temp + (level - i);
                // 왼쪽
                } else {
                    int temp = (int)Math.pow((level * 2), 2) + 1;
                    now = temp + (i + level);
                }
                answer[i-r1][j-c1] = now;
                int nowSpace = Integer.toString(now).length();
                if(nowSpace >= max) max = nowSpace;
            }
        }

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                int space = max - Integer.toString(answer[i][j]).length();
                String printNow = "";
                for(int k = 0; k < space; k ++){
                    printNow += " ";
                }

                System.out.printf(printNow + Integer.toString(answer[i][j])+ " ");
            }
            System.out.println();
        }
    }
}