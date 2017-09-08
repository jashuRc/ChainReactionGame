import java.util.*;


public class Player2 extends Player
{
    public Player2()
    {
        super();
        name="P2";
    }
    
    public Player2(State state)
    {
        super(state);
        name="P2";
    }
    
    @Override
    public Move getMove(State[][] mat,int[][] board)
    {
        //write logic below
        Random rand=new Random();
       
        int row,col;
        while(true)
        {
            row=rand.nextInt(board.length-1);
            col=rand.nextInt(board.length-1);
            if(mat[row][col] == getPlayerState() || mat[row][col] == State.E)
            {
                break;
            }
        }
        return new Move(getPlayerState(),row,col);
    }
    public static void main(String args[])
    {
        Player2 p=new Player2(State.X2);
        
    }
}
