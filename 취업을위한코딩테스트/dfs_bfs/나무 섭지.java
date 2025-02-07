import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int count;

    public Point() {
    }

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}


public class Main {

    public static int[][] map = new int[1000][1000];

    public static int n;
    public static int m;

    public static Point goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray() ; 
        n = split[0];
        m = split[1];

        // step 1 : 지도 만들기 + 출발 큐 만들기
        ArrayList<Point> ghosts = new ArrayList<>();
        Point man = new Point();
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (ch[j] == '#')
                    map[i][j] = 1;
                else if (ch[j] == 'N')
                    man = new Point(i, j, 0);
                else if (ch[j] == 'G')
                    ghosts.add(new Point(i, j, 0));
                else if (ch[j] == 'D')
                    goal = new Point(i, j, 0);                    
            }
        }

        // step 2 : 유령 , 건우의 출구까지의 최단거리 대소비교!!
        int min = bfs(man, "man");

        if (min == -1){
            System.out.println("No");
            return ; 
        }

        ghosts.sort(Comparator.comparingInt(gh -> {
            int row = Math.abs(goal.x - gh.x) ; 
            int col = Math.abs(goal.y - gh.y) ; 

            return row + col; 
        })) ; 
        
        if ( bfs(ghosts.get(0), "ghost") <= min) {
            System.out.println("No") ;
            return ; 
        }
        System.out.println("Yes") ; 
    }

    public static int bfs(Point start, String type) {
        
        boolean[][] visited = new boolean[1000][1000];
        
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == goal.x && cur.y == goal.y) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
                    continue;
                if(type == "man" && map[nx][ny] == 1)
                    continue; 

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, cur.count + 1));
            }
        }
        return -1 ; 
    }
}
