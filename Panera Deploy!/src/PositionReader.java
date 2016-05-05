import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.PriorityQueue;
import java.util.ArrayDeque;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PositionReader {

	private ArrayDeque<Position> frontQ;
	private ArrayDeque<Position> driveQ;
	private Position position;
	
	private FileInputStream frontPos;
	private FileInputStream	drivePos;
	private XSSFWorkbook frontWB;
	private XSSFWorkbook driveWB;
	private XSSFSheet frontSheet;
	private XSSFSheet driveSheet;
	private String skill;
	private boolean priority;
	private double page;
	private double row1;
	private double col;
	
	
	public PositionReader() throws IOException{
		frontPos = new FileInputStream(new File("FrontPositions.xlsx"));
		drivePos = new FileInputStream(new File("DrivePositions.xlsx"));
		frontWB = new XSSFWorkbook(frontPos);
		driveWB = new XSSFWorkbook(drivePos);
		frontSheet = frontWB.getSheetAt(0);
		driveSheet = driveWB.getSheetAt(0);
		
	}
	private void getFrontPositions(){
		frontQ = new ArrayDeque();
		//Use RowLoop: to break from both for loops(if just used break you would only break from one loop
		RowLoop : for(Row row: frontSheet){
			for(int column = 0; column < 5; column++){
				Cell cell = row.getCell(column);
				if(cell != null){
					//getCellType() determines whether the cell contains a String, boolean, numeric, or null value
					int checker = cell.getCellType();
					 System.out.println(checker);
					 if(checker == 3)
						 break RowLoop;
					 
					switch(column){
						/* collects the skill as a string
						 * this value will be compared to the enum of skills
						 * to determine whom will be able to fullfil the position
						 */
						case 0:
							String check= cell.getStringCellValue();
							skill = check;
							System.out.println(skill);
							
							break;
						/* collects a boolean of whether someone is 
						 * in drive thru or up front
						 */
						case 1:
							boolean priority1 = cell.getBooleanCellValue();
							priority = priority1;
							System.out.println(priority);
							
							break;
						/* collects the page/tab number of the excel sheet
						 * This value will always be numeric
						 * contains the page number the data will be inserted into
						 */
						case 2:
							double page1  = cell.getNumericCellValue();
							page = page1;
							System.out.println(page);
							break;
						/*collects the column at index 3 of the excel sheet
						 * This value should always be a numeric value
						 * contains the insertion row of the cell
						 */
						case 3:
							double row2 = cell.getNumericCellValue();
							row1 = row2;
							System.out.println(row1);
							
							break;
						/*collects the column at index 4 of the excel sheet
						This value should always be a numeric value
						contains the insertion column of the cell
						*/
						case 4:
							double col1 = cell.getNumericCellValue();
							col = col1;
							System.out.println(col);
							
							break;
							
					}
				}
				}
				
					
					position = new Position(skill, priority, page, row1, col);
					frontQ.add(position);
					System.out.println(skill +priority + page + row1 +col);
					if(Driver.test)
						System.out.println(frontQ.peek().getSkill());
				
				
				else{
					if(Driver.test)
						System.out.println("Error adding Employee to QUEUE!");
				}
		}
	}
	
	private void getDrivePositions(){
		frontQ = new ArrayDeque();
		//Use RowLoop: to break from both for loops(if just used break you would only break from one loop
		RowLoop:
		for(Row row: driveSheet){
			for(int column = 0; column < 5; column++){
				Cell cell = row.getCell(column);
				if(cell != null){
					//getCellType() determines whether the cell contains a String, boolean, numeric, or null value
					int checker = cell.getCellType();
					if (checker == 3)
						break RowLoop;
					switch(column){
					/* collects the skill as a string
					 * this value will be compared to the enum of skills
					 * to determine whom will be able to fullfil the position
					 */
					case 0:
						String skill1= cell.getStringCellValue();
						skill = skill1;
						System.out.println(skill);
						
						break;
					/* collects a boolean of whether someone is 
					 * in drive thru or up front
					 */
					case 1:
						boolean priority1 = cell.getBooleanCellValue();
						priority = priority1;
						System.out.println(priority);
						
						break;
					/* collects the page/tab number of the excel sheet
					 * This value will always be numeric
					 * contains the page number the data will be inserted into
					 */
					case 2:
						double page1  = cell.getNumericCellValue();
						page = page1;
						System.out.println(page);
						break;
					/*collects the column at index 3 of the excel sheet
					 * This value should always be a numeric value
					 * contains the insertion row of the cell
					 */
					case 3:
						double row2 = cell.getNumericCellValue();
						row1= row2;
						System.out.println(row1);
						
						break;
					/*collects the column at index 4 of the excel sheet
					This value should always be a numeric value
					contains the insertion column of the cell
					*/
					case 4:
						double col1 = cell.getNumericCellValue();
						col = col1;
						System.out.println(col);
						
						break;
							
					}
				}
			}
			if (skill != null){
			position = new Position(skill, priority, page, row1, col);
			driveQ.add(position);
		}}
	}
	//Checks if the Queue being called for is null and if so it will fill it otherwise will return the Queue(Up Front)
	public ArrayDeque<Position> getFrontQ(){
		if (frontQ == null){
			getFrontPositions();
		}
		return frontQ;
	}
	//Checks if the Queue being called for is null and if so it will fill it otherwise will return the Queue(Drive Thru)
	public ArrayDeque<Position> getDriveQ(){
		if (driveQ == null){
			getDrivePositions();
		}
		return driveQ;
	}
	
	
}
