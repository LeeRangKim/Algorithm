import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0 ; i < N; i++){
            int sum = 0;
            String[] test = sc.next().split("");
            int count = 0;
            for (int j = 0; j < test.length; j ++){
                String answer = test[j];
                if(Objects.equals(answer, "O")){
                    count += 1;
                    sum += count;
                } else {
                    count = 0;
                }
            }
            System.out.println(sum);
        }

    }
}
