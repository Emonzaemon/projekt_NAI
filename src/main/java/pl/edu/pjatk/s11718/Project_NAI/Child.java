package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Child extends Population{

	int[] best;
	
	public int[][] crossover(double[][] distance, int [][]population){
		
		
		int parent1;
		int parent2;
		int down;
		int up;
		int[][] childs = new int[parents_amount][chromosome_length];
		Tournament tournament = new Tournament(parents_amount, chromosome_length);
		int[][] winners = tournament.tournament(distance, population);
		
		
		
		// dodatkowa zmienna dla potomów "c", która przeskakuje co dwa, aby się potomkowie nie nadpisywali w kolejnych przebiegach. kek.
		for (int i = 0, c = 0; i < parents_amount/2; i++, c+=2){
			
			Random rnd = ThreadLocalRandom.current();
			do{
			down = rnd.nextInt(chromosome_length);
			up = rnd.nextInt(chromosome_length);
			}while(down == up);
			
			if(down>up){
				int tmp = up;
				up = down;
				down = tmp;
			}
			
			//przypisanie numeru rodzica z tablicy zwycięzców turnieju 
			parent1 = winners[i][0];
			parent2 = winners[i][1];
			
			//Przepisanie zamiennie środka rodzica do potomka
			for(int j = down; j <= up; j++){
				childs[c][j] = population[parent1][j];
				childs[c+1][j] = population[parent2][j];
			}
			
			for(int j = up + 1; j < chromosome_length; j++){
				childs[c][j] = population[parent2][j];
				childs[c+1][j] = population[parent1][j];
				//zapisujemy miejsce w którym jesteśmy do zmiennej tymczasowej
				int tmp = j;
			    //sprawdzenie powtarzalnosci dla 3 sekcji dla 1 potomka
			    for (int l = down, k = 1; l < j; l++){
			    	if (childs[c][j] == childs[c][l]){
			    		//jeżeli wyjdzie za tablice, to ma wyzerować i lecieć od poczatku chromosomu
			    		if(tmp+k > chromosome_length-1){
			    			tmp = 0;
			    			k = 0;
			    		}
			    			childs[c][j] = population[parent1][tmp+k];
			    			l = down - 1;
			    			k++;
			        }      
			    }
			        //sprawdzenie powtarzalnosci dla 3 sekcji dla 2 potomka
			    for (int l = 0, k = 1; l < j; l++){
			    	if (childs[c+1][j] == childs[c+1][l]){
			    		if(tmp+k > chromosome_length-1){
			    			tmp = 0;
			    			k = 0;
			    		}
			    			childs[c+1][j] = population[parent2][tmp+k];
			    			l =  -1;
			    			k++;
			        }      
			    }
	        }
			//1 sekcja ze sprawdzeniem
			for(int j = 0, m, k = 1; j < down; j++){
	            m = population[parent1][j];
	            int tmp = j;
	            for(int l=0; l<chromosome_length-1; l++){
	               if (m == childs[c][l]){
	            	   if(tmp+k > chromosome_length-1){
			    			tmp = 0;
			    			k = 0;
	            	   }
			    			m = population[parent1][tmp+k];
			    			k++;
			    			l = -1;
	               }   	
	            }
	            childs[c][j] = m;
	            k=1;
	        }
	        for(int j = 0, m, k = 1; j < down; j++){
	            m = population[parent2][j];
	            int tmp = j;
	            for(int l=0; l<chromosome_length-1; l++){
	               if (m == childs[c+1][l]){
	            	   if(tmp+k > chromosome_length-1){
			    			tmp = 0;
			    			k = 0;
	            	   }
	                   m = population[parent2][tmp+k];
	                   k++;
	                   l = -1;
	               }
	            }
	            childs[c+1][j] = m;
	            k = 1;
	        }
		}
		
		
		
		for (int i = 0; i < parents_amount; i++){
			for (int j = 0; j < chromosome_length; j++){
				System.out.print(childs[i][j]+ " ");
			}
			System.out.println(" ");
		}
		return childs;
	}
	
	public int[][] mutation(int[][] childs){
		best = new int[chromosome_length];
		Random rnd = ThreadLocalRandom.current();
		int mutationIndex1 = rnd.nextInt(chromosome_length);
		int mutationIndex2 = rnd.nextInt(chromosome_length);
		int mutationProbability = rnd.nextInt(1000)+1;
		
		for(int i = 0; i < parents_amount; i++){
			if(mutationProbability < 10){
			do{
			mutationIndex1 = rnd.nextInt(chromosome_length);
			mutationIndex2 = rnd.nextInt(chromosome_length);
			}while(mutationIndex1 == mutationIndex2);
			
			childs[i][mutationIndex1] = childs[i][mutationIndex2];
			}
			
		}
		
		
		return childs;
	}
	
	public int[] checkBest(double[][] distance, int[][]childs){
		for(int i = 0; i < parents_amount; i++){
			if(rate( i, childs, distance)>rate(best,distance)){
				for(int j = 0; j < chromosome_length; j++){
					best[j] = childs[i][j];
				}
			}
		}
		return best;
	}
	
}
