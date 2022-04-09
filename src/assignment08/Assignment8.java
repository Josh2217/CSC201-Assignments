import java.util.*;

class Assignment8 {
	//This reminds me of my Hello World method from last semester
	public static void main(String[] args) {
		System.out.print("Josh Johnson\n\n\n");

		Scanner scan = new Scanner(System.in);
		String target = null;
		int thread_count = 0;
		while(true) {
			System.out.print("Input your target: ");
			target = scan.next().toUpperCase();
			if(!target.matches("[A-Z]+")) {
				System.out.print("Please only use charset a-z and A-Z\n");
				continue;
			}
			System.out.print("This program is Multi-Threaded\nHow many threads would you like: ");	
			if(!scan.hasNextInt()) {
				System.out.print("Please enter an integer\n");
				continue;
			}
			thread_count = scan.nextInt();
			break;
		}

		for(int i = 1; i <= thread_count; ++i){
			var thread = new TotallyNecessaryThread(target, i);
			thread.start();
		}
	}
}

class TotallyNecessaryThread extends Thread {
	int thread_num;
	private String target;
	private static final char ALPHA[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private Random rand = new Random();

	TotallyNecessaryThread(String t, int n){
		thread_num = n;
		target = t;
	}

	@Override
	public void run() {
		System.out.printf("[Thread %2d] Running\n", thread_num);
		int count = 0;
		for(;;count++) {
			var guess = new StringBuilder();
			for(int i = 0; i < target.length(); ++i) guess.append(ALPHA[rand.nextInt(ALPHA.length)]);
			// /*
			System.out.printf("[Thread %2d] Guess: %s\tScore:%d\n",
					thread_num,
					guess.toString(),
					cmp(guess));
			// */
			if(cmp(guess) == 0) {
				System.out.printf("[Thread %2d] SOLUTION FOUND: %s in %d loops\n",
						thread_num,
						guess.toString(),
						count);
				System.exit(0); // this will terminate the program along with all running threads
			}
		}
				
	}

	private int cmp(StringBuilder guess){
		if(guess.length() < target.length()) return -1;
		int score = 0;
		for(int i = 0; i < guess.length(); ++i){
			score += abs((int)guess.charAt(i) - (int)target.charAt(i));	
		}
		return score;
	}

	private int abs(int a) {
		return a < 0 ? -a : a;
	}
}
