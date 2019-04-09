package app.dashboard;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Dashboard implements Serializable {
    private List<Page> pageList;

    // Constructor
    // Instantiates an instance of ArrayList
    // Sets the pageList field to the the empty ArrayList
    public Dashboard() {
        pageList = new ArrayList<Page>();
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

}
