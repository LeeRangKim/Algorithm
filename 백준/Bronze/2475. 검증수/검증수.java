import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 5;
        int sum = 0;
        String[] temp = sc.nextLine().split(" ");
        for(int i = 0 ; i < N; i++){
            sum += Math.pow(Integer.parseInt(temp[i]), 2);
        }
        System.out.println(sum % 10);
    }
}
