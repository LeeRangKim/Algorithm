import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        Map<Integer, List<Integer>> edges = new HashMap<>();

        for(int i = 0; i < M; i ++){
            String[] temp2 = br.readLine().split(" ");
            int S = Integer.parseInt(temp2[0]);
            int E = Integer.parseInt(temp2[1]);

            if(edges.containsKey(S)){
                List<Integer> temp3 = edges.get(S);
                temp3.add(E);
                edges.replace(S, temp3);
            } else {
                List<Integer> temp3 = new ArrayList<>();
                temp3.add(E);
                edges.put(S, temp3);
            }

            if(edges.containsKey(E)){
                List<Integer> temp3 = edges.get(E);
                temp3.add(S);
                edges.replace(E, temp3);
            } else {
                List<Integer> temp3 = new ArrayList<>();
                temp3.add(S);
                edges.put(E, temp3);
            }
        }

        int minNum = 150 * 5000;
        int minVertex = 2000;

        for(int i = 1; i < N+1; i++){
            int[] check = new int[N+1];

            for(int j = 1; j < N+1; j++){
                check[j] = -1;
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{i, 0});
            check[i] = 0;

            while (deque.size() != 0){
                int[] now = deque.pollFirst();
                int nowVertex = now[0];
                int nowCount = now[1];

                List<Integer> nextVertexs = edges.get(nowVertex);
                for(int j = 0; j < nextVertexs.size(); j++){
                    int nextVertex = nextVertexs.get(j);

                    if(check[nextVertex] != -1 && nowCount + 1 > check[nextVertex]){
                        continue;
                    }

                    check[nextVertex] = nowCount + 1;
                    deque.add(new int[]{nextVertex, nowCount + 1});
                }
            }

            int num = 0;
            for(int j = 1; j < N+1; j++){
                num += check[j];
            }

            if(num < minNum){
                minNum = num;
                minVertex = i;
            }
        }

        System.out.println(minVertex);
    }
}
