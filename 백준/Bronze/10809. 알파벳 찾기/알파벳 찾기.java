import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int[] answer = new int[26];
        for(int i = 0; i < answer.length ; i ++){
            answer[i] = -1;
        }
        for(int i = N.length()-1 ; i >= 0; i--){
            answer[N.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < answer.length ; i ++){
            System.out.printf(answer[i]+" ");
        }
    }
}
