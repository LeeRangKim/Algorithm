import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");

        int answer = 1;
        int up = 1;
        int down = 1;

        for(int i = 0; i < N-1; i++){
            int a = Integer.parseInt(arr[i]);
            int b = Integer.parseInt(arr[i+1]);

            if(a == b){
                up++;
                down++;
            } else if (a < b) {
                down = 1;
                up++;
            } else {
                up = 1;
                down++;
            }

            answer = Math.max(answer, Math.max(up, down));
        }

        System.out.println(answer);
    }
}
