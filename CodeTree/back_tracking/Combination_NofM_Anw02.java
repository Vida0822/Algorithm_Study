package back_tracking;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author HEEMIN
 * @date 2023. 9. 19.-오후 12:56:41
 *	@subject 탈락 backtracking 
 * @content 


 */
public class Combination_NofM_Anw02 {
    public static int n, m;
    public static ArrayList<Integer> combination = new ArrayList<>();
    
    // 방문한 원소들을 출력해줍니다.
    public static void printCombination() {
        for(int i = 0; i < combination.size(); i++)
            System.out.print(combination.get(i) + " ");
        System.out.println();
    }

    // 지금까지 뽑은 갯수와 마지막으로 뽑힌 숫자를 추적하여
    // 그 다음에 뽑힐 수 있는 원소의 후보를 정합니다.
    public static void findCombination(int cnt, int lastNum) {
        // m개를 모두 뽑은 경우 답을 출력해줍니다.
        if(cnt == m) {
            printCombination();
            return;
        }

        // 뽑을 수 있는 원소의 후보들을 탐색합니다.
        for(int i = lastNum + 1; i <= n; i++) {
            combination.add(i);
            findCombination(cnt + 1, i);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        // 가능한 범위를 순회하며 해당 숫자가 
        // 조합의 첫번째 숫자일 때를 탐색합니다.
        for(int i = 1; i <= n; i++) {
            combination.add(i);
            findCombination(1, i);
            combination.remove(combination.size() - 1);
        }
    }
}