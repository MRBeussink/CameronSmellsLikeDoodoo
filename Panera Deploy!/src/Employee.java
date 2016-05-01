/* This class represents an employee
 * 
 */


public class Employee implements Comparable<Employee>{
	
    private String name;        //holds the name of the employee
    protected Time startTime;   //holds the starting time of the employee
    protected Time endTime;     //holds the quitin time of the employee

    protected boolean changedPosition;      //this reflects that an employee
                                            //has changed positions during a shift

    /**Creates an employee with a start and end time of 0
     *
     * @param name the name of the employee
     */
    public Employee(String name){
        this(name, 0, 0);
    }

    /**Creates an employee with a given start and stop time,
     *
     * @param name the name of the employee
     * @param startTime the starting time of the employee
     * @param endTime the stopping time of the employee
     */
    public Employee( String name, String startTime, String endTime){
    	this(name, new Time(startTime),new Time(endTime));
    }

    /**Creates an employee with a given start and stop time,
     *
     * @param name the name of the employee
     * @param startTime the starting time of the employee
     * @param endTime the stopping time of the employee
     */
    public Employee(String name, int startTime, int endTime){
        this(name, new Time(startTime), new Time(endTime));
    }

    /**Creates an employee with a given start and stop time,
     *
     * @param name the name of the employee
     * @param startTime the starting time of the employee
     * @param endTime the stopping time of the employee
     */
    public Employee(String name, Time startTime, Time endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.changedPosition = false;
    }

    /** Sets the employee's name
     *
     * @param name the employee's name
     */
    public void setName(String name){
        this.name = name;
    }

    /** Sets the starting time for the employee
     *
     * @param aTime the starting time
     */
    public void setStartTime(Time aTime){
        this.startTime = aTime;
    }

    /**Sets the stopping time for the employee
     *
     * @param aTime the stopping time
     */
    public void setEndTime(Time aTime){
        this.endTime = aTime;
    }

    /** Returns the employees name
     *
     * @return
     */
    public String getName(){
        return this.name;
    }

    /** Returns the starting time of the employee
     *
     * @return
     */
    public Time getStartTime(){
        return this.startTime;
    }

    /** Returns the stopping time of the employee
     *
     * @return
     */
    public Time getEndTime(){
        return this.endTime;
    }

    /** Sets the boolean to reflect the fact that the employee has changed positions
     *
     */
    public void changedPosition(){
        this.changedPosition = true;
    }

    /** Returns the boolean value reflecting employee position transitions
     *
     * @return
     */
    public boolean hasChangedPosition(){
        return this.changedPosition;
    }

    /** Returns the employees name
     *
     * @return
     */
    @Override
    public String toString(){
        return getName();
    }

    public int compareTo(Employee anEmployee){
        int result;
        if(this.getStartTime().isBefore(anEmployee.getStartTime()))
            result = -1;
        else if (this.getStartTime().equals(anEmployee.getStartTime()))
            result = 0;
        else
            result = 1;
        return result;
    }
}
