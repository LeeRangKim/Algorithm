import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(90 <= N && N <= 100){
            System.out.println("A");
        }
        if(80 <= N && N <= 89){
            System.out.println("B");
        }
        if(70 <= N && N <= 79){
            System.out.println("C");
        }
        if(60 <= N && N <= 69){
            System.out.println("D");
        }
        if(0 <= N && N <= 59){
            System.out.println("F");
        }
    }
}
