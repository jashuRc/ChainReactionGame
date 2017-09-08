import java.util.*;


public class Player1 extends Player
{
    public Player1()
    {
        super();
        name="P1";
    }
    
    public Player1(State state)
    {
        super(state);
        name="P1";
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
        Player1 p=new Player1(State.X1);
    }
}
