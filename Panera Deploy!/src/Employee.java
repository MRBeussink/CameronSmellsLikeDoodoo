/* This class represents an employee
 * 
 */


public class Employee {
	
    private String name;
    protected Time startTime;
    protected Time endTime;

    protected boolean changedPosition;

    public Employee(String name){
        this(name, 0, 0);
    }
    public Employee( String name, String startTime, String endTime){
    	this(name, new Time(startTime),new Time(endTime));
    }
    
    public Employee(String name, int startTime, int endTime){
        this(name, new Time(startTime), new Time(endTime));
    }

    public Employee(String name, Time startTime, Time endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.changedPosition = false;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setStartTime(Time aTime){
        this.startTime = aTime;
    }

    public void setEndTime(Time aTime){
        this.endTime = aTime;
    }

    public String getName(){
        return this.name;
    }

    public Time getStartTime(){
        return this.startTime;
    }

    public Time getEndTime(){
        return this.endTime;
    }

    public void changedPosition(){
        this.changedPosition = true;
    }
}
