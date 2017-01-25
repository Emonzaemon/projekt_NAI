package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Population {
	
	 int chromosome_length;
	 int parents_amount;
	
	public int getParents_amount() {
		return parents_amount;
	}

	public void setParents_amount(int parents_amount) {
		this.parents_amount = parents_amount;
	}

	public int getChromosome_length() {
		return chromosome_length;
	}

	public void setChromosome_length(int chromosome_length) {
		this.chromosome_length = chromosome_length;
	}

	

	//generowanie startowej populacji
	public int[][] startPopulation(){
		int[][] startPopulation = new int[parents_amount][chromosome_length];
		for (int i = 0; i < parents_amount; i++){
			int[] parent = parent();
			for (int j = 0; j < chromosome_length; j++){
				startPopulation[i][j] = parent[j];
			}
		}
	/*	for (int i = 0; i < parents_amount; i++){
			for (int j = 0; j < chromosome_length; j++){
				System.out.print(startPopulation[i][j]+ " ");
			}
			System.out.println(" ");
		} */
		return startPopulation;
	}
	
	//generowanie pojedynczego chromosomu (rodzica)
	public int[] parent(){
		int[] parent = new int[chromosome_length];
		for (int i = 0; i < chromosome_length; i++) {
			parent[i] = i;
		}
		parent = shuffleArray(parent);

		return parent;
	}
	
	//przemieszanie chromosomu rodzica poprzez proste zamiany miejscami
	public int[] shuffleArray(int[] array){
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = array.length - 1; i > 0; i--) {
	    	int index = rnd.nextInt(i + 1);
	    	int a = array[index];
	    	array[index] = array[i];
	    	array[i] = a;
	    }
	    return array;
	}
	
	//metoda zwracajaca wartosc odleglosci pomiedzy kolejnymi miastami 
	//w chromosomie z tablicy calej populacji
	public double rate(int index, int array[][], double distance[][]){
		double sum = 0;
		for(int i = 0; i < chromosome_length-1; i++){
			int city1 = array[index][i];
			int city2 = array[index][i+1];
			sum += distance[city1][city2];
		}
		//dodawanie odlegosci miedzy ostatnim a pierwszym miastem. Komiwojazer wraca do punkty wyjscia
		sum += distance[chromosome_length-1][0];
		return sum;
	}
	
	//przeciazona metoda zwracajaca wartosc odleglosci z pojedynczego chromosomu
	public double rate(int array[], double distance[][]){
		double sum = 0;
		for(int i = 0; i < chromosome_length-1; i++){
			int city1 = array[i];
			int city2 = array[i+1];
			sum += distance[city1][city2];
		}
		//dodawanie odlegosci miedzy ostatnim a pierwszym miastem. Komiwojazer wraca do punkty wyjscia
		sum += distance[chromosome_length-1][0];
		return sum;
	}
}
