package Programmers;
import java.util.*;
public class P_64061 {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Stack<Integer>> boardStackList = new ArrayList<>();
        Stack<Integer> bowel = new Stack<>();
        int countRemovedEle = 0;

        for(int i = 0; i< board[0].length ; i++){
            boardStackList.add(new Stack<Integer>());
        }
        for(int col= 0; col < board[0].length ; col++){
            for(int row = board.length-1; row >= 0  ; row--){
                if(board[row][col] != 0){
                    boardStackList.get(col).add(board[row][col]);
                }
            }
        }

        for(int i = 0; i < moves.length ; i++){
            if(!boardStackList.get(moves[i]-1).isEmpty()){
                int picked = boardStackList.get(moves[i]-1).pop();
                if(bowel.isEmpty() || picked != bowel.peek()){
                    bowel.add(picked);
                }else{
                    bowel.pop();
                    countRemovedEle += 2;
                }
            }else continue;
        }
        return countRemovedEle;
    }


}