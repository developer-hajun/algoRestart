import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17352 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int find_parents(int x,int[] parents){
        if(parents[x]!=x){
            parents[x]= find_parents(parents[x],parents);
        }
        return parents[x];
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] parents = new int[n+1];
        for(int i=1;i<=n;i++){
            parents[i]=i;
        }
        for(int i=1;i<=n-2;i++){
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int left_parents = find_parents(left,parents);
            int right_parents = find_parents(right,parents);

            if(left_parents==right_parents) continue;

            if(left_parents<right_parents) parents[right_parents]=left_parents;
            else parents[left_parents]=right_parents;
        }

        for(int i=1;i<=n;i++) find_parents(i,parents);

        for(int l=1;l<=n;l++){
            for(int r=l+1;r<=n;r++){
                if(parents[l]!=parents[r]){
                    System.out.print(l+" "+r);
                    return;
                }
            }
        }


    }
}