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
    	
    	child.setChromosome_length(5);
    	child.setParents_amount(city.getCities_amount());
    	child.crossover(distance);
    	
    	
    	
    	
    	//city.distance();
    	
    //	parent.parent();
    //	System.out.println(" ");
    //	parent.parent();
    //	System.out.println(" ");
    //	parent.parent();
    	
    	
    	

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
