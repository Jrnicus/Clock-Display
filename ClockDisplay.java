
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String meridium;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        meridium = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String am_pm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        meridium = am_pm;
        setTime(hour, minute, meridium);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if (hours.getValue() == 0)
            {
                changeMeridium();
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String am_pm)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        meridium = am_pm;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * This will change the meridium from what ever it is to the other opetion
     * if its AM it will change to PM
     * if its PM it will change to AM
     */
    public void changeMeridium()
    {
        if (meridium.equalsIgnoreCase("PM"))
        {
            meridium = "AM";
        }
        else
        {
            meridium = "PM";
        }
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if (hours.getValue() != 0)
        {
            displayString = hours.getValue() + ":" + 
                            minutes.getDisplayValue() + meridium;
        }
        else
        {
            displayString = "12:" + minutes.getDisplayValue() + meridium;
        }
    }
}
