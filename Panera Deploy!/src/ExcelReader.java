import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private String name = null;
	private String in = null;
	private String out = null;
	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	private boolean drive = false;
	
	public ExcelReader() throws IOException{
		fis = new FileInputStream(new File("trial2.xlsx"));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}
	
	public void getSchedule(Schedule s){
		for (Row row :sheet){
			for(int column = 0; column <8; column++){
				Cell cell = row.getCell(column);
				//get the cell value if found to be not null
				if(cell != null){
					int checker = cell.getCellType();
					System.out.println(checker);
					String check = cell.getStringCellValue();
				if(column == 0){
					//Assigns a name value for the entire week of times
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
					//Modifies the information to get an accurate in time.
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
					// Modifies the out time to get the necessary information for the out time.
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
					if (name != null && in != null && out != null){
					//creates a new employee with a name, start time, and end time
					Employee currentEmployee = new Employee(name, in, out);
					System.out.println(name + in + out);
					// adds the current employee to a PriorityQue
					s.add(currentEmployee, column, drive);
					System.out.println(currentEmployee.getName() + column + drive);
					}		
					}
					
				}
			}
			}	
			
		}
				
				}
			
		
	

