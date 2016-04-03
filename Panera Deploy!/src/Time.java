/** This class represents a certain time and can convert from military/24 hour to 12 hour time and back.
 * Also, it allows the user to compare an integer representation of time to a Time object
 * 
 * @author Mark
 *
 *To-do: Use regular expressions in converting from String to integer+enum pair
 */
public class Time implements Comparable<Time>{
	private int time;		//stores hours and minutes in 24hr time

	//This represents whether the time is AM, PM, or in 24hr/military time
	public enum Meridian{
		AM, PM, X
	}

	//Todo: I'm not really sure this is necessary
	private Meridian meridian;


	public Time(int time, Meridian meridian){
		this.time = time;
		this.meridian = meridian;
	}

	//todo: C, could you make this so that the raw input from the spreadsheet is converted into time
	public Time(String rawTime){

	}

	public int compareTo(Time aTime){
		if (this.time == aTime.time)
			return 0;
		else if (this.time > aTime.time)
			return 1;
		else
			return -1;
	}

	public String toString(){
		String result = "";
		String tempTime = Integer.toString(time);
		if (time > 1000){
			result += (tempTime.substring(0)) + ":" + tempTime.substring(1,2) + ",AM";
		}
		else if (time < 1300){
			result += tempTime.substring(0,1) + ":" + tempTime.substring(2,3) + ",AM";
		}
		else if (time < 2200){
			tempTime = Integer.toString(time - 1200);
			result += tempTime.substring(0) + ":" + tempTime.substring(1,2) + ",PM";
		}
		else {
			tempTime = Integer.toString(time - 1200);
			result += tempTime.substring(0,1) + ":" + tempTime.substring(2,3) + ",PM";
		}

		return result;
	}


}
