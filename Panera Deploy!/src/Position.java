
/**
 * Created by Mark on 4/10/16.
 */

public class Position {
    private int row, col, page;     //these variables are for the deployment spreadsheets
    private boolean priority;       //if a position MUST be filled, this should be true

    private Employee employee;      //the employee who fills this position
    private EmployeeSkill skill;    //the necessary skill to match

    private Time startTime;
    private Time endTime;

    private Time expiration;        //the time which this position is no longer considerable

    private Position carryOverPosition;

    public Position(int row, int col, int page, boolean priority, EmployeeSkill skill){
        this.row = row;
        this.col = col;
        this.page = page;
        this.priority = priority;
        this.skill = skill;
    }

    public EmployeeSkill getSkill(){
        return this.skill;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.row;
    }

    public int getPage(){
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
        if (employee == null && this.employee != null){
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






}
