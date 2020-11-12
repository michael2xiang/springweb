package algo;

import java.util.Scanner;

/**
 * 题目要求：
 * 将N张牌放在N个桶里面，有多少种放法，输入各种可能。本质是全排列问题。
 */
public class Dfs {
    int[] barrels = new int[10]; //桶
    int[] cards = new int[10]; //牌
    int n;

    public static void main(String[] args) {
        Dfs dd = new Dfs();
        Scanner sc = new Scanner(System.in);
        dd.n = sc.nextInt();
        for (int i = 0; i < 10; i++) {
            dd.cards[i] = 0;
        }
        dd.dfs(1);
    }

    public void dfs(int step) {
        if (step == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(barrels[i]);
            }
            System.out.println();
            return;

        }
        for (int i = 1; i <= n; i++) {
            if (cards[i] == 0) {
                barrels[step] = i; // 把第i张牌放在第step桶里
                cards[i] = 1; // 把该张牌(i)标记为1;说明该张牌已经不掌握;
                dfs(step + 1); // 执行下一步
                // System.out.println(i);
                cards[i] = 0;
            }
        }
        // return ;
    }

}