/*
 * Class to store a move's logic
 */

public class Move
{
	State state; //State of a Move
	int row,column;

	public Move()
	{
		this.state=State.E;
		this.row=0;
		this.column=0;
	}

	public Move(State state,int row,int column)
	{
		this.state=state;
		this.row=row;
		this.column=column;
	}

	@Override
	public String toString()
	{
		return state+" @ ("+row+","+column+")";
	}
}
