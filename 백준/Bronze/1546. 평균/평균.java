import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inputScore = new int[N];
        int maxScore = 0;
        for(int i =0; i < N ; i ++){
            int temp = sc.nextInt();
            if(maxScore < temp){ maxScore = temp; }
            inputScore[i] = temp;
        }
        double sum = 0;
        for(int i = 0; i < N; i ++){
            sum += ((double)inputScore[i]/maxScore)*100;
        }
        double avg = (double) sum/N;

        System.out.println(avg);
    }
}
