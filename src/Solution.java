/*
Platform LeetCode.
Problem Statement :

You are given an m x n binary matrix grid, where 0 represents
a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another
adjacent (4-directionally) land cell or walking off the boundary
of the grid.

Return the number of land cells in grid for which we cannot walk
off the boundary of the grid in any number of moves.

Space and time complexity both are O(m*n)
 */
public class Solution {

    public void dfs(int x,int y,int m,int n,int[][] grid,boolean[][] visit){
        if(x < 0 || x >= m || y < 0 || y>= n || grid[x][y] == 0 || visit[x][y]){
            return;
        }
        visit[x][y] = true;


        int[] dirx = {1,-1,0,0};
        int[] diry = {0,0,1,-1};



        for(int i = 0;i<4;i++){
            dfs(x+dirx[i],y+diry[i],m,n,grid,visit);


        }

        return;



    }
    public int numEnclaves(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        boolean[][]visit = new boolean[m][n];

        for(int i = 0; i<m; ++i){
            //First column
            if(grid[i][0] == 1 && !visit[i][0]){
                dfs(i,0,m,n,grid,visit);
            }
            //last column
            if(grid[i][n-1] == 1  && !visit[i][n-1]){
                dfs(i,n-1,m,n,grid,visit);
            }
        }
        for(int i = 0;i<n;++i){
//            First row
            if(grid[0][i] == 1 && !visit[0][i]){
                dfs(0,i,m,n,grid,visit);

            }
//             Last row
            if(grid[m-1][i] == 1 && !visit[m-1][i]){
                dfs(m-1,i,m,n,grid,visit);
            }
        }
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1 && !visit[i][j]){
                    count++;

                }
            }
        }

        return count;

    }
}