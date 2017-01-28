package pl.edu.pjatk.s11718.Project_NAI;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class City {

	 int cities_amount;
	// int[] cityX;
	// int[] cityY;
	int size;
	
	public int getCities_amount() {
		return cities_amount;
	}

	public int getSize() {
		return size;
	}
	
	public void setCities_amount(int cities_amount) {
		this.cities_amount = cities_amount;
	}
	
	//metoda ustawiajaca wspolrzedne miast na ukladzie 500 x 500
	/*public void citiesCoord(){
		Random random = ThreadLocalRandom.current();
		cityX = new int[cities_amount];
		cityY = new int[cities_amount];
			
		for (int i = 0; i < cities_amount; i++){
			cityX[i] = random.nextInt(500)+1;
			cityY[i] = random.nextInt(500)+1;
		}
		/*	for (int i = 0; i < cities_amount; i++){
			System.out.print(cityX[i]+" ");

		}
		System.out.println(" ");
		
		for (int i = 0; i < cities_amount; i++){
			System.out.print(cityY[i]+" ");
		}
		
	}	*/
	//metoda zwracajaca macierz odleglosci miedzy miastami
	public double[][] distance(int[][] cityXY) throws FileNotFoundException{

		double[][] distance = new double[cities_amount][cities_amount];
		
		for (int i = 0; i < cities_amount; i++){
			for (int j = 0; j < cities_amount; j++){
				distance[i][j] = Math.sqrt(Math.pow((cityXY[i][0]-cityXY[j][0]), 2) + Math.pow((cityXY[i][1]-cityXY[j][1]),2));
			}
		}
	/*	System.out.println(" ");
		for (int i = 0; i < cities_amount; i++){
			for (int j = 0; j < cities_amount; j++){
				System.out.print(distance[i][j]+ " ");
			}
			System.out.println(" ");
		}*/
		return distance;
	}
}
