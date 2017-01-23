package pl.edu.pjatk.s11718.Project_NAI;

public class Child extends Population{
	public Child(int parents_amount, int chromosome_length) {
		super(parents_amount, chromosome_length);
	}
	Tournament tournament = new Tournament(parents_amount, chromosome_length);
	
	
}
