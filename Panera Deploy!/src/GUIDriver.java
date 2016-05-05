import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class GUIDriver {
	/*test to check for potential issues
	When set to true will show all prints to help trouble shoot
	When set false will not show any prints pertaining to trouble shooting
	*/
	public static boolean test = true;
	
	//Used to allow user to select a file
	private JFileChooser chooser;
	
	//GUI Frame
	private JFrame frame;
	
	//Allows for the day of week to be selected 
	private String day;
	
	private String[] files = {"trial2.xlsx"};
	
	//File which you want to use for the Schedule
	private String file;
	
	/* Integer Pertaining to Day of Week
	 * 1 - Wednesday
	 * 2 - Thursday
	 * 3 - Friday
	 * 4 - Saturday
	 * 5 - Sunday
	 * 6 - Monday
	 * 7 - Tuesday
	 */
	private int columnDay;
	
	public String getDay(){
		return day;
	}
	
	//returns the columnDay (Day of week) Starts with Wednesday as 1
	public int getcolumnDay(){
		return columnDay;
	}
	
	//returns the file 
	public String getFile(){
		return file;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDriver window = new GUIDriver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIDriver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 889, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Button which allows you to make a Sunday Deployment Chart
		JButton btnNewButton = new JButton("Sunday");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day = "Sunday.xls";
				columnDay = 5;
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
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
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
		});
		btnNewButton.setBounds(18, 249, 110, 35);
		frame.getContentPane().add(btnNewButton);
		
		//Button which allows you to make a Monday Deployment
		JButton btnMonday = new JButton("Monday");
		btnMonday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day = "Monday.xls";
				columnDay = 6;
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
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
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
		});
		btnMonday.setBounds(140, 249, 110, 35);
		frame.getContentPane().add(btnMonday);
		
		//Button which allows you to make a Tuesday Deployment
		JButton btnTuesday = new JButton("Tuesday");
		btnTuesday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day = "Tuesday.xls";
				columnDay = 7;
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
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
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
		});
		btnTuesday.setBounds(262, 249, 110, 35);
		frame.getContentPane().add(btnTuesday);
		
		//Button which allows you to make a Wednesday Deployment
		JButton btnWednesday = new JButton("Wednesday");
		btnWednesday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day = "Wednesday.xls";
				columnDay = 1;
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
		                   // ArrayDeque<Position> drivePositionsQueue = positionReader.getDriveQ();

		                    /* MAGIC! */
		                    
		                    MatchMaker matcher = new MatchMaker(skillMap, frontPositionsQueue);
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                   // MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                   // ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
		                    ExcelWriter exwrite = new ExcelWriter();
		                    exwrite.writeFDoc(assignedFront, day);
		                    //exwrite.writeDDoc(assignedDrive);
		                
		                   // if(test)
		                      //  for(int i = 0; i < assignedDrive.size(); i++)
		                           // System.out.println(assignedDrive.get(i));
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
		});
		btnWednesday.setBounds(384, 249, 110, 35);
		frame.getContentPane().add(btnWednesday);
		
		//Button which allows you to make a Thursday Deployment
		JButton btnThursday = new JButton("Thursday");
		btnThursday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = "Thursday.xls";
				columnDay = 2;
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
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
		                    ExcelWriter exwrite = new ExcelWriter();
		                    exwrite.writeFDoc(assignedFront, file);
		                    exwrite.writeDDoc(assignedDrive);
		                
		                    if(test)
		                        for(int i = 0; i < assignedDrive.size(); i++)
		                            System.out.println(assignedDrive.get(i));
		                }
		                catch(IOException e1){
		                    System.out.println("ERROR: Unable to load Positions file.");
		                }
		            }
		            catch(IOException e1){
		                System.out.println("ERROR: Unable to load Skill file.");
		            }
		        }
		        catch(IOException e1){
		            System.out.println("ERROR: Unable to load Schedule file.");
		        }
			}
		});
		btnThursday.setBounds(506, 249, 110, 35);
		frame.getContentPane().add(btnThursday);
		
		//Button which allows you to make a Friday Deployment
		JButton btnFriday = new JButton("Friday");
		btnFriday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = "Friday.xls";
				columnDay = 3;
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
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
		                    ExcelWriter exwrite = new ExcelWriter();
		                    exwrite.writeFDoc(assignedFront, file);
		                    exwrite.writeDDoc(assignedDrive);
		                
		                    if(test)
		                        for(int i = 0; i < assignedDrive.size(); i++)
		                            System.out.println(assignedDrive.get(i));
		                }
		                catch(IOException e1){
		                    System.out.println("ERROR: Unable to load Positions file.");
		                }
		            }
		            catch(IOException e1){
		                System.out.println("ERROR: Unable to load Skill file.");
		            }
		        }
		        catch(IOException e1){
		            System.out.println("ERROR: Unable to load Schedule file.");
		        }
			}
		});
		btnFriday.setBounds(628, 249, 110, 35);
		frame.getContentPane().add(btnFriday);
		
		//Button which allows you to make a Saturday Deployment
		JButton btnSaturday = new JButton("Saturday");
		btnSaturday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				day = "Saturday.xls";
				columnDay = 4;
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
		                    ArrayList<Position> assignedFront = matcher.frontMatch(employeeSchedule.getSchedule(columnDay, false), false);
		                    if(test)
		                        for(int i = 0; i < assignedFront.size(); i++)
		                            System.out.println(assignedFront.get(i));
		                    
		                    MatchMaker driveMatcher = new MatchMaker(skillMap, drivePositionsQueue);
		                    ArrayList<Position> assignedDrive = matcher.driveMatch(employeeSchedule.getSchedule(columnDay, true),true);
		               
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
		});
		btnSaturday.setBounds(749, 249, 110, 35);
		frame.getContentPane().add(btnSaturday);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Deployment Generator!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 13, 554, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStartBySelecting = new JLabel("Start by selecting a schedule file before selecting the day you wish a deployment to be generated.");
		lblStartBySelecting.setBounds(154, 60, 573, 16);
		frame.getContentPane().add(lblStartBySelecting);
		
		JComboBox comboBox = new JComboBox(files);
		comboBox.setBounds(349, 120, 145, 22);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(0);
		file = (String) comboBox.getSelectedItem();
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		      	file = (String) comboBox.getSelectedItem();   
		  }
		});
		
	
		
		
		
		
	}
}
