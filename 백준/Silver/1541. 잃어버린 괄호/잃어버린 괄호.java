import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        StringTokenizer numbers = new StringTokenizer(temp, "+-");
        
        int answer = Integer.parseInt(numbers.nextToken());
        int minusValue = 0;

        for(int i =0; i<temp.length(); i++){
            if(temp.charAt(i) == '+'){
                if(minusValue != 0){
                    minusValue += Integer.parseInt(numbers.nextToken());
                } else {
                    answer += Integer.parseInt(numbers.nextToken());
                }
            } else if (temp.charAt(i) == '-') {
                minusValue += Integer.parseInt(numbers.nextToken());
            } else {
                continue;
            }

            if(numbers.hasMoreTokens() == false){
                break;
            }
        }
        answer -= minusValue;
        System.out.println(answer);
    }
}
