class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int n=board.length;
        int m=board[0].length;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(i,0,board,delRow,delCol);
            if(board[i][m-1]=='O') dfs(i,m-1,board,delRow,delCol);
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O') dfs(0,j,board,delRow,delCol);
            if(board[n-1][j]=='O') dfs(n-1,j,board,delRow,delCol);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='*') board[i][j]='O';
            }
        }
    }
    private void dfs(int row,int col,char[][] board,int[] delRow,int[] delCol){
        int n=board.length;
        int m=board[0].length;
        board[row][col]='*';
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,delRow,delCol);
            }
        }
    }
}
