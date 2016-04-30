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
	private int page;
	private int row1;
	private int col;
	
	
	public PositionReader() throws IOException{
		frontPos = new FileInputStream(new File("FrontPositions.xlsx"));
		drivePos = new FileInputStream(new File("DrivePositions.xlsx"));
		frontWB = new XSSFWorkbook(frontPos);
		driveWB = new XSSFWorkbook(drivePos);
		frontSheet = frontWB.getSheetAt(0);
		driveSheet = driveWB.getSheetAt(0);
		
	}
	public void getFrontPositions(){
		frontQ = new PriorityQueue<Position>();
		for(Row row: frontSheet){
			for(int column = 0; column < 5; column++){
				Cell cell = row.getCell(column);
				if(cell != null){
					String check = cell.getStringCellValue();
					switch(column){
						case 0:
							skill = check;
							break;
						case 1:
							if( "TRUE".equals(check)){
								priority = true;
							}else if("FALSE".equals(check)){
								priority = false;
							}
							break;
						case 2:
							page = Integer.parseInt(check);
							break;
						case 3:
							row1 = Integer.parseInt(check);
							break;
						case 4:
							col = Integer.parseInt(check);
							break;
							
					}
				}
			}
			position = new Position(skill, priority, page, row1, col);
			frontQ.add(position);
		}
	}
	
	public void getDrivePositions(){
		frontQ = new PriorityQueue<Position>();
		for(Row row: driveSheet){
			for(int column = 0; column < 5; column++){
				Cell cell = row.getCell(column);
				if(cell != null){
					String check = cell.getStringCellValue();
					switch(column){
						case 0:
							skill = check;
							break;
						case 1:
							if( "TRUE".equals(check)){
								priority = true;
							}else if("FALSE".equals(check)){
								priority = false;
							}
							break;
						case 2:
							page = Integer.parseInt(check);
							break;
						case 3:
							row1 = Integer.parseInt(check);
							break;
						case 4:
							col = Integer.parseInt(check);
							break;
							
					}
				}
			}
			position = new Position(skill, priority, page, row1, col);
			driveQ.add(position);
		}
	}
	
	public PriorityQueue getFrontQ(){
		return frontQ;
	}
	
	public PriorityQueue getDriveQ(){
		return driveQ;
	}
	
	
}
