
public abstract class Player
{
    private State playerState;
    protected String name;
    
    public Player()
    {
        playerState=State.E;
    }
    
    public Player(State state)
    {
        playerState=state;
    }
    
    public final Player setState(State state)
    {
        playerState=state;
        return this;
    }
    
    abstract public Move getMove(State[][] mat,int[][] board);
    
    public final State getPlayerState()
    {
        return playerState;
    }
}
