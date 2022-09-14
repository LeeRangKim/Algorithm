import java.util.Scanner;

public class Main {
    static int[] ANums;
    static int[] BNums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        if(B<A){
            int temp;
            temp = A;
            A = B;
            B = temp;
        }

        int[] ANums = new int[A+1];
        int[] BNums = new int[B+1];

        checkNum(ANums, A);
        checkNum(BNums, B);

        int minNum = 1;
        int maxNum = 1;

        for(int i = 2; i < B+1; i++){
            if(i < A+1){
                if(ANums[i] == 0 && BNums[i] == 0) continue;
                if(ANums[i] == 0){
                    maxNum *= Math.pow(i, BNums[i]);
                } else if (BNums[i] == 0) {
                    maxNum *= Math.pow(i, ANums[i]);
                } else if (ANums[i] > BNums[i]) {
                    int com = ANums[i] - BNums[i];
                    minNum *= Math.pow(i, BNums[i]);
                    maxNum *= Math.pow(i, ANums[i]);
                } else {
                    minNum *= Math.pow(i, ANums[i]);
                    maxNum *= Math.pow(i, BNums[i]);
                }
            } else {
                maxNum *= Math.pow(i, BNums[i]);
            }
        }


        System.out.println(minNum);
        System.out.println(maxNum);

    }



    private static void checkNum(int[] nums, int num) {
        while(num != 1) {
            for(int i = 2; i < num+1; i++){
                if((double)num % i == 0){
                    nums[i]+=1;
                    num/=i;
                    break;
                }
            }
        }

    }
}
