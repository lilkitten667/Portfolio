import becker.robots.*;
import java.util.Random;
import java.util.Scanner;


public class A2
{

    public static void main(String[] args)
    {
        City wallville = new City(6, 12);
        Robot lateRobot = new Robot(wallville, 1, 2, Direction.EAST, 0);

        A2.buildCity(wallville); // this calls the "BuildCity" method, below

        /*
         * TODO: * * * * * Your code to race around the race track goes here! * * * *
         * HINT: Several while loops would work well for this particular exercise. One
         * possible solution would be to start with a while loop (for checking the
         * count) that contains two nested while loops used to check whether the front
         * is clear before performing some actions. Jumping through this initial while
         * loop might use additional while loops to continue checking whether the front
         * is clear before performing other actions in order to complete the tasks of
         * the maze.
         */
    

        // Move until a wall is encountered
        public void moveToWall()
        {
            while (lateRobot.frontIsClear())
            {
                this.move();
            }
        }

        // Pick up all things in the current location
        public void pickUpThing()
        {
            while (canPickThing())
            {
                this.pickThing();
            }
        }

        // Place all things in the current location
         public void placeThing()
        {
            
            while (this.countThingsInBackpack() < 5)
            {
                this.putThing();
                this.move();
                
            }
        }

        // Turn 180 degrees
        public void turnAround()
        {
            this.turnLeft();
            this.turnLeft();
        }
        
        

        // Turn right (by turning left three times)
        public void turnRight()
        {
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
        }

        // Move down one row
        public void moveDownToNextRow()
        {
            this.turnLeft(); // Face SOUTH
            if (frontIsClear())
            {
                this.move(); // Move down one row if there's no wall
            }
            this.turnLeft(); // Face EAST to go right along the new row
        }

        // Move to the last row (row 5) and place all collected things
        public void moveToLastRowAndDrop()
        {
            // Ensure robot is facing SOUTH
            while (this.getDirection() != Direction.SOUTH)
            {
                this.turnLeft();
            }

            // Move down to row 5, checking if the front is clear before moving
            while (this.getStreet() < 7)
            {
                if (frontIsClear())
                {
                    this.move();
                } 
            }
            

            // After reaching row 5, place all things
            this.placeThing();

            // Ensure the robot faces EAST to avoid crashing into a wall
            while (this.getDirection() != Direction.EAST)
            {
                this.turnLeft();
            }
        }

        // Main task: go through all rows, collect items, and drop them off at row 5
        public void doEverything()
        {
            // Go through each row (1 to 4)
            while (this.getAvenue() < 8)
            {
                this.moveToWall(); 
                this.pickUpThing(); 
                this.turnAround(); 
                this.moveToWall(); 

                while (!this.frontIsClear())
                {
                    this.turnLeft();
                    this.move();
                }
                
                while (this.getDirection() != Direction.EAST)
                {
                    this.turnLeft();
                }
                
                this.moveToWall();
                
                while (this.countThingsInBackpack() < 0)
                {
                    if (this.countThingsInBackpack() < 5)
                    {
                        this.putThing();
                        this.move();
                }
                while (this.getDirection() != Direction.WEST)
                {
                    this.turnAround();
                }
            }
        }   
        }
    }
        {
           
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // No need to touch any of the code below.
    // All it does is construct the maze in the city.
    /////////////////////////////////////////////////////////////////////////////////////////
    public static void buildCity(City wallville)
    {
        // Width and height must be at least 2 (each)
        // Feel free to change these numbers, and see how your race track changes

        Random randomNumberGenerator = new Random();
        int top = 1;
        int left = 2;
        int height = 4;
        int width = 4 + randomNumberGenerator.nextInt(7);

        int streetNumber = top;
        while (streetNumber <= height)
        {
            if (streetNumber == 1)
            {
                // the topmost line:
                new Wall(wallville, streetNumber, left, Direction.NORTH);
            } else if (streetNumber == height)
            {
                // generate the 'holding spot' thing at the bottom: the corner:
                new Wall(wallville, streetNumber + 1, left, Direction.WEST);
                new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
                int spotNum = left + 1;
                int counter = 0;
                while (counter < height)
                {
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
                    // Uncomment the next line for a 'final state' picture (i.e., the second picture
                    // in the assignment)
                    // new Thing(wallville, streetNumber + 1, spotNum);
                    ++spotNum;
                    ++counter;
                }
                new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
            }

            // the most western, vertical line:
            new Wall(wallville, streetNumber, left, Direction.WEST);
            // the most eastern, vertical line:
            new Wall(wallville, streetNumber, width, Direction.EAST);
            // the Thing at the end of the tunnel
            new Thing(wallville, streetNumber, width);

            int aveNum = left + 1;
            while (aveNum <= width)
            {
                new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
                new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
                ++aveNum;
            }

            ++streetNumber;
        }
    }
