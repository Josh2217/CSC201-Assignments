import java.util.*;
import java.io.*;

class Assignment3{
    public static void main(String[] args) throws Exception{
        System.out.print("Josh Johnson\n");
        
        //Using a List<T> object we could gracfully handle an arbitrary amount of data; 
        //however, I know you're testing our array knowledge so I will do this as intended
        double sum = 0, mean, arr[] = new double[1000];

        Scanner scan = null;
        FileInputStream in = null;
        try{
            //the only reason I use the constructor of Scanner that takes an InputStream as a parameter is simply because InputStream extends the Closeable interface
            in = new FileInputStream("./ref/txt/A03input.txt");
            scan = new Scanner(in);

            for(int i = 0; scan.hasNextDouble(); ++i){
                arr[i] = scan.nextDouble();
                sum += arr[i];
            }
        }
        catch (FileNotFoundException e) {
            System.err.print("HEY, make sure that input1.txt exists and is in the right directory\n");
            System.exit(404);
        }
        catch (InputMismatchException e){
            System.err.print("Something is wrong in the input1.txt file, it isn't reading doubles\n");
            System.exit(418);
        }
        catch (Exception e){
            System.err.print("Mistakes were made\n\n\n");
            e.printStackTrace();
            System.exit(500);
        }
        finally{
            free(in, scan);
        }
        
        mean = sum / arr.length;
        System.out.printf("Mean: %.2f\n", mean);

        double standardDeviation, sumDiffSquared = 0;
        for(int i = 0; i < arr.length; ++i){
            double diff = arr[i] - mean;
            sumDiffSquared += diff * diff;
        }
        standardDeviation = Math.sqrt(sumDiffSquared / (arr.length - 1));
        System.out.printf("Standard Deviation: %.2f\n", standardDeviation);

        int smallCount, largeCount;
        smallCount = largeCount = 0;
        for(int i = 0; i < arr.length; ++i){
            if(i % 10 == 0) System.out.print('\n');
            char appendage = '=';
            if(arr[i] < mean){
                smallCount++;
                appendage = '<';
            }
            else if(arr[i] > mean){
                largeCount++;
                appendage = '>';
            }
            System.out.printf("  %4.1f %c  ", arr[i], appendage);
        }
        System.out.printf("\n\n%d values were greater than the mean and,\n%d values were less than the mean\n", largeCount, smallCount);
    }

    //I just wanted to try out VarArgs, Cool feature
    //throws IOException because IDE gets mad if I don't handle the exception somehow
    static void free(Closeable ...args) throws IOException{
        for(Closeable obj : args) if(obj != null) obj.close();
    }
}
