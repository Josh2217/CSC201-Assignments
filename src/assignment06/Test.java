import java.io.*;

public class Test {

    final static int TRIALS = 5;
    final static int MAX_SWITCHES = 20;
    public static void main(String[] grilled_mahi_mahi_over_a_creamy_marscapone_polenta_with_a_basil_pesto_garnished_with_lemon_dressed_arugala_and_sun_roasted_grape_tomatoes) {
        FileWriter fout = null;
        try{
            File file = new File("../../out/A06/stats.txt");
            //will try to create file if it doesn't exist
            if(file.createNewFile()) System.out.printf("%s created\n", file.getName());
            //will print to the console the location we are writing to
            System.out.printf("Writing to %s\n", file.getName());
            fout = new FileWriter(file, true);
        
            long avgs[] = new long[MAX_SWITCHES];
            for(int j = 1; j <= TRIALS; ++j) {
                fout.append(String.format("\nTrial %d\n=============================\n", j));
                for(int i = 1; i <= MAX_SWITCHES; ++i) {
                    long temp = Assignment06.run(i);
                    avgs[i - 1] += temp;
                    fout.append(String.format("%2d switches: %10d steps\n", i, temp));
                }
                
            }
            fout.append("\nAvgs:\n=============================\n");
            for(int i = 1; i <= MAX_SWITCHES; ++i) {
                fout.append(String.format("%2d switches: %10d steps\n", i, avgs[i - 1] / TRIALS));
            }
            fout.append("=============================\n").flush();
            fout.close();
        }
        catch(Exception e) {
            System.err.print("Something Went Wrong\n\n");
            e.printStackTrace();
            System.exit(500);
        }
    }
}
