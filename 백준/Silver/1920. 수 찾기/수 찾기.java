import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> nums = new HashMap<>();

        String[] A = br.readLine().split(" ");
        for(int i = 0; i < A.length; i++){
            nums.put(Integer.parseInt(A[i]), 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        for(int i = 0; i < B.length; i++){
            int temp = Integer.parseInt(B[i]);

            if(nums.containsKey(temp)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
