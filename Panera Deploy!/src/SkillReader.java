import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SkillReader {
	
	private EmployeeSkillMap skillMap;
	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	
	public SkillReader() throws IOException{
		skillMap = new EmployeeSkillMap();
		fis = new FileInputStream (new File("Skills.xlsx"));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}
	
	public void makeEmployeeSkillMap(){
		 String name = "";
		 
		for (Row row : sheet){
			for (int column = 0; true; column++){
				Cell cell = row.getCell(column);
				if( cell != null){
					String info = cell.getStringCellValue();
					if(column == 1){
						name = info;
						skillMap.addEmployee(info);
					}else
						skillMap.addSkill(name, info);
				}else
					break;
				
			}
		}
	}
	
}
