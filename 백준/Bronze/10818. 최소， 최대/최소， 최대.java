import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] num_list = scanner.nextLine().split(" ");
        int min_num = 10000001;
        int max_num =  -10000001;
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(num_list[i]);
            if(temp < min_num){
                min_num = temp;
            }
            if(temp > max_num){
                max_num = temp;
            }
        }
        System.out.println(min_num+" "+max_num);
    }
}
