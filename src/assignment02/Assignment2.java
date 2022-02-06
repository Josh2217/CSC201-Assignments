//#include <stdio.h>
//I swear I didn't do that intentionally it was just instinct
//I'm leaving it in because it's funny

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

class Assignment2{
    public static void main(String args[]){
        System.out.printf("%s\nJosh Johnson\n%s\n\n", "=".repeat(12), "=".repeat(12));

        //this is checking the passed in arguments for whether or not to run this in verbose mode
        boolean verbose = Arrays.stream(args).anyMatch(s -> s.matches("(\\/[v|V]|-[a-z|A-Z]*[v|V])"));
        //the regex checks for /v or - followed by any number of other options but ultimately including v i.e. -rfv (case insensative)

        int a, b, c, i;//this 'i' is for a "for loop" in the future
        a = b = c = i = 0;//it gets mad at me if I don't initialize them;
        System.out.print("Input three integers seperated by whitespace: ");


        try(Scanner scan = new Scanner(System.in)) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
        } 
        //I know you said we didn't need error handling, but I'm doing it anyways
        catch(InputMismatchException e){
            System.err.print("You need to input 3 INTEGERS seperated by whitespace\n\n");
            if(verbose) e.printStackTrace();
            System.exit(400);//http error 400: bad request
            //you should read up on http error 418, very funny one
        }
        catch(Exception e) {
            System.err.print("Something went wrong\n\n");
            if(verbose) e.printStackTrace();
            System.exit(500);
        }
        
        //Now for the actual important part of the assignment
        int sum = a + b + c;
        double avg = sum / 3d;
        int product = a * b * c;

        System.out.printf("\ntheir average is %.2f\ntheir sum is %d\ntheir product is %d\n\n", avg, sum, product);

        System.out.print((a > b) ? "#1 is greater than #2\n" : "#2 is greater than or equal to #1\n");
        System.out.print((a + b >= c) ? "sum wins!\n" : "#3 is hefty hefty hefty\n");
        /*
         * Explanation of my favourite way to test parity:
         * 
         *  0b1011 = 11 (an odd number)
         *  0b0001 = 1
         * &______
         *  0b0001 = 1 (true)
         * 
         *  0b1010 = 10 (an even number)
         *  0b0001 = 1
         * &______
         *  0b0000 = 0 (false)
         */
        //if java was more like pretty much every other language, I wouldn't even have to put the == 1, because 1 is just a truthy value, and 0 is falsey
        System.out.print( ((a & b & c & 1) == 1) ? "how odd\n" : "lucky ducky\n" );

        System.out.print("\n\nNow to prove I haven't forgotten how to use for loops:\n\n");

        /* this is what I (Sh & W)ould do

        for(int i = 1; i <= 5; i++) System.out.println(i);

        But... I Could do something funnier*/

        for(;i < 5;) System.out.println(++i);

        System.out.print("\nIt's good to be back");
    }
}
