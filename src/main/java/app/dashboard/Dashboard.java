package app.dashboard;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Dashboard implements Serializable {
    // List of Page objects in this Dashboard
    private List<Page> pageList;
    // An array of possible id values, indicating which one is used
    private boolean[] idList;
    private int idIndex; // last used id
    
    // Constructor
    // Instantiates an instance of ArrayList
    // Sets the pageList field to the the empty ArrayList
    // Instantiates idList to an array of all false
    // Sets the first usable id index to 0
    public Dashboard() {
        pageList = new ArrayList<Page>();
	idList = new boolean[Integer.MAX_VALUE / 10];
	idIndex = 0;
    }

    // Returns the next available id number to use
    // Marks the id number as used
    public int nextId() {
	int i = idIndex;
	while ( idList[i % idList.length] == true )
	    i++;

	idList[i % idList.length] = true; // mark new id as used
	idIndex = i % idList.length;
	
	return i % idList.length; // return id value ready for use
    }
    
    // Returns a List of Page objects that this Dashboard contains
    public List<Page> getPages() {
        return pageList;
    }

    // Returns a List of Strings of Page names
    public List<String> getPageNames() {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < pageList.size(); i++) {
            names.add(pageList.get(i).getName());
        }
        return names;

    }

    // Returns the Page object with specified id
    public Page getDashboardPage(int id) {
        for (int i = 0; i < pageList.size(); i++) {
            if (id == pageList.get(i).getId())
                return pageList.get(i);
        }
        return null; // should be an error if not found
    }

    // Creates a new Page object on the dashboard w/ the specified name and id
    public void addPage(int id, String name) {
        Page newPage = new Page(id, name);
        pageList.add(newPage);
    }

    // Removes a Page object from pageList with id matching the int parameter
    // Does nothing if such a page does not exist
    public void deletePage(int id) {
	for (int i = 0; i < pageList.size(); i++) {
	    if (id == pageList.get(i).getId()) // match
		pageList.remove(i);
	}
    }
}
