import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() - 1;

        if (N == 0) System.out.println(1);
        else {
            int answer = 1;

            for (int i = 1; i < 1000000000; i++) {
                N = N - (i * 6);
                answer = i + 1;
                if (N <= 0) break;
            }

            System.out.println(answer);
        }
    }
}