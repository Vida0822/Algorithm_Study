​    
```java
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 200;

    public static int n, t;

    public static int[] u = new int[MAX_N + 1];
    public static int[] d = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력:
        n = sc.nextInt();
        t = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            u[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
            
        while(t-- > 0) {
            // Step 1
            // 위에서 가장 오른쪽에 있는 숫자를 따로 temp값에 저장해놓습니다.
            int temp = u[n - 1];
            
            // Step 2
            // 위에 있는 숫자들을 완성합니다. 
            // 오른쪽에서부터 채워넣어야 하며, 
            // 맨 왼쪽 숫자는 아래에서 가져와야함에 유의합니다.
            for(int i = n - 1; i >= 1; i--)
                u[i] = u[i - 1];
            u[0] = d[n - 1];
            
            // Step 3
            // 아래에 있는 숫자들을 완성합니다. 
            // 마찬가지로 오른쪽에서부터 채워넣어야 하며, 
            // 맨 왼쪽 숫자는 위에서 미리 저장해놨던 temp값을 가져와야함에 유의합니다.
            for(int i = n - 1; i >= 1; i--)
                d[i] = d[i - 1];
            d[0] = temp;
        }
        // 출력:
        for(int i = 0; i < n; i++)
            System.out.print(u[i] + " ");
        System.out.println();
        
        for(int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
        System.out.println();
    }
}
```
