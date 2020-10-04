import java.util.*;
import java.lang.Math;

public class PiSimulator {
	
	private int games;
	private int darts;
	private double radius = 0.5;
	
	public PiSimulator(int g, int d) {
		this.games = g;
		this.darts = d;
	}
	
	public double[] throwDarts() {
		
		int totalInCircle;
		
		double[] estimates = new double[games];
		
		for (int i = 0; i < games; i++) {
			
			totalInCircle = 0;
			
			for (int j = 0; j < darts; j++) {
				// generate random x and y coordinates
				double x = Math.random() - 0.5;
				double y = Math.random() - 0.5;

				double distance = Math.sqrt(x*x+y*y);
				
				if (distance <= this.radius) {
					totalInCircle++;
				}
				
				estimates[i] = (4 * ((double) totalInCircle / darts));
			}
			
		}
		
		return estimates;
	}
	
	public double calculateMean(double[] e) {
		double sum = 0.0;
		
		for(double est: e) {
			sum += est;
		}
			
		return sum/e.length;
	}
	

	public double calculateSTD(double[] e, double m) {
		double std = 0.0;
		for(double est: e) {
			std += (est - m) * (est - m);
		}
		
		return Math.sqrt(std/e.length);
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter desired number of games: ");
		int numGames = scan.nextInt();
		
		System.out.println("Enter desired number of darts: ");
		int numDarts = scan.nextInt();
		
		PiSimulator sim = new PiSimulator(numGames, numDarts);
		
		double[] estimatedValues = sim.throwDarts();

		// Calculate overall statistics
		double mean = sim.calculateMean(estimatedValues);

		System.out.println("-----------------------------------------------------------");
		System.out.println("Final estimate for pi: \t\t" + mean);
		System.out.println("Actual error: \t\t\t" + Math.abs(Math.PI - mean)/Math.PI);
		System.out.println("Standard deviation: \t\t" + sim.calculateSTD(estimatedValues, mean));
		System.out.println("-----------------------------------------------------------");
		
		scan.close();
	}
}

