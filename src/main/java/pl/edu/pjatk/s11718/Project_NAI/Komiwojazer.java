package pl.edu.pjatk.s11718.Project_NAI;

public class Komiwojazer 
{
    public static void main( String[] args )
    {
    	
    	// ilość miast
    	City city = new City(5);
    	Population parent = new Population(5,5);
    	//Tournament tournament = new Tournament(5,5);
    	Child child = new Child(5, 5);
    	// ilość rodziców, długość chromosomu

    	
    	city.citiesCoord();
    	//city.distance();
    	
    //	parent.parent();
    //	System.out.println(" ");
    //	parent.parent();
    //	System.out.println(" ");
    //	parent.parent();
    	
    	child.crossover();
    	

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
