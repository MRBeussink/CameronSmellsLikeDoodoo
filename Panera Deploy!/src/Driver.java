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
            ExcelReader scheduleReader = new ExcelReader();
            Schedule employeeSchedule = new Schedule();
            scheduleReader.getSchedule(employeeSchedule);

            try{
                SkillReader skillReader = new SkillReader();
                EmployeeSkillMap skillMap = new EmployeeSkillMap();
                skillReader.makeEmployeeSkillMap();

                try{
                    PositionReader positionReader = new PositionReader();
                    PriorityQueue<Position> frontPositionsQueue = positionReader.getFrontQ();
                    PriorityQueue<Position> drivePositionsQueue = positionReader.getDriveQ();

                    /* MAGIC! */
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
