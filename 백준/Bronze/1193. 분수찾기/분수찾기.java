import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        int n = 1;
        for(int i = 1; i < 10000000; i++){
            if(X <= (i+1)*i/2){
                break;
            }
            n = i+1;
        }

        int up = X - n*(n-1)/2;
        int down = n - up + 1;

        if(n % 2 == 0){
            System.out.println(up + "/" + down);
        } else {
            System.out.println(down + "/" + up);
        }
    }
}
