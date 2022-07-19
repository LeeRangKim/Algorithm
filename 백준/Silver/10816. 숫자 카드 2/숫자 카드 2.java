import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] cardScores = new int[N];

        for(int i = 0; i < N; i++){
            cardScores[i] = sc.nextInt();
        }

        Arrays.sort(cardScores);

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int Key = sc.nextInt();
            sb.append(upperbound(cardScores, Key) - lowerbound(cardScores, Key)).append(" ");
        }

        System.out.println(sb);

    }

    private static int lowerbound(int[] arr,  int Key) {
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left + right)/2;

            if(Key <= arr[mid]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int upperbound(int[] arr, int Key) {
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left + right)/2;

            if(Key < arr[mid]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
