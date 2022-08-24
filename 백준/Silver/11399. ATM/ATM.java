import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        int[] people = new int[N];

        for(int i=0; i<N; i++){
            people[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(people);

        int sum = 0;
        for(int i=N; i>0; i--){
            sum += people[N-i] * i;
        }
        System.out.println(sum);
    }
}
