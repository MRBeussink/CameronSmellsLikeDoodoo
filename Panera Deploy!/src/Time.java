/** This class represents a certain time and can convert from military/24 hour to 12 hour time and back.
 * Also, it allows the user to compare an integer representation of time to a Time object
 * 
 * @author Mark
 *
 *To-do: Use regular expressions in converting from String to integer+enum pair
 */
public class Time implements Comparable<Object> {
	private int time;		//stores hours and minutes in 24hr time

	public Time(int time){
		this.time = time;
	}

	public Time(Time aTime){
		this.time = aTime.time;
	}

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

	/** Adds some interval of time to the current time
	 *
	 * @param time
	 * @return tr
     */
	public boolean addTime(int time){
		if (time > 0) {
			this.time += time;
			checkRollOver();
			return true;
		}
		else
			return false;
	}


	public int compareTo(Object aTime){
		if (aTime instanceof Time) {
			Time that = (Time) aTime;
			if (this.time == that.time)
				return 0;
			else if (this.time > that.time)
				return 1;
			else
				return -1;
		}

		else if (aTime instanceof Integer){
			int that = (int) aTime;
			if (this.time == that)
				return 0;
			else if (this.time > that)
				return 1;
			else
				return -1;
		}

		else{
			System.out.println("Failed comparison between time and object");
			return -5;
		}

	}

	public boolean isBefore(int aTime){
		return this.time < aTime;
	}

	public boolean isBefore(Time aTime){
		return this.time < aTime.time;
	}

	public boolean isAfter(int aTime){
		return this.time > aTime;
	}

	public boolean isAfter(Time aTime){
		return this.time > aTime.time;
	}

	@Override
	public boolean equals(Object aTime){
		if (aTime instanceof Integer){
			int that = (Integer) aTime;
			return this.time == that;
		}

		else if (aTime instanceof Time){
			Time that = (Time) aTime;
			return this.time == that.time;
		}

		else
			return false;
	}

	protected void checkRollOver(){
		if (time > 2500){
			time = time % 2400;
		}

		if ((this.time % 100) >= 60){
			int minutes = (time % 100) % 60;
			int hours = (time / 100) * 100 + 100;

			time = hours + minutes;
		}
	}


	public String toString(){
		String result = "";
		String tempTime = Integer.toString(time);

		if (time < 1000){
			result = (tempTime.charAt(0)) + ":" + tempTime.charAt(1) + tempTime.charAt(2) + "AM";
		}
		else if (time < 1300){
			result = "1" + tempTime.charAt(1) + ":" + tempTime.charAt(2) + tempTime.charAt(3) + "AM";
		}
		else if (time < 2200){
			tempTime = Integer.toString(time - 1200);
			result = tempTime.charAt(0) + ":" + tempTime.charAt(1) + tempTime.charAt(2) + "PM";
		}
		else {
			tempTime = Integer.toString(time - 1200);
			result = "1" + tempTime.charAt(1) + ":" + tempTime.charAt(2) + tempTime.charAt(3) + "PM";
		}

		return result;
	}
	/*
	public static void main(String[] args){

		for(Time t = new Time(930); t.isBefore(2300); t.addTime(15)){
			System.out.println(t.toString());
		}
	}
	*/
}
