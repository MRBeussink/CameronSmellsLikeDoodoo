/** This class represents a certain time and can convert from military/24 hour to 12 hour time and back.
 * Also, it allows the user to compare an integer representation of time to a Time object
 * 
 * @author Mark
 *
 *To-do: Use regular expressions in converting from String to integer+enum pair
 */
public class Time implements Comparable<Time>{
	private int time;		//stores hours and minutes in 24hr time

    /*
	//This represents whether the time is AM, PM, or in 24hr/military time
	public enum Meridian{
		AM, PM, X
	}
    */

	public Time(int time){
		this.time = time;
	}

	//todo: C, could you make this so that the raw input from the spreadsheet is converted into time
	public Time(String rawTime){
		String T = "";
		int add = 0;
    		for(int i = 0; i < rawTime.length(); i ++){
    			if (rawTime.charAt(i) == 'A'){
    				add = 0;
    			}else if (rawTime.charAt(i) == 'P'){
    				add = 1200;
    			}else if (rawTime.charAt(i) != ':'){
    				T = T + rawTime.charAt(i);
    			}
    				
    		}
    		this.time = Integer.parseInt(T) + add;
	}

    public void setTime(int time){
        this.time = time;
    }
    

    public int getTime(){
        return this.time;
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
		
		if (time < 1000){
			result = (tempTime.charAt(0)) + ":" + tempTime.charAt(1) + tempTime.charAt(2) + "AM";
		}
		else if (time < 1300){
			result = tempTime.charAt(0) + tempTime.charAt(1) + ":" + tempTime.charAt(2) + tempTime.charAt(3) + "AM";
		}
		else if (time < 2200){
			tempTime = Integer.toString(time - 1200);
			result = tempTime.charAt(0) + ":" + tempTime.charAt(1) + tempTime.charAt(2) + "PM";
		}
		else {
			tempTime = Integer.toString(time - 1200);
			result = tempTime.charAt(0) + tempTime.charAt(1) + ":" + tempTime.charAt(2) + tempTime.charAt(3) + "PM";
		}

		return result;
	}


}
