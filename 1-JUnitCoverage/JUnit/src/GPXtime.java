/**
 * Represents a specific time (year, month, day, hour, minute, second)
 * to be used in calculations on the GPX object.
 */

public class GPXtime {

    private String _inputString;
    private int _year;
    private int _month;
    private int _day;
    private int _hour;
    private int _minute;
    private int _second;

    /**
     * This constructor is protected because other classes should not be calling it directly.
     * Rather, they should use createGPXtime in order to ensure that the input string is
     * properly formatted.
     */
    protected GPXtime(int year, int month, int day, int hour, int minute, int second, String inputString) {
	_year = year;
	_month = month;
	_day = day;
	_hour = hour;
	_minute = minute;
	_second = second;
	_inputString = inputString;
    }

    /* Accessors */
    public int year() { return _year; }
    public int month() { return _month; }
    public int day() { return _day; }
    public int hour() { return _hour; }
    public int minute() { return _minute; }
    public int second() { return _second; }


    /**
     * Attempt to create a new GPXtime object from the input string.
     * 
     * @param input The string is assumed to be in the following format: YYYY-MM-DDThh:mm:ssZ
     *
     * @return a GPXtime object representing the string. If an error occurs or if the date appears to be invalid, then return null.
     */
    public static GPXtime createGPXtime(String input) {

	try {
	    int year = Integer.parseInt(input.substring(0, 4));
	    int month = Integer.parseInt(input.substring(5, 7));
	    int day = Integer.parseInt(input.substring(8, 10));
	    int hour = Integer.parseInt(input.substring(11, 13));
	    int minute = Integer.parseInt(input.substring(14, 16));
	    int second = Integer.parseInt(input.substring(17, 19));

	    // make sure the values are valid
	    if (year < 1970 || month < 1 || month > 12 || day < 1 || day > 31 || hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) return null;

	    // if we made it here, we're okay
	    return new GPXtime(year, month, day, hour, minute, second, input);
	    
	}
	catch (Exception e) {
	    // presumably a NumberFormatException
	    e.printStackTrace();
	    return null;
	}
    }
    

    /**
     * Convert the time represented by this object to a standard
     * Java time, i.e. number of millseconds since Jan 1, 1970.
     *
     * For simplicity, we assume there are no dates before Jan 1, 1970.
     *
     * @return the number of milliseconds since Jan 1, 1970 for this object.
     */
    public long convertToJavaTime() {
	// the return value
	long time = 0;

	// first, take care of the years
	time += ((_year - 1970) * (1000 * 60 * 60 * 24 * 365));

	// now, those pesky leap years... for each one, we have to add an extra day
	for (int i = 1970; i < _year; i++) {
	    // keep in mind that 2000 was a leap year but 2100, 2200, etc. are not!
	    if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
		time += (1000 * 60 * 60 * 24);
	}

	// then, months
	int daysPerMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } ;
	for (int i = 0; i <= _month; i++) {
	    time += (daysPerMonth[i] * (1000 * 60 * 60 * 24));
	}

	// then, days
	time += (_day * 1000 * 60 * 60 * 24);

	// then, hours
	time += (_hour * 1000 * 60 * 60);

	// then, minutes
	time += (_minute * 1000 * 60);

	// last, seconds
	time += (_second * 1000);

	// done!
	return time;

    }

    /**
     * Returns the time in the "original" input format
     *
     * @return the time in YYYY-MM-DDThh:mm:ssZ format
     */
    public String toString() { return _inputString; }


}