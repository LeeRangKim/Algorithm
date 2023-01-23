import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 1;

        while (true) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] edges = new int[N+1][N+1];

            // 종료 조건
            if(N == 0 && M == 0) break;

            int[] visited = new int[N+1];

            for(int i = 0; i < M; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();

                edges[s][e] = 1;
                edges[e][s] = 1;
            }

            Map<Integer, List<Integer>> groups = new HashMap();

            for(int i = 1; i < N+1; i++){
                if(visited[i] == 1) continue;

                List<Integer> list = new ArrayList<>();
                list.add(i);

                Deque<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                visited[i] = 1;

                while (queue.size() > 0){
                    int now = queue.pollFirst();

                    for(int j = 1; j < N+1; j++){
                        if(edges[now][j] == 1 && visited[j] != 1){
                            queue.add(j);
                            list.add(j);
                            visited[j] = 1;
                        }
                    }
                }

                groups.put(i, list);
            }

            int tree = 0;

            for(Map.Entry<Integer, List<Integer>> entry : groups.entrySet()){
                List<Integer> group = entry.getValue();
                int edgeCount = 0;
                for(Integer s : group){
                    for(Integer e : group){
                        if(edges[s][e] == 1) edgeCount++;
                    }
                }

                if((float)edgeCount/2 == (float) group.size() - 1) tree++;
            }

            if(tree == 0){
                System.out.println("Case "+T+": No trees.");
            } else if (tree == 1) {
                System.out.println("Case "+T+": There is one tree.");
            } else {
                System.out.println("Case "+T+": A forest of "+tree+" trees.");
            }

            T++;

        }
    }
}
