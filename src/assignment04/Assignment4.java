import java.util.Scanner;
import java.util.Random;

class Assignment4{
    public static void main(String[] args){
        System.out.print("Josh Johnson\n\n\n");

        System.out.print("Please enter the size of your desired Matrix: ");

        Random rand = new Random(/*0xABCDEFl*/);
        int size = 0, arr[][] = null;
        try(var scan = new Scanner(System.in)){
            size = scan.nextInt(10);
            arr = new int[size][size];
        }
        catch(Exception e){
            System.err.print("\n\n\nSomething went wrong\n\n\n");
            e.printStackTrace();
            System.exit(500);
        }

        for(int i = 0; i < arr.length; ++i)
            for(int j = 0; j < arr[i].length; ++j)
                arr[i][j] = rand.nextInt(2);

        int diagSum, maxRowSum[], maxColSum[], colSums[], rowSums[], count;
        colSums = new int[size];
        rowSums = new int[size];
        maxRowSum = new int[2];
        maxColSum = new int[2];
        diagSum = count = 0;

        System.out.print('\n');
        for(int i = 0; i < arr.length; ++i){
            System.out.print('\n');
            for(int j = 0; j < arr[i].length; ++j){
                System.out.print(arr[i][j]);
                colSums[j] += arr[i][j];
                rowSums[i] += arr[i][j];
                if(i == j) diagSum += arr[i][j];
                if(arr[i][j] == 0) count++;
            }
        }
        maxColSum = max(colSums);
        maxRowSum = max(rowSums);
        
        System.out.printf("\n\nFraction of 0s: %d/%d\nFraction of 1s: %d/%d\n", count, size * size, size * size - count, size * size);
        
        System.out.print("\nrow sums: ");
        for(int n : rowSums) System.out.printf("%d ", n);
        System.out.printf("\nLargest row sum: %d  at index %d\n", maxRowSum[0], maxRowSum[1]);
        System.out.print("\ncollumn sums: ");
        for(int n : colSums) System.out.printf("%d ", n);
        System.out.printf("\nLargest collumn sum: %d  at index %d\n\n", maxColSum[0], maxColSum[1]);

        if(maxRowSum[0] !=maxColSum[0]) System.out.print((maxRowSum[0] >maxColSum[0]) ? "rows win\n" : "columns win\n");
        else System.out.print("tie\n");

        if(diagSum > maxRowSum[0] && diagSum > maxColSum[0]) System.out.print("diagonals rule\n");
    }

    static int[] max(int[] arr){
        int temp[] = new int[2];
        temp[0] = arr[(temp[1] = 0)];
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] > temp[0]){
                temp[0] = arr[i];
                temp[1] = i;
            }
        }
        return temp;
    }
}