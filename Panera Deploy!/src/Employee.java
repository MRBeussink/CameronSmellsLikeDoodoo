/* This class represents an employee
 * 
 */


public class Employee {
	
	private String name;
	private Time startTime;
	private Time endTime;
	
	//skills
	private boolean manager, prep, coordinator, dining, cashier, salad, sandwhich, consolidator,
		expiditer;
	

	public Employee(String name, Time start, Time end){
		this.name = name;
		this.startTime = start;
		this.endTime = end;
	}
	

}
