/** This class represents a certain time and can convert from military/24 hour to 12 hour time and back.
 * Also, it allows the user to compare an integer representation of time to a Time object
 * 
 * @author Mark
 *
 *To-do: Use regular expressions in converting from String to integer+enum pair
 */
public class Time {
	private int time;		//the hour and minutes
	
	private enum Meridian{
		AM, PM, X
	}
	
	private Meridian meridian;
	
	public Time (String time){
		String numTime;
		numTime += time.charAt(0) + time.charAt(1) + time.charAt(3) + time.charAt(4);
		
		switch (time.charAt(5)){
			case 'A': case 'a':
				this(Integer.parseInt(numTime), Meridian.AM);
				break;
			case 'P': case 'p':
				this(Integer.parseInt(numTime), Meridian.PM);
		}
		
	}
	
	public Time(int time, Meridian meridian){
		this.time = time;
		this.meridian = meridian;
	}
}
