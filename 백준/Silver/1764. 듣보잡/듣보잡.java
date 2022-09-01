import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[0]);

        Map<String, String> unListen = new HashMap<>();

        for(int i=0; i < N; i ++){
            unListen.put(br.readLine(), "new");
        }

        List<String> unWatchandListen = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String temp2 = br.readLine();

            String temp3 = unListen.getOrDefault(temp2, "No");

            if(temp3.equals("new")){
                unWatchandListen.add(temp2);
            }
        }

        Collections.sort(unWatchandListen);

        System.out.println(unWatchandListen.size());
        for(int i = 0; i < unWatchandListen.size(); i++){
            System.out.println(unWatchandListen.get(i));
        }
    }
}
