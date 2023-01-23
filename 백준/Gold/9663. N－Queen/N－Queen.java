import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;
        arr = new int[N];

        nQueen(0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    private static void nQueen(int depth) {
        if(depth == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++){
            arr[depth] = i;
            if(isAble(depth)){
                nQueen(depth + 1);
            }
        }
    }

    private static boolean isAble(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
