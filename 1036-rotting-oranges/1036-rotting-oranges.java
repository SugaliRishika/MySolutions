class Pair{
    int row;
    int col;
    int tm;
    Pair(int row1,int col1,int tm1){
        this.row=row1;
        this.col=col1;
        this.tm=tm1;
    } 
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        Queue<Pair> queue= new LinkedList<>();
        int[][] visited = new int[n][m];
        int countFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        int[] delrow= {-1,0,1,0};
        int[] delcol= {0,1,0,-1};
        int tm=0;
        int count=0;
        while(!queue.isEmpty()){
            int r=queue.peek().row;
            int c=queue.peek().col;
            int t=queue.peek().tm;
            tm=Math.max(tm,t);
            queue.remove();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    queue.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol]=2;
                    count++;
                }
            }
        }
        if(count!=countFresh){
            return -1;
        }else{
            return tm;
        }
    }
}
