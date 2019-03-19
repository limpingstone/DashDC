package app.dashboard;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Dashboard implements Serializable {
    private List<Page> pageList;

    public Dashboard() {
        pageList = new ArrayList<Page>();
    }

    // returns a list of page objects
    public List<Page> getPages() {
        return pageList;
    }

    // returns a list of page names
    public List<String> getPageNames() {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < pageList.size(); i++) {
            names.add(pageList.get(i).getName());
        }
        return names;

    }

    // returns the page object with specified id
    public Page getDashboardPage(int id) {
        for (int i = 0; i < pageList.size(); i++) {
            if (id == pageList.get(i).getId())
                return pageList.get(i);
        }
        return null; // should be an error if not found
    }

    // creates a new page on the dashboard w/ the specified name and id
    public void addPage(int id, String name) {
        Page newPage = new Page(id, name);
        pageList.add(newPage);
    }

}
