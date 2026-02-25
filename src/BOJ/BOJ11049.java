package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11049 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][][] value = new int[n][n][2];
        int dp[][] = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            value[i][i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }

        for(int i=1;i<n;i++){
            for(int start=0;start<n-i;start++){
                int end = start+i;
                dp[start][end] = Integer.MAX_VALUE;
                value[start][end] = new int[]{value[start][start][0], value[end][end][1]};

                for(int k=start; k<end; k++){
                    int cost = dp[start][k] + dp[k+1][end]
                            + value[start][k][0] * value[start][k][1] * value[k+1][end][1];

                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}