package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11000 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new int[]{s, 1, i});
            arr.add(new int[]{e, 0, i});
        }

        arr.sort((o1,o2) -> o1[0] != o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]);

        Set<Integer> set = new HashSet<>();

        int answer = 0;
        for(int i=0;i<arr.size();i++){
            int idx = arr.get(i)[2];
            int type = arr.get(i)[1];

            if(type == 0){
                set.remove(idx);
            } else {
                set.add(idx);
            }
            answer = Math.max(answer, set.size());
        }
        System.out.print(answer);
    }
}