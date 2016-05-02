
/**
 * Created by Mark on 4/10/16.
 */
 
public class Position implements Comparable<Position> {
    private double row, col, page;     //these variables are for the deployment spreadsheets
    private boolean priority;       //if a position MUST be filled, this should be true

    private Employee employee;      //the employee who fills this position
    private EmployeeSkill skill;    //the necessary skill to match

    //here if we need them, could use them to sort priority
    //private Time startTime;
    //private Time endTime;

    private Time expiration;        //the time which this position is no longer considerable

    private Position carryOverPosition;

    public Position(EmployeeSkill skill, boolean priority, double page, double row, double col){
        this.row = row;
        this.col = col;
        this.page = page;
        this.priority = priority;
        this.skill = skill;
    }
    public Position(String skill, boolean priority, double page, double row, double col){
    	this(new EmployeeSkill(skill), priority, page, row, col);
    }

    public EmployeeSkill getSkill(){
        return this.skill;
    }

    public double getRow(){
        return this.row;
    }

    public double getCol(){
        return this.col;
    }

    public double getPage(){
        return this.page;
    }

    public boolean hasPriority(){
        return this.priority;
    }

    public String getEmployeeName(){
        return this.employee.getName();
    }

    public Time getEmployeeStartTIme(){
        return this.getEmployeeStartTIme();
    }

    public Time getEmployeeEndTime(){
        return this.employee.getEndTime();
    }

    public boolean assignEmployee(Employee employee){
        if (employee != null && this.employee == null){
            this.employee = employee;
            return true;
        }
        else
            return false;

    }

    public Employee changeEmployee(Employee newEmployee){
        if (this.employee != null && newEmployee != null && !this.employee.equals(newEmployee)){
            Employee result = this.employee;
            this.employee.changedPosition();
            this.employee = newEmployee;
            return result;
        }
        else
            return null;
    }

    /**Returns a numberical representation of the order in which a position must be
     * filled with "special cases" being the zeroth place and then 1st, 2nd, and 3rd
     * in terms of which shift/page on final Deployment Sheet.
     *
     * Uses a sentinel value of 5
     *
     * @return an int from 0 to 3, if it is 5, then something went wrong
     */
    public double getOrderOfImport(){
        double result = 5;

        /* HEY CAMERON
        todo make sure that these are all of the special cases
        Thanks,
        Mark
        */
        if (skill.equals(EmployeeSkill.Skills.MANAGER) ||
                skill.equals(EmployeeSkill.Skills.COORDINATOR))
            result = 0;
        else
            result = this.page;

        return result;
    }

    /** Compares two positions based on the order they should be filled in
     *  i.e any "special cases" to be made outside of the main matching algorithm
     *  have a lower orderOf, however, that should return that they are of greater
     *  import to match first
     *
     * @param aPosition
     * @return 1, 0, -1 depending on relation of the two positions
     */
    public int compareTo(Position aPosition){
        int result;
        if(this.getOrderOfImport() < aPosition.getOrderOfImport())
            result = -1;

        else if (this.getOrderOfImport() == aPosition.getOrderOfImport())
            result = 0;

        else
            result = 1;

        return result;
    }

    public String toString(){
        return "POSITION " + getSkill() + " - EMPLOYEE: " + this.employee.getName() + " ~~~";
    }

    public Employee getEmployee(){
        return this.employee;
    }
}
