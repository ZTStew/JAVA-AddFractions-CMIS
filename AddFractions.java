/*
 * Program that adds two seperate fractions
 *
 * @author Stewart
 * @version JAVA 8, 7/3/2019
 */

import java.util.Scanner;

public class AddFractions{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Boolean flag = true;
        int num1 = 0;
        int denom1 = 0;
        int num2 = 0;
        int denom2 = 0;

        System.out.println("ENTER FRACTIONS IN X/Y FORMAT.\n");

        while(flag){
            /* prompts user for first fraction */
            System.out.print("Enter the first fraction: ");
            String fract1 = scan.next();
            /* checks to make sure fraction meets minimum requirements */
            if(fract1.length() > 2 && fract1.contains("/")){
                /* splits the string at the '/' in order to break string into intagers */
                String[] parts = fract1.split("/");
                String part1 = parts[0];
                String part2 = parts[1];
                /* tries to split the two parts into numerator and denominator */
                try {
                    num1 = Integer.parseInt(part1);
                    denom1 = Integer.parseInt(part2);
                    /* if this opperation creates no errors, 'flag' will be set to 'false' to exit the loop */
                    flag = false;
                    /* if there is an error (parseInt is used on a string) will produce error message and leave 'flag' as 'true' so the user is prompted for the fraction again */
                } catch(Exception e){
                    System.out.println("Error, Invalid data type detected. Please enter a valid fraction: x/y.");
                }
            /* if the 'if' check above (line 25) fails, gives user error message and leaves 'flag' as 'true' so the user is prompted for the fraction again */
            } else {
                System.out.println("Please enter a valid fraction: x/y");
            }
        }

        /* resets 'flag' to 'true' */
        flag = true;

        while(flag){
            /* prompts user for second fraction */
            System.out.print("Enter the second fraction: ");
            String fract2 = scan.next();
            /* checks to make sure fraction meets minimum requirements */
            if(fract2.length() >= 2 && fract2.contains("/")){
                /* splits the string at the '/' in order to break string into intagers */
                String[] parts = fract2.split("/");
                String part1 = parts[0];
                String part2 = parts[1];
                /* tries to split the two parts into numerator and denominator */
                try {
                    /* if this opperation creates no errors, 'flag' will be set to 'false' to exit the loop */
                    num2 = Integer.parseInt(part1);
                    denom2 = Integer.parseInt(part2);
                    flag = false;
                    /* if there is an error (parseInt is used on a string) will produce error message and leave 'flag' as 'true' so the user is prompted for the fraction again */
                } catch(Exception e){
                    System.out.println("Error, Invalid data type detected. Please enter a valid fraction: x/y.");
                }
            /* if the 'if' check above (line 25) fails, gives user error message and leaves 'flag' as 'true' so the user is prompted for the fraction again */
            } else {
                System.out.println("Please enter a valid fraction: x/y");
            }
        }

        /* prints the return of addFraction() */
        System.out.println(addFraction(num1, denom1, num2, denom2));
        scan.close();
    }

    /* creates method named 'addFraction'  */
    private static String addFraction(int num1, int denom1, int num2, int denom2){

        /* creates a variable named, 'aws' that will be returned at the end of the method */
        String aws = "" + num1 + "/" + denom1 + " + " + num2 + "/" + denom2 + " = ";

        /* checks if either denominator is 0 and returns an error if either are */
        if(denom1 == 0 || denom2 == 0){
            return aws += "Invalid Input";
        }

        /* checks if the denominator of either fraction is negative and flips it to the numorator */
        if(denom1 < 0){
            denom1 *= -1;
            num1 *= -1;
        } else if(denom2 < 0){
            denom2 *= -1;
            num2 *= -1;
        }

        /* if the denominators are not the same, multiplies the denominators and the numorators so they are the same value when adding */
        if(denom1 != denom2){
            num1 = num1 * denom2;
            num2 = num2 * denom1;
            denom1 = denom1 * denom2;
            denom2 = denom1;
        }

        /* adds the two numorators and adds the answer to 'aws' */
        aws += "" + (num1 + num2) + "/" + denom1;

        return aws;
    }
}
