import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
	
public class ExcelWriter {
	
	private int x = 0;
	
	public ExcelWriter(){
		
	}
	
	public void writeDoc(ArrayList position){
		FileInputStream output = new FileInputStream("Wednesday.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(output);
			workbook.getSheetAt(x);
			while(!position.isEmpty()){
				int x = position.get(0).getClass().
				Cell cell = workbook.getRow(position.getClass().)
		}
	}
}
