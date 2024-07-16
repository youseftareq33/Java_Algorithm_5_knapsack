public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weights = {3, 4, 7, 8, 9};
        int[] profits = {4, 5, 10, 11, 13};
        int capacity = 17;

        int maxProfit = knapsack(capacity, weights, profits);
        System.out.println("\n"+"Maximum profit: " + maxProfit);
    }
    
    
    
    
    
    public static int knapsack(int capacity, int[] weights, int[] profits) {
        int n = weights.length;
        int[][] dp = new int[capacity + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= capacity; i++) {
                if (weights[j - 1] <= i) {
                    dp[i][j] = Math.max(dp[i][j - 1], profits[j - 1] + dp[i - weights[j - 1]][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // Print the table
        System.out.println("Optimal Profit Table:"+"\n");
        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j <= n; j++) {
            	System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }

        return dp[capacity][n];
    }
}
