import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[][] grid = new String[N][M];

        for(int i = 0; i < N ; i++){
            String[] temp = br.readLine().split("");

            for(int j = 0; j < M; j ++){
                grid[i][j] = temp[j];
            }
        }

        int min = 8*8;

        for(int i = 0; i < N - 7; i ++){
            for (int j = 0; j < M -7; j ++){
                int count = 0;
                for(int k = i; k < i + 8; k ++){
                    for(int l = j; l < j +8; l++){
                        if(k%2 == 0){
                            if(l%2 == 0){
                                if(grid[k][l].equals("W")){
                                    count++;
                                }
                            }else{
                                if(grid[k][l].equals("B")){
                                    count++;
                                }
                            }
                        }else{
                            if(l%2 == 0){
                                if(grid[k][l].equals("B")){
                                    count++;
                                }
                            }else{
                                if(grid[k][l].equals("W")){
                                    count++;
                                }
                            }
                        }

                    }
                }
                if(count > 32){
                    count = 64 - count;
                }
                if(count < min){
                    min = count;
                }
            }
        }

        System.out.println(min);

    }
}
