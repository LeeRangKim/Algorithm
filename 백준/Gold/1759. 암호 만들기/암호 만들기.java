import java.util.*;
import java.io.*;

public class Main {

    static int L;
    static int C;

    static String[] words;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp1 = br.readLine().split(" ");

        L = Integer.parseInt(temp1[0]);
        C = Integer.parseInt(temp1[1]);

        words = br.readLine().split(" ");

        Arrays.sort(words);

        permutation("", 0, 0);
    }

    private static void permutation(String answer, int N, int start) {
        if(N == L){
            int vowel = 0;
            for(int i = 0; i < L; i++){
                if(answer.charAt(i) == 'a'|answer.charAt(i) == 'e'
                |answer.charAt(i) == 'i'|answer.charAt(i) == 'o'
                |answer.charAt(i) == 'u') vowel++;
            }

            int consonant = L - vowel;

            if(vowel >= 1 & consonant >= 2) System.out.println(answer);;
        }

        for(int i = start; i < C; i++){
            permutation(answer+words[i], N+1, i+1);
        }
    }
}
