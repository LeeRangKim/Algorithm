import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int k=0; k<T; k++){
            String nextInput = sc.nextLine();
            String[] temp = nextInput.split(" ");

            int R = Integer.parseInt(temp[0]);
            String S = temp[1];

            for(int i=0; i<S.length(); i++){
                for(int j = 0; j < R; j++){
                    System.out.printf("%s", S.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
