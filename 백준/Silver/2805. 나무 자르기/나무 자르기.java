import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] trees = new int[N];
        int left = 0;
        int right = 0;

        for(int i =0; i < N ; i++){
            int temp = sc.nextInt();

            trees[i] = temp;
            if(right < temp){
                right = temp;
            }
        }

        right++;

        int answer = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            long temp = 0;

            for(int i =0; i < N; i++){
                if (mid == 0){
                    temp += trees[i];
                    continue;
                }
                if (trees[i] > mid) {
                    temp += (trees[i] - mid);
                }
            }

            if(temp < K){
                right = mid - 1;
            }else {
                answer = mid;
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
