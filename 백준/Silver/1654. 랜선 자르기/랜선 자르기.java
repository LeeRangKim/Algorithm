import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        long N = sc.nextLong();

        long[] lanCables = new long[K];

        for(int i=0; i<K; i++){
            lanCables[i] = sc.nextInt();
        }

        Arrays.sort(lanCables);

        long right = lanCables[K-1] + 1;
        long left = 0;

        long answer = right;

        while (left < right){
            long mid = (left + right)/2;
            int temp = 0;

            for(int i=0; i<K; i++){
                temp += lanCables[i] / mid;
            }

            if (temp < N){
                right = mid;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
