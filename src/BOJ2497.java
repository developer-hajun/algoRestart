import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2497 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Integer.MAX_VALUE,0});
        for(int i=1;i<=n;i++){
            int value = Integer.parseInt(st.nextToken());
            while(queue.peekLast()[0]<=value){
                queue.pollLast();
            }
            sb.append(queue.peekLast()[1]+" ");
            queue.addLast(new int[]{value,i});
        }
        System.out.println(sb);

    }
}