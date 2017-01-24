package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Population {
	
	protected int parents_amount;
	protected int chromosome_length;
	
	public Population(int parents_amount, int chromosome_length){
		this.parents_amount = parents_amount;
		this.chromosome_length = chromosome_length;
	}
	
	public int[][] startPopulation(){
		int[][] startPopulation = new int[chromosome_length][parents_amount];
		for (int i = 0; i < parents_amount; i++){
			int[] parent = parent();
			for (int j = 0; j < chromosome_length; j++){
				startPopulation[i][j] = parent[j];
			}
		}
		for (int i = 0; i < parents_amount; i++){
			for (int j = 0; j < chromosome_length; j++){
				System.out.print(startPopulation[i][j]+ " ");
			}
			System.out.println(" ");
		}
		return startPopulation;
	}
	
	public int[] parent(){
		int[] parent = new int[chromosome_length];
		for (int i = 0; i < chromosome_length; i++) {
			parent[i] = i;
		}
		parent = shuffleArray(parent);
		
		for (int i = 0; i < chromosome_length; i++){
			System.out.print(parent[i]+" ");
		}
		System.out.println(" ");
		return parent;
	}
	
	public int[] shuffleArray(int[] array){
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = array.length - 1; i > 0; i--) {
	    	int index = rnd.nextInt(i + 1);
	    	// Simple swap
	    	int a = array[index];
	    	array[index] = array[i];
	    	array[i] = a;
	    }
	    return array;
	}
	
	public double rate(int rand, int array[][], double distance[][]){
		double sum = 0;
		for(int i = 0; i < chromosome_length-1; i++){
			int city1 = array[rand][i];
			int city2 = array[rand][i+1];
			sum += distance[city1][city2];
		}
		sum += distance[array.length][0];
		return sum;
	}
	
	
	public void child(){
		
	}
	
	public void crossover(){
		
	}
	
	
}
