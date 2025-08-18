import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first1, int second1) {
        this.first = first1;
        this.second = second1;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length; 
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) { 
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                        && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

