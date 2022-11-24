import java.util.*;

class Solution {
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        int[] dis = new int[n + 1];

        for(int i = 2; i < dis.length; i++){
            dis[i] = -1;
        }

        // edge 정보를 map에 넣기
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for(int i = 0; i < edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];

            if(!edgeMap.containsKey(s)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(e);
                edgeMap.put(s, temp);
            } else {
                List<Integer> temp = edgeMap.get(s);
                if(!temp.contains(e)) temp.add(e);
                edgeMap.put(s, temp);
            }
            if(!edgeMap.containsKey(e)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(s);
                edgeMap.put(e, temp);
            } else {
                List<Integer> temp = edgeMap.get(e);
                if(!temp.contains(s)) temp.add(s);
                edgeMap.put(e, temp);
            }
        }



        Deque<List<Integer>> deque = new ArrayDeque<>();
        List<Integer> start = new ArrayList<>();
        start.add(1);
        start.add(0);
        deque.add(start);
        dis[1] = 0;

        boolean isStart = true;

        while(deque.size() != 0){
            List<Integer> now = deque.poll();

            int nowVertex = now.get(0);
            int nowDis = now.get(1);


            List<Integer> nexts = edgeMap.get(nowVertex);
            for(int i = 0; i < nexts.size(); i++){
                int next = nexts.get(i);
                if (dis[next] == -1 || nowDis + 1 < dis[next]){
                    dis[next] = nowDis + 1;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(next);
                    temp.add(nowDis + 1);
                    deque.add(temp);
                }
            }
        }

        int maxDis = -1;
        for(int i = 2; i < dis.length; i++) {
            if(maxDis < dis[i]) maxDis = dis[i];
        }

        for(int i = 2; i < dis.length; i++){
            if(maxDis == dis[i]) answer++;
        }
        
        return answer;
    }

}