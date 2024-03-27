package dfs_bfs ; 

import java.util.*;

import bfs.SnakeEscape.Pair;

import java.io.*;


public class 인구이동 {
    public static int N, L, R;
    public static int[][] A;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1}; // 수정된 부분
    public static int[] dy = {1, 0, -1, 0}; // 수정된 부분
    public static ArrayList<Pair> union = new ArrayList<>();
    public static boolean isMove = false;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
        move();
        System.out.println(answer);
    }

    static void move() {
        while (true) {
            isMove = false;
            visited = new boolean[N][N]; // 새 BFS 시작할 때마다 방문 초기화
            

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j])
                    	continue; 
                    
                    // 연합 만들기
                    bfs(i, j);

                    // 인구 이동하기
                    movePoplulation();
                    
                }
            }
            if (!isMove) break;
            else answer++;
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;
        union.add(new Pair(x, y));

        while (!q.isEmpty()) { // bfs 적용은 암기, 기계처럼 하기
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (Math.abs(A[p.x][p.y] - A[nx][ny]) < L || Math.abs(A[p.x][p.y] - A[nx][ny]) > R)
                    continue;

                isMove = true;
                visited[nx][ny] = true;
                union.add(new Pair(nx, ny));
                q.add(new Pair(nx, ny));
            }
        }
    }

    static void movePoplulation() {
        int sum = 0;
        for (int i = 0; i < union.size(); i++) {
            Pair p = union.get(i);
            sum += A[p.x][p.y];
        }
        int avg = sum / union.size(); // 수정된 부분
        for (int i = 0; i < union.size(); i++) {
            Pair p = union.get(i);
            A[p.x][p.y] = avg;
        }
        union.clear(); // 수정된 부분
    }
}
