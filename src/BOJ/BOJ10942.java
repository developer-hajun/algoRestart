package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10942 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        boolean answer[][] = new boolean[n][n];
        int[] arr = new int[n];

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++) answer[i][i]=true;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                answer[i][i+1]=true;
            }
        }

        for(int length=3;length<=n;length++){
            for(int start = 0;start<=n-length;start++){
                int end = start+length-1;
                if(arr[start]!=arr[end]) continue;
                if(!answer[start+1][end-1]) continue;
                answer[start][end]=true;
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            if(answer[left][right]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);



    }
}