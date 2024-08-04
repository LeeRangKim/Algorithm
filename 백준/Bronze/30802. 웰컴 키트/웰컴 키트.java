import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> t = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] str = sc.nextLine().split(" ");
        int T = Integer.parseInt(str[0]);
        int P = Integer.parseInt(str[1]);

        int tAnswer = 0;
        for (int i : t) {
            tAnswer += i / T;
             if (i % T != 0) {
                 tAnswer += 1;
             }
        }

        System.out.println(tAnswer);
        System.out.println(n / P + " " + n % P);
    }
}