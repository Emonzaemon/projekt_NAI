package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Population {

	int parents_amount = 10;
	
	public void Parent(){
		
		int[] parent = new int[parents_amount];
		
		for (int i = 0; i < parents_amount; i++) {
			parent[i] = i;
		}
		parent = shuffleArray(parent);
		
		for (int i = 0; i < parents_amount; i++){

			System.out.print(parent[i]+" ");

		}
	}
	
	public int[] shuffleArray(int[] array)
	{
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
	
}
