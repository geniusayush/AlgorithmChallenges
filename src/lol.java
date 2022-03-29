public class lol {
    // Function that returns length of the longest path
    // beginning with mat[i][j]
    // This function mainly uses lookup table dp[n][n]
    static int findLongestFromACell(int i, int j, int mat[][], int dp[][]) {
        // Base case
        int n = mat.length;
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;

        // If this subproblem is already solved
        if (dp[i][j] != -1)
            return dp[i][j];

        // To store the path lengths in all the four directions
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, w = Integer.MIN_VALUE;
        // Since all numbers are unique and in range from 1 to n*n,
        // there is atmost one possible direction from any cell
        int m = mat[0].length;

        int sum = 0;
        if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1])) {
            sum = findLongestFromACell(i, j + 1, mat, dp);
            x = dp[i][j] = (int) (mat[i][j] * Math.pow(10, lengthf(sum)) + sum);
        }

        if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1])) {
            sum = findLongestFromACell(i, j - 1, mat, dp);
            y = dp[i][j] = (int) (mat[i][j] * Math.pow(10, lengthf(sum)) + sum);
        }

        if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j])) {
            sum = findLongestFromACell(i - 1, j, mat, dp);
            z = dp[i][j] = (int) (mat[i][j] * Math.pow(10, lengthf(sum)) + sum);
        }
        if (i < n - 1 && (mat[i][j] + 1 == mat[i + 1][j])) {
            sum = findLongestFromACell(i + 1, j, mat, dp);
            w = dp[i][j] = (int) (mat[i][j] * Math.pow(10, lengthf(sum)) + sum);
        }

        // If none of the adjacent fours is one greater we will take 1
        // otherwise we will pick maximum from all the four directions
        return dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1))));
    }

    static int lengthf(int n) {
        return (int) (Math.log10(n) + 1);
    }

    // Function that returns length of the longest path
    // beginning with any cell
    static int finLongestOverAll(int mat[][]) {
        // Initialize result
        int result = 1;
        int n = mat.length;
        int m = mat[0].length;
        // Create a lookup table and fill all entries in it as -1
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        // Compute longest path beginning from all cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j, mat, dp);

                // Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
