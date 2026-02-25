package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9328 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine().trim());

        for (int test_case = 0; test_case < tc; test_case++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h + 2][w + 2];
            for (char[] row : map) Arrays.fill(row, '.');

            for (int i = 1; i <= h; i++) {
                String now = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = now.charAt(j - 1);
                }
            }

            h += 2;
            w += 2;

            String keys = br.readLine().trim();
            int keyMask = 0;
            if (!keys.equals("0")) {
                for (char c : keys.toCharArray()) {
                    keyMask |= 1 << (c - 'a');
                }
            }

            List<int[]>[] waiting = new List[26];
            for (int i = 0; i < 26; i++) waiting[i] = new ArrayList<>();

            boolean[][] visited = new boolean[h][w];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
            int ans = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dx[d];
                    int nc = c + dy[d];

                    if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                    if (visited[nr][nc] || map[nr][nc] == '*') continue;

                    char ch = map[nr][nc];

                    if (ch >= 'A' && ch <= 'Z') {
                        int bit = ch - 'A';
                        if ((keyMask & (1 << bit)) == 0) {
                            waiting[bit].add(new int[]{nr, nc});
                            continue;
                        }
                    }

                    visited[nr][nc] = true;

                    if (ch >= 'a' && ch <= 'z') {
                        int bit = ch - 'a';
                        if ((keyMask & (1 << bit)) == 0) {
                            keyMask |= 1 << bit;
                            for (int[] pos : waiting[bit]) {
                                if (!visited[pos[0]][pos[1]]) {
                                    visited[pos[0]][pos[1]] = true;
                                    queue.add(pos);
                                }
                            }
                            waiting[bit].clear();
                        }
                    }

                    if (ch == '$') ans++;

                    queue.add(new int[]{nr, nc});
                }
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}