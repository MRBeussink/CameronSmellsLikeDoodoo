import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PositionReader {

	private PriorityQueue<Position> frontQ;
	private PriorityQueue<Position> driveQ;
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
		frontQ = new PriorityQueue<Position>();
		RowLoop : for(Row row: frontSheet){
			for(int column = 0; column < 5; column++){
				Cell cell = row.getCell(column);
				if(cell != null){
					int checker = cell.getCellType();
					 System.out.println(checker);
					 if(checker == 3)
						 break RowLoop;
					 
					switch(column){
						case 0:
							String check= cell.getStringCellValue();
							skill = check;
							System.out.println(skill);
							
							break;
						case 1:
							boolean priority1 = cell.getBooleanCellValue();
							priority = priority1;
							System.out.println(priority);
							
							break;
						case 2:
							double page1  = cell.getNumericCellValue();
							page = page1;
							System.out.println(page);
							break;
						case 3:
							double row2 = cell.getNumericCellValue();
							row1 = row2;
							System.out.println(row1);
							
							break;
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
				
				/*
				else{
					if(Driver.test)
						System.out.println("Error adding Employee to QUEUE!");
				}*/
		}
	}
	
	private void getDrivePositions(){
		frontQ = new PriorityQueue<Position>();
		RowLoop:
		for(Row row: driveSheet){
			for(int column = 0; column < 5; column++){
				Cell cell = row.getCell(column);
				if(cell != null){
					int checker = cell.getCellType();
					if (checker == 3)
						break RowLoop;
					switch(column){
					case 0:
						String skill= cell.getStringCellValue();
						System.out.println(skill);
						
						break;
					case 1:
						boolean priority = cell.getBooleanCellValue();
						System.out.println(priority);
						
						break;
					case 2:
						double page  = cell.getNumericCellValue();
						System.out.println(page);
						break;
					case 3:
						double row1 = cell.getNumericCellValue();
						System.out.println(row1);
						
						break;
					case 4:
						double col = cell.getNumericCellValue();
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
	
	public PriorityQueue getFrontQ(){
		if (frontQ == null){
			getFrontPositions();
		}
		return frontQ;
	}
	
	public PriorityQueue getDriveQ(){
		if (driveQ == null){
			getDrivePositions();
		}
		return driveQ;
	}
	
	
}
