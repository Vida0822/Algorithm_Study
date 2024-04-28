package graph ; 
import java.io.*;
import java.util.*;

public class 최종순위 {
    static int T, N, M;
    static int[] inDegree;
    static boolean[][] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());
            inDegree = new int[N+1];
            edges = new boolean[N+1][N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                int currTeam = Integer.parseInt(st.nextToken());
                inDegree[currTeam] = i;
                for(int j=1;j<=N;j++)
                    if(j!=currTeam && !edges[j][currTeam]) edges[currTeam][j] = true;
            }
            M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                swap(a, b);
            }
            sb.append(topologySort()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }

    static String topologySort() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        for(int i=1;i<=N;i++) {
            // 사이클 발생
            if(q.size() == 0) return "IMPOSSIBLE";
			
            // 정확한 우위를 가릴 수 없음
            if(q.size() > 1) return "?";

            int curr = q.poll();
            sb.append(curr).append(" ");

            for(int j=1;j<=N;j++)
                if(edges[curr][j]) {
                    edges[curr][j] = false;
                    if(--inDegree[j] == 0) q.add(j);
                }
        }

        return sb.toString();
    }

    static void swap(int a, int b) {
    	// 상대적 순위 바꾸어주기
        if(!edges[a][b]) {
            edges[a][b] = true;
            edges[b][a] = false;
            inDegree[a]--;
            inDegree[b]++;
        } else {
            edges[b][a] = true;
            edges[a][b] = false;
            inDegree[b]--;
            inDegree[a]++;
        }
    }
}