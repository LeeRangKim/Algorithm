import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] deque = new String[10000];
        int front = 0;
        int back = 0;
        int size = 0;

        for(int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            switch (temp[0]){
                case "push_front" : {
                    deque[front] = temp[1];
                    front = (front-1 + 10000) % 10000;
                    size++;
                    break;
                }

                case "push_back" : {
                    back = (back + 1) % 10000;
                    deque[back] = temp[1];
                    size++;
                    break;
                }

                case "pop_front" : {
                    if(size==0){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque[(front + 1) % 10000]);
                        front = (front + 1) % 10000;
                        size--;
                    }
                    break;
                }

                case "pop_back" : {
                    if(size==0){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque[back]);
                        back = (back - 1 + 10000) % 10000;
                        size--;
                    }
                    break;
                }

                case "size" : {
                    System.out.println(size);
                    break;
                }

                case "empty" : {
                    if(size == 0){
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }

                case "front" : {
                    if(size==0){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque[(front + 1) % 10000]);
                    }
                    break;
                }

                case "back" : {
                    if(size==0){
                        System.out.println(-1);
                    } else {
                        System.out.println(deque[back]);
                    }
                    break;
                }
            }
        }
    }
}
