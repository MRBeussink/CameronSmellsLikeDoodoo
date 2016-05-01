/**
 * Created by Mark on 4/19/16.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Driver {

    public static boolean test = true;

    public static void main(String[] args){
        //get schedule

        //get skills

        //loop for 7 days
            //get today's employees
            //assign employees to positions
            //fill deployment sheet
        try {
            if(test)
                System.out.println("Making schedule...");
            ExcelReader scheduleReader = new ExcelReader();
            Schedule employeeSchedule = new Schedule();
            scheduleReader.getSchedule(employeeSchedule);

            try{
                if(test)
                   System.out.println("Making skills map...");
                SkillReader skillReader = new SkillReader();
                EmployeeSkillMap skillMap = new EmployeeSkillMap();
                skillMap = skillReader.makeEmployeeSkillMap();

                try{
                    if(test)
                        System.out.println("Making position arrays");
                    PositionReader positionReader = new PositionReader();
                    if(test)
                    	System.out.println("Trying to get Front Positions...");
                    PriorityQueue<Position> frontPositionsQueue = positionReader.getFrontQ();
                    if(test)
                    	System.out.println("Trying to get Drive Thru Positions...");
               //     PriorityQueue<Position> drivePositionsQueue = positionReader.getDriveQ();

                    /* MAGIC! */
                    //todo We need someway of copying the arrays, since it removes them
                    MatchMaker matcher = new MatchMaker(skillMap, frontPositionsQueue);
                    ArrayList<Position> assignedFront = matcher.match(employeeSchedule.getSchedule(1, false), false);

                }
                catch(IOException e){
                    System.out.println("ERROR: Unable to load Positions file.");
                }
            }
            catch(IOException e){
                System.out.println("ERROR: Unable to load Skill file.");
            }
        }
        catch(IOException e){
            System.out.println("ERROR: Unable to load Schedule file.");
        }
    }
}
