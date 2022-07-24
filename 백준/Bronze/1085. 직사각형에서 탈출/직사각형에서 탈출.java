import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[] compare = new int[4];

        compare[0] = x;
        compare[1] = y;
        compare[2] = Math.abs(x-w);
        compare[3] = Math.abs(h-y);

        Arrays.sort(compare);

        System.out.println(compare[0]);
    }
}
