import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}