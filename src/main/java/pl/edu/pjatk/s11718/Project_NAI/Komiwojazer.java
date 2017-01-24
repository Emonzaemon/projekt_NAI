package pl.edu.pjatk.s11718.Project_NAI;

public class Komiwojazer 
{
    public static void main( String[] args )
    {
    	
    	// ilość miast
    	City city = new City();
    	city.setCities_amount(5);
    	city.citiesCoord();
    	Child child = new Child();
    	
    	double[][] distance = city.distance();
    	int cities = city.getCities_amount();
    	
    	int[][] newPopulation;
    	
    	child.setChromosome_length(cities);
    	child.setParents_amount(10);
    	int[][] population = child.startPopulation();
    	int[][] childs = child.crossover(distance, population);
    	
    	
    	newPopulation = child.mutation(childs);
    	childs = child.crossover(distance, newPopulation);
    	child.checkBest(distance, childs);
    	
    //	for(int i = 0; i < 2; i++){
    //		newPopulation = child.mutation(distance, childs);
    //		childs = child.crossover(distance, newPopulation);
    //	}
    	
    	
		System.out.println("");
		int c = child.getChromosome_length();
		for(int i = 0; i < c; i++){
    	System.out.print(child.best[i]+ " ");
		}

    	

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
