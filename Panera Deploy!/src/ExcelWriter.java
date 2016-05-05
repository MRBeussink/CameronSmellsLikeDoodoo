
import java.io.*;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
	
public class ExcelWriter {
	
	private int x = 0;
	GUIDriver gd = new GUIDriver();
	
	public ExcelWriter(){
		
	}
	
	public void writeFDoc(ArrayList<Position> positions) throws FileNotFoundException{
		try {
			if(Driver.test)
				System.out.println("Opeening input stream");
			FileInputStream fsIP = new FileInputStream(gd.getDay());
			try {
				if(Driver.test)
					System.out.println("Creating new workbook");
				HSSFWorkbook workbook = new HSSFWorkbook(fsIP);
				//workbook.getSheetAt(x);
				for (int i = 0; i < positions.size(); i++){
					int rownum = (int) positions.get(i).getRow() - 1;
					int colnum = (int) positions.get(i).getCol() - 1;
					int pagenum = (int) positions.get(i).getPage();

					//write to the page
					if(Driver.test)
						System.out.println("Writing employee " + positions.get(i).getEmployeeName() + " to " +
						pagenum + ", " + rownum +", " + colnum);
					HSSFSheet worksheet = workbook.getSheetAt(pagenum);
					Cell cell = null;
					cell = worksheet.getRow(rownum).getCell(colnum);
					cell.setCellValue("ERROR");
					cell.setCellValue(positions.get(i).getEmployee().toString());
					System.out.println(cell);
					
					if (rownum == 24 && colnum == 3){
						System.out.print("Why");
						worksheet = workbook.getSheetAt(pagenum + 1);
						cell = worksheet.getRow(16).getCell(3);
						cell.setCellValue(positions.get(i).getEmployee().toString());
					}
					else if (rownum == 28 && colnum == 3){
						worksheet = workbook.getSheetAt(pagenum + 1);
						cell = worksheet.getRow(20).getCell(3);
						cell.setCellValue(positions.get(i).getEmployee().toString());
					}
					else if (rownum == 18 && colnum == 9){
						System.out.println("HELLO");
						worksheet = workbook.getSheetAt(pagenum + 1);
						cell = worksheet.getRow(5).getCell(15);
						cell.setCellValue(positions.get(i).getEmployee().toString());
					}
					else if (rownum == 24 && colnum == 10){
						System.out.print("Maybe");
						worksheet = workbook.getSheetAt(pagenum + 1);
						cell = worksheet.getRow(16).getCell(11);
						cell.setCellValue(positions.get(i).getEmployee().toString());
					}
					else if (rownum == 20 && colnum == 11){
						System.out.print("Yes");
						worksheet = workbook.getSheetAt(pagenum - 1);
						cell = worksheet.getRow(10).getCell(9);
						cell.setCellValue(positions.get(i).getEmployee().toString());
					}
					//FileOutputStream output = new FileOutputStream("Wednesday.xls");
					
				}
				fsIP.close();

				FileOutputStream output = new FileOutputStream("Wednesday.xls");
				workbook.write(output);
				output.close();

				//output.close();

				/*
				while (!position.isEmpty()) {
					int x = position.get(0).getClass().
							Cell cell = workbook.getRow(position.getClass().)
				}
				*/
			}
			catch(IOException e){
				System.out.println("Error with opening file stream.");
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Unable to find output file.");
		}
	}
	public void writeDDoc(ArrayList<Position> positions){
		
	}
}
