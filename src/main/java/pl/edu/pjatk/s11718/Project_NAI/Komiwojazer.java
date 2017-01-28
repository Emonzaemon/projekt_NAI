package pl.edu.pjatk.s11718.Project_NAI;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Komiwojazer 
{
    public static void main( String[] args )
    {
    	double[][] distance = null;
    	int[][] newPopulation;
    	int[][] population;
    	int[][] childs;
    	int[][] cityXY;
    	int[] best;
    	int[] bestOfbest;
    	int cities = 0;
    	int parents;
    	Scanner in = new Scanner(System.in);
    	System.out.println("Rozwiazanie problemu komiwojazera v1.0 \n");
    	while(true){
    		
    	
	    	// inicjalizacja obiektu City 
	    	City city = new City();
	    	ReadFile read = new ReadFile();
	    	
	    	//inicjalizacja glownego obiekty klasy Child, na ktorej beda wykonywane operacje
	    	Child child = new Child();
	    	System.out.println("------------------------------------");
	    	System.out.println("Wybierz opcje" );
			System.out.println("1. Generuj wsporzedne miast" );
			System.out.println("2. Wczytaj wspolrzedne z pliku" );
			
			try {
				
				cityXY = read.read();
		    	cities = read.size;
		    	cities = cities/2;
				city.setCities_amount(cities);
				distance = city.distance(cityXY);
			
			} catch (FileNotFoundException e) {

				System.out.println("Blad wczytania pliku. Awaryjne zamkniecie programu." );
				System.exit(-1);
			}
	    	
	    	
	    	//wczytanie wielkosci populacji z klawiatury
	    	System.out.println("Podaj wielkosc populacji" );
	    	parents = in.nextInt();
	    	
	    	System.out.println("Podaj ilosc iteracji" );
	    	int iteration = in.nextInt();
	    	

	    	
	    	//dlugosc chromosomu rowna sie dlugosci miast, Komiwojazer musi odwiedzic kazde miasto
	    	child.setChromosome_length(cities);
	    	
	    	//ustawienie wielkosci populacji
	    	child.setParents_amount(parents);
	    	
	    	//wygenerowanie poczatkowej populacji
	    	population = child.startPopulation();
	    	
	    	//krzyzowanie populacji poczatkowej, wynikiem jest tablica potomkow, czyli pelnej nowej populacji
	    	childs = child.crossover(distance, population);
	
	    	//inicjalizacja tablic, ktore beda przechowywac najlepsze rozwiazanie
	    	best = new int[child.getChromosome_length()];
	    	bestOfbest = new int[child.getChromosome_length()];
	    	
	    	//ustawienie kontrolnego najlepszego wyniku na podstawie obecnej populacji potomkow
	    	bestOfbest = child.checkBest(distance, childs);
	    	
	    	
	    	//petla krzyzowania sie populacji
	    	for(int i = 0; i < iteration; i++){
	    		//mutowanie potomkow, czyli aktualnej populacji
	    		newPopulation = child.mutation(childs);
	    		//krzyzowanie populacji po mutacji i zapisanie do zmiennej
	    		childs = child.crossover(distance, newPopulation);
	    		//ustalenie najlepszego rozwiazania z danej iteracji
	    		best = child.checkBest(distance, childs);
	    		//sprawdzenie czy obecny wynik jest najlepszy i zapisanie go
	    		if((child.rate(best,distance) < child.rate(bestOfbest,distance))){
	    			bestOfbest = best;
	    		}
	    	}
	    	System.out.println("------------------------------------");
	    	//wypisanie chromosomu najlepszego rozwiazania
			System.out.println("Najwydajniejszy ciag miast, jaki udalo sie otrzymac: ");
			int c = child.getChromosome_length();
			for(int i = 0; i < c; i++){
	    	System.out.print(bestOfbest[i]+ " ");
			}
	
			//wypisanie wartosci najlepszego rozwiazania
			System.out.println("\nWartosc najlepszego rozwiazania: ");
			System.out.format("%.2f%n", child.rate(bestOfbest,distance));
	
			System.out.println("Uruchomić ponownie? (t)" );
	    	String again = in.next();
	
	    	switch(again){
	    		case "t": break;
	    		default: {
	    			in.close();
	    			System.exit(0);
	    		}
	    	}
    	}
    }
}
