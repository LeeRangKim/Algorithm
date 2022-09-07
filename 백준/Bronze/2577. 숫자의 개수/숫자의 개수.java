import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] count = new int[10];
        String num = Integer.toString(A*B*C);
        for(int i = 0; i < num.length(); i ++){
            char c1 = num.charAt(i);
            int i1 = c1 - '0';
            count[i1] += 1;
        }

        for(int i = 0; i < count.length; i++){
            System.out.println(count[i]);
        }



    }

}
