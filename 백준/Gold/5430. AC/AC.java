import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<String> queue = new ArrayDeque<>();

            for(int j = 0; j < n; j++){
                queue.add(st.nextToken());
            }

            Boolean isStart = true;
            Boolean isBreak = false;

            for(int j = 0; j < p.length; j++){
                if(p[j].equals("R")){
                    if(isStart) isStart = false;
                    else isStart = true;
                } else {
                    if(queue.size() == 0) {
                        sb.append("error\n");
                        isBreak = true;
                        break;
                    }
                    if(isStart) {
                        queue.pollFirst();
                    } else {
                        queue.pollLast();
                    }
                }
            }

            if(isBreak) continue;

            sb.append("[");
            int num = queue.size();
            if(isStart){
                for(int j = 0; j < num; j++){
                    if(j == num -1) sb.append(queue.pollFirst());
                    else sb.append(queue.pollFirst()+",");
                }
                sb.append("]\n");
            } else {
                for(int j = 0; j < num; j++){
                    if(j == num - 1) sb.append(queue.pollLast());
                    else sb.append(queue.pollLast()+",");
                }
                sb.append("]\n");
            }

        }

        System.out.println(sb);
    }
}
