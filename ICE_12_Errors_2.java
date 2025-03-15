import becker.robots.*;

// This robot will be able to keep track of how many
// moves it's made, and then be able to print a message to
// the user saying that.
class MoveRobot extends Robot
{
   int numberOfMovesMade = 0;
    
    MoveRobot( City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    public void moveCounted()
    {
        this.move();
        this.numberOfMovesMade = this.numberOfMovesMade * 2;
    }
    
    public void printNumberOfMoves()
    {
        System.out.println("Since I started counting, I moved:");
        System.out.println( this.numberOfMovesMade);
        System.out.println("times!");
    }
    int numOfTurnsMade = 0;
    public void turnsCounted()
    {
        
        this.turnLeft(); 
        this.numOfTurnsMade = this.numOfTurnsMade * 2;
    }
    public void printNumberOfLeftTurns()
    {
        System.out.println("Since I have started counting, I have turned: ");
        System.out.println(this.numOfTurnsMade);
        System.out.println(" times!");
    }
}

public class ICE_12_Errors_2 extends Object
{
    public static void main(String[] args)
    { 
        City ForgetsVille = new City();
        MoveRobot mary = new MoveRobot(ForgetsVille, 4, 1, Direction.EAST, 0);
        new Wall(ForgetsVille, 2, 5, Direction.NORTH);
       // CityFrame City = new CityFrame(ForgetsVille);

        // First keep track of these 4
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.printNumberOfMoves();
        
        mary.turnLeft();
        
        while(mary.frontIsClear());
        {
            mary.moveCounted();
        }
        mary.printNumberOfMoves();
        mary.printNumberOfLeftTurns();
    }
}

