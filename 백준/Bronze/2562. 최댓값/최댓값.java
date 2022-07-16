import java.util.*;

public class Main {
    public static void main(String[] args) {
        int maxNum = -1;
        int maxIdx = -1;
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<10; i++){
            int temp = sc.nextInt();
            if(temp > maxNum){
                maxNum = temp;
                maxIdx = i;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxIdx);
    }
}