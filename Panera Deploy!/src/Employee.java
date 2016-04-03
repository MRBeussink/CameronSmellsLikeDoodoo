/* This class represents an employee
 * 
 */


public class Employee {
	
	private String name;

	public enum Skill {
		manager, prep, cordinator, dining, dishes, cashier, salad,
		sandwhich, consolidator, expiditer
	}

	private Skill[] skillSet;

	public Employee(String name, int numOfSkills, LinkedList.Node firstSkill){
		this.name = name;
		skillSet = new Skill[numOfSkills];

		for (int i = 0; i < numOfSkills; i++){

		}
	}

	

}
