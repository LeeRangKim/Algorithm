import java.util.*;
import java.io.*;

public class Main {

    static int[] root;

    public static void union(int i, int j){
        i = find(i);
        j = find(j);

        if(i != j) root[i] = j;
    }

    public static int find(int i){
        if(i == root[i]){
            return i;
        }
        // 경로 압축
        return root[i] = find(root[i]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        root = new int[G+1];

        for(int i = 1; i < G+1; i++){
            root[i] = i;
        }

        int answer = 0;

        for(int i = 0; i < P; i++){
            int g = Integer.parseInt(br.readLine());

            int empty = find(g);
            if(empty == 0){
                break;
            }

            answer++;

            union(empty, empty - 1);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}
