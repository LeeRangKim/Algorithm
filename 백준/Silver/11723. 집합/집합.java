import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> S = new HashMap<>();

        for(int i =0; i < N ; i++){
            String[] temp = br.readLine().split(" ");

            int num = 0;
            if(!(temp[0].equals("all") || temp[0].equals("empty"))){num = Integer.parseInt(temp[1]);};
            switch (temp[0]){
                case "add":
                    if(S.containsKey(num)){
                        break;
                    }
                    S.put(num, 1);
                    break;
                case "remove":
                    if(S.containsKey(num)){
                        S.remove(num);
                    }
                    break;
                case "check":
                    if(S.containsKey(num)){
                        bw.write("1\n");
                        break;
                    }
                    bw.write("0\n");
                    break;
                case "toggle":
                    if(S.containsKey(num)){
                        S.remove(num);
                        break;
                    }
                    S.put(num, 1);
                    break;
                case "all":
                    for(int j = 1; j < 21; j++){
                        if(S.containsKey(j)){
                            continue;
                        }
                        S.put(j, 1);
                        continue;
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
