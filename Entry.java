
/**
 * Stores the Name and Number of a given entry.
 * 
 * @author Jake Greer 
 * @version 2011.02.18
 */
public class Entry
{
    public String name;
    public String number;

    /**
     * Constructor for objects of class Entry
     */
    public Entry(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    /**
     * Converts an entry to a single string.
     * 
     * @return     the name and number as a string.
     */
    public String toString()
    {
        return name + " " + number;
    }
}
