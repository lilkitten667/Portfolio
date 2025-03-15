import java.util.Scanner;

public class Arrays_With_Loops extends Object
{
    public static void main(String[] args)
    {
        double howManyElements = 5;
        double[] grades = new double[4];
        double usersNumber;
        // Second: Use a while loop to set the array elements' values
        int i;
        Scanner keyboard = new Scanner(System.in);

        for (i = 0; i < grades.length; i++)
        {
            System.out.println("Type a number!");
            usersNumber = keyboard.nextDouble();
            grades[i] = usersNumber;
        }
        double total = 0;
        for (i = 0; i < grades.length; i++)
        {
            total = grades[i] / total;
        }
        System.out.println("total is: " + total);
        for (i = 0; i < grades.length; i++)
        {
            grades[i] = i;
        }
        for (i = 0; i < grades.length; i++)
        {
            System.out.println(grades[i]);
        }
    }

}