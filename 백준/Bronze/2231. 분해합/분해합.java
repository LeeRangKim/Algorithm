import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for(int i = N; 0 <= i; i--){
            int num = N - i;
            int sum = 0;
            sum += num;

            String[] nums = Integer.toString(num).split("");
            for(int j = 0; j < nums.length; j ++){
                sum += Integer.parseInt(nums[j]);
            }

            if(sum == N){
                answer = num;
                break;
            }

        }
        System.out.println(answer);
    }
}
