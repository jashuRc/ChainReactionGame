public class Game
{
    private State[][] mat;
    private int size;
    private int[][] board;
    int turn; 
    public static String[] colorString={ConsoleColors.RED_BOLD,ConsoleColors.GREEN_BOLD,ConsoleColors.YELLOW_BOLD};

    
    public Game(){
        size=6; 
        mat=new State[size][size];
        board=new int[size][size];
        initGame();
    }
    
    public Game(int size)
    {
        this.size=size; 
        mat=new State[size][size];
        board=new int[size][size];
        initGame();   
    }
    
    public void initGame()
    {
        turn=0;
        for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				mat[i][j]=State.E;
				board[i][j]=0;
			}
		}
    }
    
    public State[][] getStateMatrix()
    {
        return mat;
    }
    public int[][] getBoardMatrix()
    {
        return board;
    }
    
    public void showMatrixOnConsole()
	{
	
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
			    if(mat[i][j]==State.X1)
			    {
                System.out.print(colorString[0]+""+board[i][j]+" "+ConsoleColors.RESET);
			    }
			    else if(mat[i][j]==State.X2)
			    {
			    System.out.print(colorString[1]+""+board[i][j]+" "+ConsoleColors.RESET);
			    }
			    else
			    {
			    System.out.print(ConsoleColors.RESET+""+board[i][j]+" "+ConsoleColors.RESET);
			    }
			}
			System.out.println("");
		}
	}
    
     public boolean isValidMove(State s,int x,int y)
    {
        boolean result;
        result=false;
        
        if(x>=0 & x<=size-1 & y>=0 & y<=size-1)
        {
            if(mat[x][y] == State.E)
            {
                result=true;
            }
            else
            {
                if(mat[x][y] == s)
                {
                    result=true;
                }
                else
                {
                    result=false;
                }
            }
        }
        
        return result;
    }
    
     public void setState(State s,int x,int y)
    {
        mat[x][y]=s;
    }
    
    public void setMove(State s,int x,int y)
    {
        if(x>=0 & x<=size-1 & y>=0 & y<=size-1)
        {
            board[x][y]+=1;
            setState(s,x,y);
            if(board[x][y]+(x%(size-1)>0?0:1)+(y%(size-1)>0?0:1)>3)
            {
                board[x][y]=0;
                setState(State.E,x,y);
                setMove(s,x-1,y);
                setMove(s,x+1,y);
                setMove(s,x,y-1);
                setMove(s,x,y+1);
            }
        }
        
        try
        {
            System.out.println("Set Move Called...");
            Thread.sleep(100);
        }
        catch(Exception e)
        {}
    }
    
    
    /*we need set move and get move*/
    /*valid move or not*/
    /*winnig condition*/
    
    public boolean isWin(State s)
    {
        int count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(mat[i][j]!=s)
                {
                    if(mat[i][j]!=State.E)
                    {
                        count++;
                    }
                }
            }
        }
            if(count==0)
            {
                return true;
            }
            else
            {
                return false;
            }
    }
    
}





/* color class */




class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
