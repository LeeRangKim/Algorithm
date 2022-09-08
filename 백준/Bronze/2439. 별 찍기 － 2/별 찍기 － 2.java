import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0 ; i < N; i++){
            for(int j=N-i-1; 0<j; j--){
                System.out.printf(" ");
            }
            for(int j = i+1; 0 < j; j--){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
