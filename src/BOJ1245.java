import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1245 {
    static int[][] board;
    static int n, m;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] > 0) {
                    if (isPeak(i, j)) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isPeak(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        boolean isPeak = true;
        int currentHeight = board[y][x];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cy = curr[0];
            int cx = curr[1];

            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (board[ny][nx] > currentHeight) {
                        isPeak = false;
                    }
                    else if (!visited[ny][nx] && board[ny][nx] == currentHeight) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return isPeak;
    }
}