import java.util.Scanner;

/*
 * The PrintHelper class has the methods for printing various shapes
 */
class PrintHelper
{
    // Your methods to print various shapes goes here
    Scanner keyboard = new Scanner(System.in);
    int userInput;

    public void printStars(int width)
    {

        System.out.println("Stars:");
        int whichCol = 0;
        while (whichCol < width)
        {
            System.out.print("*");

            ++whichCol;
        }
        // Print just a new-line character
        System.out.println("");

    }

    public void printRectangle(int width, int height)
    {
        System.out.println("Rectangle:");
        // TODO: Change this method's incomplete code to use nested for-loops
        int whichRow = 0;
        int whichCol = 0;

        for (whichRow = 0; whichRow < height; whichRow++)
        {
            System.out.println();
            for (whichCol = 0; whichCol < width; whichCol++)
            {
                System.out.print("*");
            }

        }

        // Print just a new-line character
        System.out.println("");
    }

    // TODO: Add more methods for printing shapes here:
    public void printRectangleHollow(int width, int height)
    {
        System.out.println("Hollow Rectangle:");
        // TODO: Change this method's incomplete code to use nested for-loops
        int whichRow = 0;
        int whichCol = 0;

        for (whichRow = 0; whichRow < height; whichRow++)
        {
            for (whichCol = 0; whichCol < width; whichCol++)
            {

                if (whichRow == 0 || whichRow == height - 1 || whichCol == 0 || whichCol == width - 1)
                {
                    System.out.print("*");
                } else
                {

                    System.out.print(" ");
                }

            }
            System.out.println("");

        }

        // Print just a new-line character /* whichRow = to 4 being the length of the
        // row... j = 5 set to the length of the colum*/

    }

    public void printLeftTriangle(int height)
    {
        System.out.println("Left Triangle");
        int whichRow = 0;
        int whichCol = 0;
        for (whichRow = height; whichRow > 0; whichRow--)
        {
            for (whichCol = 0; whichCol < whichRow; whichCol++)
            {
                System.out.print("*");

            }

            System.out.println("");
        }
    }

    public int getInput()
    {

        /*
         * this would need a return int, I want a while loop to checks to see if user
         * has typed an int, if false keep asking until a real number is typed up
         */

        userInput = keyboard.nextInt();
        if (userInput >= 0) // should i then say while not done, and do if / else statement?
        {
            System.out.print(userInput + "\n: ");
            keyboard.nextLine();
        } else
        {
            System.out.print("Please chose a whole number: " + userInput + "is not a whole number");
            keyboard.nextLine();
        }

        return userInput;

    }
}

public class PrintingShapes extends Object
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int userInput = 0;
        int starCount;
        int rectWidth;
        int rectHeight;
        int hRectWidth;
        int hRectHeight;
        int invLTriangle;
        // TODO: You will also add more code to this main method
        PrintHelper printer = new PrintHelper();

        System.out.println("Hello! How many stars would you like me to print? ");
        System.out.println("Stars: ");
        starCount = keyboard.nextInt();
        printer.printStars(starCount);

        System.out.println("For a rectangle, how wide should it be? ");
        rectWidth = keyboard.nextInt();
        System.out.println("For a rectangle, how high should it be? ");
        rectHeight = keyboard.nextInt();
        printer.printRectangle(rectWidth, rectHeight);

        System.out.println("For a hollow rectangle, how wide should it be? ");
        hRectWidth = keyboard.nextInt();
        System.out.println("For a hollow rectangle, how high should it be? ");
        hRectHeight = keyboard.nextInt();
        printer.printRectangleHollow(hRectWidth, hRectHeight);

        System.out.println("For an inverted left triangle, how wide should it be? ");
        invLTriangle = keyboard.nextInt();
        printer.printLeftTriangle(invLTriangle);

        printer.printStars(7);
        printer.printRectangle(5, 3);
        printer.printRectangleHollow(4, 5);
        printer.printRectangleHollow(2, 2);
        printer.printRectangleHollow(5, 1);
        printer.printLeftTriangle(5);
        printer.printLeftTriangle(3);
        printer.printLeftTriangle(2);
        keyboard.close();
    }
}
