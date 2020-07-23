/**
 * 
 */
package leetcode;

/**
 * @author salipuri
 * 
 * 79. Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 *
 */
public class WordSearch {

	/**
	 * @param args
	 */
	
	public static boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,word,i,j,0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean dfs(char[][] board, String word,int i,int j, int currentIndex){
        if(currentIndex==word.length())
            return true;
        
        if(i<0 || i==board.length || j<0 || j==board[i].length || board[i][j]!=word.charAt(currentIndex))
            return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        
        boolean found = dfs(board,word,i+1,j,currentIndex+1) ||
        dfs(board,word,i-1,j,currentIndex+1) ||
        dfs(board,word,i,j+1,currentIndex+1) ||
        dfs(board,word,i,j-1,currentIndex+1);
            
        board[i][j] = temp;
        
        return found;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
	}

}
