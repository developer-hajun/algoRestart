import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) arr[i]= Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int gap=Integer.MAX_VALUE;
        int left = 0,right = n-1;
        int answer_left = 0,answer_right=0;

        while(left<right){
            int now_gap = arr[right]+arr[left];
            if(Math.abs(now_gap)<gap){
                gap = Math.abs(now_gap);
                answer_left=arr[left];
                answer_right=arr[right];
            }

            if(now_gap<0) left++;
            else right--;
        }

        System.out.println(answer_left+" "+answer_right);


    }
}