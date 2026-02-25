package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int term = 100001 , left = -1, sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>=s){
                left++;
                sum-=arr[left];
                term = Math.min(term,i-left+1);
            }
        }
        if(term==100001){
            System.out.print(0);
            return;
        }
        System.out.print(term);



    }
}