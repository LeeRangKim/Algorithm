import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputWord = sc.nextLine();
        char[] inputWordArr = inputWord.toCharArray();
        int[] count = new int[26];

        int maxCount = -1;
        int maxIdx = -1;
        for(int i=0; i<inputWordArr.length; i++){
            int idx = -1;
            if( (int)inputWordArr[i] >= (int)'a'){
                idx = (int)inputWordArr[i]-(int)'a';
            } else {
                idx = (int)inputWordArr[i]-(int)'A';
            }
            count[idx]++;
            if(maxCount < count[idx]){
                maxCount = count[idx];
                maxIdx = idx;
            }
        }

        int temp = 0;
        for(int i = 0; i < 26; i++){
            if(Objects.equals(maxCount, count[i])){
                temp++;
            }
        }

        char answer = ' ';
        if(temp > 1){
            answer = '?';
        }else{
            answer = (char)(maxIdx+65);
        }
        System.out.println(answer);
    }
}
