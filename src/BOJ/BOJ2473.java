package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean pick[] = new boolean[n];
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer[] = new int[3];
        long gap = Long.MAX_VALUE;

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            pick[i]=true;
            int value = arr[i];

            int left=0;
            int right=n-1;
            while(left < right && pick[left]) left++;
            while(left < right && pick[right]) right--;

            while(left<right){
                long now_value = (long)arr[left]+arr[right]+value;

                if(Math.abs(now_value)<gap){
                    gap = Math.abs(now_value);
                    answer = new int[]{arr[left],arr[right],arr[i]};
                }
                if(now_value<0){
                    left++;
                    while(left < right && pick[left]) left++;
                }
                else{
                    right--;
                    while(left < right && pick[right]) right--;
                }
            }
            pick[i]=false;
        }
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}