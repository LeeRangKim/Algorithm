import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] members = new String[N][2];

        for(int i = 0; i < N; i++){
            String temp[] = br.readLine().trim().split(" ");
            members[i][0] = temp[0];
            members[i][1] = temp[1];
        }

        Arrays.sort(members, (a, b)->{
            return compare(a[0], b[0]);
        });

        for(int i = 0; i < N; i++){
            System.out.println(members[i][0]+" "+members[i][1]);
        }

    }

    private static int compare(String a, String b) {
        if(!a.equals(b)) return Integer.parseInt(a) - Integer.parseInt(b);
        else return 0;
    }
}