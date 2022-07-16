import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] melody = sc.nextLine().split(" ");
        String answer = "";
        if(melody[0].equals("1")){
            answer = "ascending";
            for(int i = 0; i< 8; i++){
                if(!melody[i].equals(Integer.toString(i+1))){
                    answer ="mixed";
                    break;
                };
            }
        } else if (melody[0].equals("8")) {
            answer = "descending";
            for(int i = 0; i< 8; i++){
                if(!melody[i].equals(Integer.toString(8-i))){
                    answer ="mixed";
                    break;
                }
            }
        } else {
            answer = "mixed";
        }

        System.out.println(answer);
    }
}
