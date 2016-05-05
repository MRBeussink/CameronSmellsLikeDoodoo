/**
 * Created by Mark on 4/19/16.
 */

import java.io.IOException;
import java.util.ArrayList;
//import java.util.PriorityQueue;
import java.util.ArrayDeque;

public class Driver {

    public static boolean test = true;
    private static String file;
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
                    ArrayDeque<Position> frontPositionsQueue = positionReader.getFrontQ();
                    if(test)
                    	System.out.println("Trying to get Drive Thru Positions...");
                    ArrayDeque<Position> drivePositionsQueue = positionReader.getDriveQ();

                    /* MAGIC! */
                    
                    MatchMaker matcher = new MatchMaker(skillMap, frontPositionsQueue);
                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(1, false), false);
                    if(test)
                        for(int i = 0; i < assignedFront.size(); i++)
                            System.out.println(assignedFront.get(i));
                    
                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(1, true),true);
               
                    ExcelWriter exwrite = new ExcelWriter();
                    exwrite.writeFDoc(assignedFront, file);
                    exwrite.writeDDoc(assignedDrive);
                
                    if(test)
                        for(int i = 0; i < assignedDrive.size(); i++)
                            System.out.println(assignedDrive.get(i));
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
