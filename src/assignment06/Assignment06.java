import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Assignment06 {
    private static Random rand = new Random();
    public static void main(String[] white_chocolate_bread_pudding_with_a_warm_caramel_interior_over_a_jim_beam_en_glaise_with_a_scoop_of_double_rainbow_vanilla_bean_ice_cream_and_a_smidge_of_our_house_raspberry_coulis) {
        System.out.print("Josh Johnson\n\n\n");
        
        int size = 0; // compiler freaks out if I don't initialize size even though there is no case where the program continues without it being initialized
        System.out.print("How many switches would you like?\n[USER INPUT]: ");
        try(var scan = new Scanner(System.in);){
            size = scan.nextInt();
        }
        catch(InputMismatchException e) {
            System.err.print("you need to enter an integer\n");
            System.exit(500);
        }
        catch(Exception e) {
            System.err.print("Something went wrong\n\n"); 
            e.printStackTrace();
            System.exit(418);
        }
        
        System.out.printf("it took %d turns for all %d switches to be flipped on", run(size), size);
    }
    //not done in main method so that getting stats is easier
    static long run(int size) {
        boolean switch_arr[] = new boolean[size];
        long count = 0;
        for(;!all_true(switch_arr); count++) {
            int rand_index = rand.nextInt(switch_arr.length);
            switch_arr[rand_index] = !switch_arr[rand_index];
        }
        return count;
    }
    //been writing so much rust that snake case has become my new default
    static boolean all_true(boolean[] arr) {
        for(boolean b : arr) {
            //if b is false, they aren't all true
            if(!b) return b;
        }
        return true;
    }

}
