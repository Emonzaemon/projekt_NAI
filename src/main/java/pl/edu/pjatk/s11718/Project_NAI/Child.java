package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Child extends Population{

	
	public void crossover(double[][] distance){
		
		
		int parent1;
		int parent2;
		int down;
		int up;
		int[][] population = startPopulation();
		int[][] childs = new int[parents_amount][chromosome_length];
		Tournament tournament = new Tournament(parents_amount, chromosome_length);
		int[][] winners = tournament.tournament(distance, population);
		
		
		Random rnd = ThreadLocalRandom.current();
		do{
		down = rnd.nextInt(parents_amount);
		up = rnd.nextInt(parents_amount);
		}while(down != up);
		
		
		for (int i = 0; i < parents_amount/2; i++){
			parent1 = winners[i][0];
			parent2 = winners[i][1];

			for(int j = down; j <= up; j++){
				childs[i][j] = population[parent1][j];
				childs[i+1][j] = population[parent2][j];
			}
			
			for(int j = up + 1; j < chromosome_length; j++){
				childs[i][j] = population[parent1][j];
				childs[i+1][j] = population[parent2][j];
				//zapisujemy miejsce w którym jesteśmy do zmiennej tymczasowej
				int tmp = j;
			    //sprawdzenie powtarzalnosci dla 3 sekcji dla 1 potomka
			    for (int l = down, k = 1; l < j; l++){
			    	if (childs[i][j] == childs[i][l]){
			    		//jeżeli wyjdzie za tablice, to ma wyzerować i lecieć od poczatku chromosomu
			    		if(tmp+k > chromosome_length){
			    			tmp = 0;
			    			k = 0;
			    		}
			    			childs[i][j] = population[parent1][tmp+k];
			    			l = down - 1;
			    			k++;
			        }      
			    }
			        //sprawdzenie powtarzalnosci dla 3 sekcji dla 2 potomka
			    for (int l = down, k = 1; l < j; l++){
			    	if (childs[i+1][j] == childs[i+1][l]){
			    		if(tmp+k > chromosome_length){
			    			tmp = 0;
			    			k = 0;
			    		}
			    			childs[i+1][j] = population[parent2][tmp+k];
			    			l = down - 1;
			    			k++;
			        }      
			    }
	        }
			//1 sekcja ze sprawdzeniem
			for(int j = 0, m, k = 1; j < down; j++){
	            m = population[parent1][j];
	            for(int l=0; l<chromosome_length; l++){
	               if (m == childs[i][j]){
	                   m = population[parent1][j+k];
	                   k++;
	                   l = -1;
	               }
	            }
	            childs[i][j] = m;
	            k=1;
	        }
	        for(int j = 0, m, k = 1; j < down; j++){
	            m = population[parent2][j];
	            for(int l=0; l<chromosome_length; l++){
	               if (m == childs[i+1][l]){
	                   m = population[parent2][j+k];
	                   k++;
	                   l = -1;
	               }
	            }
	            childs[i+1][j] = m;
	            k = 1;
	        }
		}
		
		for (int i = 0; i < parents_amount; i++){
			for (int j = 0; j < chromosome_length; j++){
				System.out.print(childs[i][j]+ " ");
			}
			System.out.println(" ");
		}
	}
}
