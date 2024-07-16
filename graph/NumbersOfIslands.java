package graph;

public class NumbersOfIslands {


    public static void main(String[] args) {
        int count = 0;
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        NumbersOfIslands numbersOfIslands = new NumbersOfIslands();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                // 1인경우 dfs 시작, 주변 이어져있는 모든곳으로 전이
                if (grid[i][j] == '1') {
                    count++;
                    numbersOfIslands.dfs(i, j, grid);
                }
            }
        }

        System.out.println("numbersOfIslands count = " + count);
    }

    public void dfs(int i, int j, char[][] grid) {
                          //4                          //5
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 한번 탐색한 곳은 0 으로 표식
        grid[i][j] = '0';

        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
    }

}
