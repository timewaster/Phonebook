import java.util.HashMap;
import simpleIO.*;
/**
 * Stores and manipulates Entry data.
 * 
 * @author Jake Greer 
 * @version 2011.02.18
 */
public class Phonebook
{
    // instance variables - replace the example below with your own
    private HashMap<String, Entry> entries;
    private UserDialog ud = new UserDialog();
    private String name;
    private String number;

    /**
     * Constructor for objects of class Phonebook
     */
    public Phonebook()
    {
        entries = new HashMap<String, Entry>();
        getChoice();
    }

    /**
     * Give a list of options.
     */
    private void getChoice()
    {
        String options[] = {"Add Entry", "Show Number", "Remove Entry", "Edit Entry", "List all", "Exit"};
        int choice = ud.selectIndex("Please select an action:", options);
        name = null;
        number = null;
        //Switch to handle choices
        switch (choice)
        {
            case 0: addEntry(); break;
            case 1: displayEntry(); break;
            case 2: removeEntry(); break;
            case 3: editEntry(); break;
            case 4: listEntries(); break;
            case 5: break;
        }
    }


    /**
     *Adds a new Entry to the phonebook.
     */
    private void addEntry()
    {
        name = ud.getString("Please enter the name of the person you wish to add");
        if ((name != null) && (entries.get(name) == null))
        {
            number = ud.getString("Please enter the number of the person you wish to add");
            if ((number != null) && (number.length() == 11))
            {
                entries.put(name, new Entry(name, number));
                getChoice();
            }
            else
            {
                ud.showMessage("Please enter a valid phone number of exactly 11 digits.");
                addEntry(name);
            }
        }
        else
        {
            ud.showMessage("Error, please enter a unique name.");
            addEntry();
        }
    }


    /**
     * Adds a new Entry to the phonebook by name.
     */
    private void addEntry(String name)
    {
        if ((name != null) && (entries.get(name) == null))
        {
            number = ud.getString("Please enter the number of the person you wish to add");
            if ((number != null) && (number.length() == 11))
            {
                entries.put(name, new Entry(name, number));
                getChoice();
            }
            else
            {
                ud.showMessage("Please enter a valid phone number of exactly 11 digits.");
                addEntry(name);
            }
        }
        else
        {
            ud.showMessage("Error, please enter a unique name.");
            getChoice();
        }
    }

    /**
     * Displays an entry.
     */
    private void displayEntry()
    {
        name = ud.getString("Please enter the name of the person:");
        if ((name != null) && (entries.get(name) != null))
        {
            System.out.println(entries.get(name).toString());
            getChoice();
        }
        else if (name == null)
        {
            ud.showMessage("Error, please input a name");
            displayEntry();
        }
        else
        {
            ud.showMessage("Error, name not found in phonebook.");
            displayEntry();
        }
    }


    /**
     * Removes an entry
     */
    private void removeEntry()
    {
        name = ud.getString("Please enter the name of the person:");
        if ((name != null) && (entries.get(name) != null))
        {
            entries.remove(name);
            getChoice();
        }
        else if (name == null)
        {
            ud.showMessage("Error, please input a name");
            removeEntry();
        }
        else
        {
            ud.showMessage("Error, name not found in phonebook.");
            removeEntry();
        }
    }



    /**
     * Removes an entry by name
     * 
     * @param name The name of the entry to be removed
     */
    private void removeEntry(String name)
    {
        if ((name != null) && (entries.get(name) != null))
        {
            entries.remove(name);
        }
        else if (name == null)
        {
            ud.showMessage("Error, please enter a name");
            editEntry();
        }
        else
        {   
            ud.showMessage("Error, name not found in phonebook.");
            getChoice();
        }
    }


    /**
     * Edits an entry.
     */
    private void editEntry()
    {
        name = ud.getString("Please enter the name of the person:");
        System.out.println(name);
        removeEntry(name);
        System.out.println(name);
        addEntry(name);
        getChoice();
    }

    /**
     * Lists entries
     */
    private void listEntries()
    {
        for (java.util.Map.Entry<String, Entry> e: entries.entrySet())
        {
            System.out.println(e.toString());
        }
        getChoice();
    }
}