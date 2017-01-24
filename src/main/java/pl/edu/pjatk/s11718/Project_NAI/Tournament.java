package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tournament extends Population{
	
	public Tournament(int parents_amount, int chromosome_length) {
		this.parents_amount = parents_amount;
		this.chromosome_length = chromosome_length;
	}

	public int[][] tournament(double distance[][], int population[][]){

		int parent1;
		int parent2;
		int[][] winners = new int[parents_amount/2][2];
		
		for (int i = 0; i < parents_amount/2; i++){
			parent1 = fight(population, distance);
			parent2 = fight(population, distance);
			winners[i][0] = parent1;
			winners[i][1] = parent2;	
		}
		return winners;
	}
	
	public int fight(int population[][], double distance[][]){
		Random rnd = ThreadLocalRandom.current();
		
		int rand1 = rnd.nextInt(parents_amount);
		int rand2 = rnd.nextInt(parents_amount);

		if(rate(rand1, population, distance)>rate(rand2, population, distance)){
			return rand1;
		} else {
			return rand2;
		}
	}

}
