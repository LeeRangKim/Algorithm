import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = sc.next().split("");
        String[] B = sc.next().split("");

        List<String> reverseA = Arrays.asList(A);
        Collections.reverse(reverseA);
        List<String> reverseB = Arrays.asList(B);
        Collections.reverse(reverseB);

        String compareA = "";
        String compareB = "";

        for(String item : reverseA){
            compareA += item;
        }
        for(String item : reverseB){
            compareB += item;
        }

        int answer = 0;
        if(Integer.parseInt(compareA) > Integer.parseInt(compareB)){
            answer = Integer.parseInt(compareA);
        } else {
            answer = Integer.parseInt(compareB);
        }
        System.out.println(answer);

    }
}
