import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i ++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int h = N % H;
            if(h==0){
                h = H;
            }

            int w = (int)Math.ceil((double) N / H);

            String strW = "";
            if(w < 10){
                strW = '0' + Integer.toString(w);
            } else {
                strW = Integer.toString(w);
            }

            System.out.println(Integer.toString(h)+strW);
        }
    }
}