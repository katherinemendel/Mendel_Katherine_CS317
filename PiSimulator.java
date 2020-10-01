import java.util.*;
import java.lang.Math;

public class PiSimulator {
	
	private int games;
	private int darts;
	private int totalInCircle = 0;
	private ArrayList<Double> estimates = new ArrayList<Double>();
	private double radius = 0.5;
	
	public PiSimulator(int g, int d) {
		this.games = g;
		this.darts = d;
	}
	
	public int getTotalInCircle() {
		return totalInCircle;
	}
	
	public ArrayList<Double> getEstimates(){
		return estimates;
	}
	
	public void addEstimate(double e) {
		estimates.add(e);
	}
	
	public void throwDart() {
		
		// generate random x and y coordinates
		double x = Math.random() - 0.5;
		double y = Math.random() - 0.5;
		
		double distance = Math.sqrt(x*x+y*y);
		
		if (distance <= this.radius) {
			totalInCircle++;
		}
	}
	
	public double calculateMean(ArrayList<Double> e) {
		double sum = 0.0;
		
		for(double est: e) {
			sum += est;
		}
			
		return sum/e.size();
	}
	

	public double calculateSTD(ArrayList<Double> e, double m) {
		double std = 0.0;
		for(double est: e) {
			std += Math.pow((est - m), 2);
		}
		
		return Math.sqrt(std/e.size());
	}
	
	public void reset() {
		totalInCircle = 0;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter desired number of games: ");
		int numGames = scan.nextInt();
		
		System.out.println("Enter desired number of darts: ");
		int numDarts = scan.nextInt();
		
		PiSimulator sim = new PiSimulator(numGames, numDarts);
		
		
		double estimatedPi;

		// Loop for each game
		for(int i = sim.games; i >0; i--) {

			// Throw darts
			for(int j = sim.darts; j > 0; j--) {

				sim.throwDart();

			}
			// Estimate pi at end of game
			estimatedPi = 4 * ((double) sim.getTotalInCircle() / numDarts);
			sim.addEstimate(estimatedPi);
			sim.reset();
		}
		
		// Calculate overall statistics
		double mean = sim.calculateMean(sim.getEstimates());

		System.out.println("Final estimate for pi: " + mean);
		System.out.println("Actual error: " + Math.abs(Math.PI - mean)/Math.PI);
		System.out.println("standard deviation: " + sim.calculateSTD(sim.getEstimates(), mean));
		
		scan.close();
	}
}
