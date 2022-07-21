import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int answer = 50000;

        for(int i  = 0 ; i <= N / 5; i++ ){
            int tempN = N;
            int tempans = 0;
            tempans += i;
            tempN = tempN - 5*i;
            tempans += tempN / 3;
            if(tempN % 3 == 0 && tempans < answer){
                answer = tempans;
            }
        }

        if(answer == 50000){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}