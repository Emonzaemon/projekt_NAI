package pl.edu.pjatk.s11718.Project_NAI;

public class Komiwojazer 
{
    public static void main( String[] args )
    {
    	
    	
    	City city = new City();
    	city.setCities_amount(20);
    	city.citiesCoord();
    	Child child = new Child();
    	
    	double[][] distance = city.distance();
    	int cities = city.getCities_amount();
    	
    	int[][] newPopulation;
    	
    	child.setChromosome_length(cities);
    	child.setParents_amount(2000);
    	int[][] population = child.startPopulation();
    	int[][] childs = child.crossover(distance, population);

    	int[] best = new int[child.getChromosome_length()];
    	int[] bestOfbest = new int[child.getChromosome_length()];
    	
    	bestOfbest = child.checkBest(distance, childs);
    	
    	for(int i = 0; i < 10000; i++){
    		newPopulation = child.mutation(childs);
    		childs = child.crossover(distance, newPopulation);
    		best = child.checkBest(distance, childs);
    		if((child.rate(best,distance) < child.rate(bestOfbest,distance))){
    			bestOfbest = best;
    		}
    	}
    	
    	
		System.out.println("");
		int c = child.getChromosome_length();
		for(int i = 0; i < c; i++){
    	System.out.print(bestOfbest[i]+ " ");
		}
		
		
		System.out.println("");
		System.out.println(child.rate(bestOfbest,distance));

    	

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
