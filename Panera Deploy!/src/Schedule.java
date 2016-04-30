import java.util.PriorityQueue;

public class Schedule {

    //Queues for the front positions
    protected PriorityQueue<Employee> MondayFrontQ;
    protected PriorityQueue<Employee> TuesdayFrontQ;
    protected PriorityQueue<Employee> WednesdayFrontQ;
    protected PriorityQueue<Employee> ThursdayFrontQ;
    protected PriorityQueue<Employee> FridayFrontQ;
    protected PriorityQueue<Employee> SaturdayFrontQ;
    protected PriorityQueue<Employee> SundayFrontQ;

    //Queues for the drive thru positions
    protected PriorityQueue<Employee> MondayDriveThruQ;
    protected PriorityQueue<Employee> TuesdayDriveThruQ;
    protected PriorityQueue<Employee> WednesdayDriveThruQ;
    protected PriorityQueue<Employee> ThursdayDriveThruQ;
    protected PriorityQueue<Employee> FridayDriveThruQ;
    protected PriorityQueue<Employee> SaturdayDriveThruQ;
    protected PriorityQueue<Employee> SundayDriveThruQ;

    /*
        This class (and the rest of the project) use Wednesday as the first day of the week

        1 - Wednesday
        2 - Thursday
        3 - Friday
        4 - Saturday
        5 - Sunday
        6 - Monday
        7 - Tuesday
     */

    public Schedule(){
        MondayFrontQ = new PriorityQueue<Employee>();
        TuesdayFrontQ = new PriorityQueue<Employee>();
        WednesdayFrontQ = new PriorityQueue<Employee>();
        ThursdayFrontQ = new PriorityQueue<Employee>();
        FridayFrontQ = new PriorityQueue<Employee>();
        SaturdayFrontQ = new PriorityQueue<Employee>();
        SundayFrontQ = new PriorityQueue<Employee>();

        MondayDriveThruQ = new PriorityQueue<Employee>();
        TuesdayDriveThruQ = new PriorityQueue<Employee>();
        WednesdayDriveThruQ = new PriorityQueue<Employee>();
        ThursdayDriveThruQ = new PriorityQueue<Employee>();
        FridayDriveThruQ = new PriorityQueue<Employee>();
        SaturdayDriveThruQ = new PriorityQueue<Employee>();
        SundayDriveThruQ = new PriorityQueue<Employee>();
    }

    public boolean add(Employee newEmployee, int dayOfWeek, boolean driveThru){
        boolean result = false;

        switch (dayOfWeek){
            case 1:
                if (driveThru)
                    result = WednesdayDriveThruQ.add(newEmployee);
                else
                    result = WednesdayFrontQ.add(newEmployee);
                break;
            case 2:
                if (driveThru)
                    result = ThursdayDriveThruQ.add(newEmployee);
                else
                    result = ThursdayFrontQ.add(newEmployee);
                break;
            case 3:
                if (driveThru)
                    result = FridayDriveThruQ.add(newEmployee);
                else
                    result = ThursdayFrontQ.add(newEmployee);
                break;
            case 4:
                if (driveThru)
                    result = SaturdayDriveThruQ.add(newEmployee);
                else
                    result = SaturdayFrontQ.add(newEmployee);
                break;
            case 5:
                if (driveThru)
                    result = SundayDriveThruQ.add(newEmployee);
                else
                    result = SundayFrontQ.add(newEmployee);
                break;
            case 6:
                if (driveThru)
                    result = MondayDriveThruQ.add(newEmployee);
                else
                    result = MondayFrontQ.add(newEmployee);
                break;
            case 7:
                if (driveThru)
                    result = TuesdayDriveThruQ.add(newEmployee);
                else
                    result = TuesdayFrontQ.add(newEmployee);
                break;
            default:
                break;
        }

        return result;
    }

    public PriorityQueue<Employee> getSchedule(int dayOfWeek, boolean driveThru){
        PriorityQueue<Employee> result;

        switch (dayOfWeek){
            case 1:
                if (driveThru)
                    result = WednesdayDriveThruQ;
                else
                    result = WednesdayFrontQ;
                break;
            case 2:
                if (driveThru)
                    result = ThursdayDriveThruQ;
                else
                    result = ThursdayFrontQ;
                break;
            case 3:
                if (driveThru)
                    result = FridayDriveThruQ;
                else
                    result = ThursdayFrontQ;
                break;
            case 4:
                if (driveThru)
                    result = SaturdayDriveThruQ;
                else
                    result = SaturdayFrontQ;
                break;
            case 5:
                if (driveThru)
                    result = SundayDriveThruQ;
                else
                    result = SundayFrontQ;
                break;
            case 6:
                if (driveThru)
                    result = MondayDriveThruQ;
                else
                    result = MondayFrontQ;
                break;
            case 7:
                if (driveThru)
                    result = TuesdayDriveThruQ;
                else
                    result = TuesdayFrontQ;
                break;
            default:
                result = null;
                break;
        }

        return result;
    }
}
