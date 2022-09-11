import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[42];
        for(int i = 0 ; i< 10; i ++){
            int A = sc.nextInt();
            count[A%42] += 1;
        }
        int answer = 0;
        for (int i = 0; i < 42; i ++){
            if(count[i] != 0){
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
