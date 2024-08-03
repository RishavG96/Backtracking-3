class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }

        grid = new boolean[n][n];
        result = new ArrayList<>();
        backtrack(0);
        return result;
    }

    private void backtrack(int row) {
        // base
        if(row == grid.length) {
            List<String> newList = new ArrayList<>();
            for(int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < grid.length; j++) {
                    if(grid[i][j] == true) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                newList.add(sb.toString());
            }
            result.add(newList);
            return;
        }

        //logic
        for(int i = 0; i < grid.length; i++) {
            if(isSafe(row, i)) {
                grid[row][i] = true;

                backtrack(row + 1);

                grid[row][i] = false;
            }
        }
    }

    private boolean isSafe(int row, int col) {
        for(int i = row - 1; i >= 0; i--) {
            if(grid[i][col] == true) {
                return false;
            }
        }

        int r = row - 1;
        int c = col - 1;
        while(r >= 0 && c >= 0) {
            if(grid[r][c] == true) {
                return false;
            }
            r--;
            c--;
        }

        r = row - 1;
        c = col + 1;
        while(r >= 0 && c < grid.length) {
            if(grid[r][c] == true) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
}
