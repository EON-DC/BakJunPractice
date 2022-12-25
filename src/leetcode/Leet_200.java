package leetcode;

public class Leet_200 {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    BPSisland(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void BPSisland(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            BPSisland(grid, i + 1, j); // upward
            BPSisland(grid, i - 1, j); // down
            BPSisland(grid, i, j - 1); // left
            BPSisland(grid, i, j + 1); // right
        }
    }
}
}
