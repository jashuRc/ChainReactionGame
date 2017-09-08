
public class PlayerX extends Player
{
    public PlayerX()
    {
        super();
        name="PX";
    }
    
    public PlayerX(State state)
    {
        super(state);
        name="PX";
    }
    
    @Override
    public Move getMove(State[][] mat,int[][] board)
    {
        //write logic below
        
        return new Move();
    }
    public static void main(String args[])
    {
        PlayerX p=new PlayerX(State.X1);
        
    }
}
