import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int N = sc.nextInt();
            if(N == 0){
                break;
            }

            String[] nums = Integer.toString(N).split("");
            int flag = 0;
            for(int i = 0 ; i < nums.length/2 ; i++){
                if(!nums[i].equals(nums[nums.length-1-i])){
                    flag = 1;
                    System.out.println("no");
                    break;
                }
            }
            if(flag == 0){
                System.out.println("yes");
            }
        }
    }
}
