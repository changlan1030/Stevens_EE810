public class JulianDate {
	private double julianDate;
	private static int Y2k = 2000;
	
	private static String[] monthNames = {
			"Jan", "Feb", "Mar", "Apr",
			"May", "Jun", "Jul", "Aug",
			"Sep", "Oct", "Nov", "Dec"};
	
	private static String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	
	public JulianDate() {
	}
	
	public JulianDate(int year, int mon, int day) {
		year += 8000;
		if (mon < 3) {
			year--;
			mon += 12;
		}
		julianDate = (year * 365) + (year / 4) - (year / 100) + (year / 400) + (mon * 153 + 3) / 5 + day - 3652458;
	}
	
	public JulianDate(int year, int mon, int day, int hour, int min, int sec) {
		year += 8000;
		if (mon < 3) {
			year--;
			mon += 12;
		}
		julianDate = (year * 365) + (year / 4) - (year / 100) + (year / 400) + (mon * 153 + 3) / 5 + day - 3652458;
		if (hour >= 12) {
			julianDate += 0.5;
		}
	}
	
	public double getJulianDate() {
		return julianDate;
	}
	
	public int getYear() {
		int year = (int)(julianDate) / 366 - 4715;
		while (new JulianDate(year + 1, 1, 1).getJulianDate() <= julianDate) {
			year++;
		}
		return year;
	}
	
	public int getMonth() {
		int year = getYear();
		int mon = 1;
		while (new JulianDate(year, mon + 1, 1).getJulianDate() <= julianDate) {
			mon++;
		}
		return mon;
	}
	
	public int getDay() {
		int year = getYear();
		int mon = getMonth();
		int day = 1;
		while (new JulianDate(year, mon, day + 1).getJulianDate() <= julianDate) {
			day++;
		}
		return day;
	}
	
	public int getHour() {
		return 0;
	}
	
	public int getMinute() {
		return 0;
	}
	
	public int getSecond() {
		return 0;
	}
	
	public String dayOfWeek() {
		return dayNames[(int)(julianDate + 6) % 7];
	}
	
	public String getMonthName() {
		return monthNames[getMonth() - 1];
	}
	
	public JulianDate add(double t) {
		JulianDate result = new JulianDate();
		result.julianDate = julianDate + t;
		if (result.julianDate % 1 == 0.5) {
			return new JulianDate(result.getYear(), result.getMonth(), (int)(result.getDay()), 12, 0, 0);
		}
		else {
			return new JulianDate(result.getYear(), result.getMonth(), (int)(result.getDay()));
		}
	}
	
	public JulianDate sub(double t) {
		JulianDate result = new JulianDate();
		result.julianDate = julianDate - t;
		if (result.julianDate % 1 == 0.5) {
			return new JulianDate(result.getYear(), result.getMonth(), (int)(result.getDay()), 12, 0, 0);
		}
		else {
			return new JulianDate(result.getYear(), result.getMonth(), (int)(result.getDay()));
		}
	}
	
	public double sub(JulianDate j) {
		return this.julianDate - j.julianDate;
	}
	
	public String toString() {
		String str = getYear() + " " + getMonthName() + " " + getDay();
		if (julianDate % 1 == 0.5) {
			return str + " noon";
		}
		else {
			return str + " midnight";
		}
	}
	
	public static void main(String[] a) {
		JulianDate d1 = new JulianDate(2016, 2, 29);
		JulianDate d2 = new JulianDate(2016, 2, 29, 12, 0, 0);
		JulianDate d3 = new JulianDate(2016, 3, 1);
		JulianDate d4 = new JulianDate(2016, 3, 1, 12, 0, 0);
		
		// add
		System.out.println(d1.add(1));      // 2016, 03, 01 midnight
		System.out.println(d1.add(1.5));    // 2016, 03, 01 noon
		System.out.println(d2.add(1));      // 2016, 03, 01 noon
		System.out.println(d2.add(1.5));    // 2016, 03, 02 midnight
		
		// sub
		System.out.println(d3.sub(1));      // 2016, 02, 29 midnight
		System.out.println(d3.sub(1.5));    // 2016, 02, 28 noon
		System.out.println(d4.sub(1));      // 2016, 02, 29 noon
		System.out.println(d4.sub(1.5));    // 2016, 02, 29 midnight
		
		// sub(-n) = add(n)
		System.out.println(d1.sub(-1));      // 2016, 03, 01 midnight
		System.out.println(d1.sub(-1.5));    // 2016, 03, 01 noon
		System.out.println(d2.sub(-1));      // 2016, 03, 01 noon
		System.out.println(d2.sub(-1.5));    // 2016, 03, 02 midnight
				
		// add(-n) = sub(n)
		System.out.println(d3.add(-1));      // 2016, 02, 29 midnight
		System.out.println(d3.add(-1.5));    // 2016, 02, 28 noon
		System.out.println(d4.add(-1));      // 2016, 02, 29 noon
		System.out.println(d4.add(-1.5));    // 2016, 02, 29 midnight
		
		// days
		System.out.println(d3.sub(d1));      // 1.0
		System.out.println(d3.sub(d2));      // 0.5
		System.out.println(d4.sub(d1));      // 1.5
		System.out.println(d4.sub(d2));      // 1.0
		
		// normal year
		JulianDate d5 = new JulianDate(2017, 2, 27);
		System.out.println(d5.add(2));       // 2017, 03, 01 midnight
		
		// "new year"
		JulianDate d6 = new JulianDate(2016, 1, 1);
		System.out.println(d6.sub(2));       // 2015, 12, 30 midnight
		JulianDate d7 = new JulianDate(2015, 12, 31);
		System.out.println(d7.add(2));       // 2016, 01, 02 midnight
		
		// day of week
		JulianDate d8 = new JulianDate(2016, 10, 10);
		System.out.println(d8.dayOfWeek());  // Mon
	}
}