import java.io.*;
import java.util.*;

class SuperHeroBattle {
    final static int TRIALS = 10;
    final static String OUTFILE_LOCATION = "../../out/A07/output.md";
    final static String INFILE_LOCATION = "../../ref/txt/SuperheroDataset.csv";

    static FileWriter fout;
    static File infile, outfile;
    static Scanner scan;
    static Random rand;
    static ArrayList<SuperHero> good_guys, bad_guys;

    public static void main(String[] Lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_Aliquam_porttitor_neque_id_tortor_interdum_non_viverra_nulla_pellentesque_Fusce_semper_sapien_libero_pulvinar_accumsan_justo_posuere_quis_Mauris_tristique_vulputate_nulla_et_tempus_purus_Suspendisse_ex_neque_consectetur_in_lorem_nec_condimentum_elementum_nisi_Nulla_eu_elementum_velit_Vestibulum_auctor_tortor_at_imperdiet_mattis_lectus_enim_posuere_nisi_non_pharetra_ante_massa_eget_odio_Fusce_quis_accumsan_purus_Suspendisse_vitae_nunc_felis_Aliquam_sed_odio_ut_ipsum_tincidunt_sollicitudin_eget_at_libero_Mauris_vitae_porta_elit_Fusce_maximus_odio_vitae_efficitur_tempus_arcu_quam_porttitor_turpis_in_maximus_magna_neque_a_eros_Nunc_orci_mauris_feugiat_quis_posuere_dignissim_posuere_eu_metus_Pellentesque_fermentum_posuere_purus_id_ultrices_purus_sagittis_dictum_Fusce_cursus_tortor_consequat_porta_lacus_a_sollicitudin_sapien_Aenean_ut_malesuada_dolor_et_pulvinar_velit_Ut_eget_volutpat_ligula) {
        rand = new Random();
        good_guys = new ArrayList<SuperHero>();
        bad_guys = new ArrayList<SuperHero>();
        init();
        load_heroes();
        try {
            write("# Joshua Johnson: Superhero Battles\n\n");
            int count = 0;
            for(int i = 0; i < TRIALS; ++i) {
                SuperHero good_guy = good_guys.get(rand.nextInt(good_guys.size()));
                SuperHero bad_guy = bad_guys.get(rand.nextInt(bad_guys.size()));
                int good_score = good_guy.getScore();
                int bad_score = bad_guy.getScore();

                String winner;
                if(good_score == bad_score) 
                    winner = rand.nextBoolean() ? good_guy.getName() : bad_guy.getName();
                else if (bad_score > good_score) 
                    winner = bad_guy.getName();
                else {
                    winner = good_guy.getName();
                    count++;
                }

                write(String.format("## Battle %d: **%s (%s) (%d)** vs. **%s (%s) (%d)**\n",
                    i + 1, 
                    good_guy.getName(), 
                    good_guy.getAlignment(),
                    good_score, 
                    bad_guy.getName(), 
                    bad_guy.getAlignment(),
                    bad_score
                ));
                write(String.format("<p align=\"center\">\n<strong>%s</strong> WINS\n</p>\n\n", winner));
            }
            write(String.format("<br/><br/><br/>\n\n# **In the end, Good Prevailed %d times**", count));
        }
        catch(Exception e) {
            System.err.print("error writing to file\n\n\n");
            e.printStackTrace();
            System.exit(500);
        }
        free(fout, scan);
    }

    //because I didn't want to write out Integer.parseInt() 6 times
    static int parse(String s) throws Exception {
        return Integer.parseInt(s);
    }

    static void write(String str) throws IOException {
        if(fout == null) return;
        else {
            fout.append(str).flush();
        }
    }

    static void load_heroes() {
        while(scan.hasNextLine()) {
            try {
                String[] stats = scan.nextLine().split(",");
                var temp = new SuperHero(stats[0], parse(stats[1]), parse(stats[2]), parse(stats[3]), parse(stats[4]), parse(stats[5]), parse(stats[6]), stats[7], stats[8]);

                if(temp.getAlignment().equals("good")) good_guys.add(temp);
                else if(temp.getAlignment().equals("bad")) bad_guys.add(temp);
                else if(rand.nextBoolean()) good_guys.add(temp);
                else bad_guys.add(temp);
            }
            //if the line is invalid, move on 
            catch (Exception e) {
                continue;
            }
        }
    }

    static void init() {
        try {
            infile = new File(INFILE_LOCATION);
            outfile = new File(OUTFILE_LOCATION);
            if(outfile.createNewFile()) System.out.printf("%s created\n", outfile.getName());
            //if the file already exists, clear it
            else new FileWriter(outfile, false).close();
            System.out.printf("Writing to %s\n", outfile.getName());
            fout = new FileWriter(outfile, true);
            scan = new Scanner(infile);
        }
        catch(FileNotFoundException e) {
            System.err.print("check file location\n\n\n");
            e.printStackTrace();
            System.exit(500);
        }
        catch(Exception e) {
            System.err.print("Something went wrong\n\n\n");
            e.printStackTrace();
            System.exit(500);
        }
    }

    static void free(Closeable ... args) {
        for(Closeable obj : args) {
            try {
                obj.close();
            }
            catch(Exception e) {
                System.err.print("Something terrible has gone wrong\n\n");
                e.printStackTrace();
                System.exit(500);
            }
        }
    }
}
