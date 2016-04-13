import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelread {

	public static void main(String[] args) throws IOException {
		
		
		String name ="";
		String in = "";
		String out = "";
		FileInputStream fis = new FileInputStream(new File("trial2.xlsx"));
	
		//create workbook instance that refers to the .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//create a sheet object to retrieve the sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//that is for evaluate the cell type
		
		boolean drive = false;
			for (Row row :sheet){
				for (int column = 0; column <8; column++){
					Cell cell = row.getCell(column);
					if(cell != null){
					String check = cell.getStringCellValue();
					if (column == 0){
						for (int test = 0; test < check.length();test++){
							char check2 =check.charAt(test);
							if (check2 == ','){
								name = "";
								for (int test2 = test + 2; test2 <check.length(); test2++){
									name = name + check.charAt(test2);
								}
				
								if (check.charAt(2)== '~' || check.charAt(2) == '-' ){
									name = name + " " + check.charAt(3);
								}
								else{
									name = name + " " + check.charAt(0);
								}
							}
						}
					}
					else{
						in = "";
						out = "";
						String change;
						int test = 0;
						in:
						while ( test < check.length()){
							char item =check.charAt(test);
							switch (item){
							case ' ':
								break;
							case 'O': case 'o': case '0': case 'D':
								change = "0";
								in = in + change;
								break;
							case 'l': case '1': case 'I':
								change = "1";
								in = in + change;
								break;
							case '2': case '3': case '4': case '5': case '6':
							case '7': case '8': case '9':
								in = in + item;
								break;
							case ':':
								change = ":";
								in = in + change;
								break;
							case '-': case '~':
								break in;
							default:
								in = in + item;
							}
							test++;
						}
						test++;
						out:
						while (test < check.length()){
							drive = false;
							char item = check.charAt(test);
							switch (item){
							case ' ':
								break;
							case 'O': case 'o': case '0': case 'D':
								change = "0";
								out = out + change;
								break;
							case 'l': case '1': case 'I':
								change = "1";
								out = out + change;
								break;
							case '2': case '3': case '4': case '5': case '6':
							case '7': case '8': case '9':
								out = out + item;
								break;
							case ':':
								change = ":";
								out = out + change;
								break;
							case '(': case '{': case '[':
								drive = true;
								break out;
							default:
								out = out + item;
							}
							test++;
						}
						
						Employee currentEmployee = new Employee(name, in, out);
						
						switch (column){
						
						}
						//System.out.print(in);
						//System.out.print(out);
						System.out.println(currentEmployee.getName() +": "+ currentEmployee.getStartTime() +", " + currentEmployee.getEndTime()+ " "+drive +"\t");
						
						}
						
					}
				}System.out.println();
				}	
				
			}
				}


