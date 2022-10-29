import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        Map<String, Integer> check = new HashMap<>();

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            if(check.containsKey(temp)) continue;
            words.add(temp);
            check.put(temp, 1);
        }
        Collections.sort(words, (a, b)->{
            return compare(a, b);
        });

        for(String data : words){
            System.out.println(data);
        }
    }

    private static int compare(String a, String b) {
        if(a.length() == b.length()) return a.compareTo(b);
        else{
            if(a.length() > b.length()) return 1;
            else return -1;
        }
    }
}