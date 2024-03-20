package dfs_bfs ; 
import java.util.*;

public class 연구소 {

    public static int n, m, result = 0;
    
    // 깊이 우선 탐색(DFS)을 이용해 각 바이러스가 사방으로 퍼지도록 하기
    public static void virus(int x, int y, int[][] virusLab) {
    	
    	// 4가지 이동 방향에 대한 배열
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (virusLab[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                	virusLab[nx][ny] = 2;
                    virus(nx, ny, virusLab);
                }
            }
        }
    } // virus

    // 현재 맵에서 안전 영역의 크기 계산하는 메서드
    public static int getScore(int[][] virusLab) {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusLab[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    } // getScore

    // 깊이 우선 탐색(DFS)을 이용해 울타리를 설치하면서, 매 번 안전 영역의 크기 계산
    public static void dfs(int count, int[][] lab) {
    	
        // 울타리가 3개 설치된 경우
        if (count == 3) {
        	
        	int[][] virusLab = new int[lab.length][lab[0].length] ; 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                	virusLab[i][j] = lab[i][j];
                }
            }
            // 각 바이러스의 위치에서 전파 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (virusLab[i][j] == 2) {
                        virus(i, j, virusLab);
                    }
                }
            }
            // 안전 영역의 최대값 계산
            result = Math.max(result, getScore(virusLab));
            return;
        }
        // 빈 공간에 울타리를 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    count += 1;
                    dfs(count, lab);
                    lab[i][j] = 0;
                    count -= 1;
                }
            }
        }
    } // dfs

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        int[][] lab = new int[n][m] ; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        dfs(0, lab);
        System.out.println(result);
    }
}