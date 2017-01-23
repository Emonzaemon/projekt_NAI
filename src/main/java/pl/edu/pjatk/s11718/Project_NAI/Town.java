package pl.edu.pjatk.s11718.Project_NAI;

import java.util.Random;

public class Town {

	int cities_amount = 10;
	
	public Town(int cities_amount){
		this.cities_amount = cities_amount;
		
	}
	
	Random random = new Random();
	int[] cityX = new int[cities_amount];
	int[] cityY = new int[cities_amount];
	
	public void CitiesCoord(){
			
		for (int i = 0; i < cities_amount; i++){
			cityX[i] = random.nextInt(500)+1;
			cityY[i] = random.nextInt(500)+1;
		}
		for (int i = 0; i < cities_amount; i++){
			System.out.print(cityX[i]+" ");

		}
		System.out.println(" ");
		
		for (int i = 0; i < cities_amount; i++){

			System.out.print(cityY[i]+" ");

		}
	}	
	
	
	public void Distance(){
		double[][] distance = new double[cities_amount][cities_amount];
		
		for (int i = 0; i < cities_amount; i++){
			for (int j = 0; j < cities_amount; j++){
				distance[i][j] = Math.sqrt(Math.pow((cityX[j]-cityX[i]), 2) + Math.pow((cityY[j]-cityY[i]),2));
			}
		}
		System.out.println(" ");
		for (int i = 0; i < cities_amount; i++){
			for (int j = 0; j < cities_amount; j++){
				System.out.print(distance[i][j]+ " ");
			}
			System.out.println(" ");
		}
	}
}
