import java.io.*;
import java.util.*;

public class GameRunner
{
    private static Game game;
    private int pLength;
    private Player player[];
    boolean isInteractive;
    private int[][][] finalResult;
    
    public GameRunner()
    {
        player=new Player[]{new Player1(),new Player2()};
        pLength=player.length;
        isInteractive=false;
        finalResult=new int[pLength][pLength][pLength];
        
    }
    
    class ResultSet
    {
        int elem1,elem2;
        public void show()
        {
            System.out.println("\nResult 1:"+elem1);
            System.out.println("Result 2:"+elem2);
        }
    }
    
    private void startSimulation(int n,int sizeofBoard)
    {
        for(int k=0;k<n;k++)
        {
            System.out.println("Iteration "+(k+1));
            for(int i=0;i<pLength;i++)
            {
                for(int j=0;j<pLength;j++)
                {
                    if(i!=j)
                    {
                        this.game=new Game(sizeofBoard);
                        System.out.println("Player " + player[i].name + " v/s Player " + player[j].name);
                        ResultSet result=startGameLoop(player[i].setState(State.X1), player[j].setState(State.X2));
                        
                        finalResult[i][j][i] += result.elem1;
                        finalResult[j][i][i] += result.elem2;
                    }
                }
            }
        }
    }
    
        //Run game for player1 and player2 and return score of simulation
    private ResultSet startGameLoop(Player player1,Player player2){

        final int error_count[]=new int[1];

            //initialize game-running to true
            boolean gameRunning=true;
            int gameIteration=0;
            Player player;
            while(gameRunning){

                //set player
                if((game.turn++)%2!=0) {
                    player = player2;
                }
                else {
                    player = player1;
                }
                System.out.println("Player "+player.name+"'s turn");
                if(isInteractive){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                error_count[0]=0 ;  //to count errors due to wrong proposed moves

                //give 3 chances to a player to make a right move
                while(error_count[0]<3) {

                    //get present player's next move
                    try {
                        System.out.print("\t\t\t\t< Player "+player.name+" is thinking... >");

                        Move move = player.getMove(game.getStateMatrix(),game.getBoardMatrix());
                        System.out.println(move);
                        System.out.print("\r");

                        if(move==null||move.state!=player.getPlayerState()){
                            error_count[0]++;
                            continue;
                        }

                        //check if present proposed move is valid
                        if (game.isValidMove(move.state, move.row, move.column)) {

                            //if move is valid, make the move.
                            game.setMove(move.state,move.row,move.column);

                            //show result of move
                            game.showMatrixOnConsole();

                            if(gameIteration > 5)
                            {
                            if(game.isWin(move.state))
                            {

                                //display player won
                                System.out.println("Player "+player.name+" won\n-------------------------------\n");
                                gameRunning=false;
                            }
                           }
                            break;
                        }
                        else{
                            //else if move is invalid then check again from same player
                            error_count[0]++;
                        }
                    }
                    catch(Exception e){
                        error_count[0]++;
                    }
                }

                    //check if error was encountered and terminate if so with message
                    if(error_count[0]==3){

                        //display message
                        System.out.println("\nXXXXXXXXXXXXXXXXX\nPlayer : "+player.name+" made 3 wrong moves\n" +
                                "XXXXXXXXXXXXXXXXX\n");

                        //set game state to false
                        gameRunning=false;
                    }
                    gameIteration++;
                }

        //checks for default as being player1's turn and for error as true
        return getScore(game.turn%2!=0,error_count[0]==3);
    }
    
    
     /*Method to return score based on which player's turn it was and if error was present*/
    private ResultSet getScore(boolean firstPlayerTurn, boolean hasError){
        ResultSet result=new ResultSet();
        if(firstPlayerTurn&&hasError){
            result.elem1=-1;
            result.elem2=1;
        }
        else if(!firstPlayerTurn&&hasError){
            result.elem1=1;
            result.elem2=-1;
        }
        else if(firstPlayerTurn&&!hasError){
            result.elem1=1;
            result.elem2=0;
        }
        else if(!firstPlayerTurn&&!hasError){
            result.elem1=0;
            result.elem2=1;
        }
        return result;

    }
    
    public static void main(String args[])
    {
        GameRunner runner=new GameRunner();
        int n,sizeofBoard;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of Simulation:");
        n=scanner.nextInt();
        System.out.println("Enter Board Size:");
        sizeofBoard=scanner.nextInt();
        runner.startSimulation(n,sizeofBoard);
        
    }
}



   
