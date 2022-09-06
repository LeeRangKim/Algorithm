import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        boolean arr[] = new boolean[M+1];
        arr[0] = true;
        arr[1] = true;

        for(int i=2; i*i<M+1; i++){
            for(int j=2; i*j<M+1; j++){
                arr[i*j] = true;
            }

        }

        for(int i=N; i<M+1; i++){
            if(!arr[i]){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
