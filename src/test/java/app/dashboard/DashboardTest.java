package app.dashboard;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import org.junit.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DashboardTest {

	Dashboard dashboard;

	@Before
	public void setup() {
		dashboard = new Dashboard();
	}

	@Test
	public void testConstructor() {
		// Testing the constructor
		dashboard = new Dashboard();

		// should be empty lists or nulls
		assertArrayEquals(new Page[] {}, dashboard.getPages().toArray());
		assertArrayEquals(new String[] {}, dashboard.getPageNames().toArray());
		assertNull(dashboard.getDashboardPage(0));
	}

    @Test
    public void testNextId() {
	dashboard = new Dashboard();
	assertEquals(0, dashboard.nextId());
	assertEquals(1, dashboard.nextId());
	assertEquals(2, dashboard.nextId());
	for ( int i = 0; i < 100; i++ ) 
	    dashboard.nextId();
	assertEquals(103, dashboard.nextId());
    }
		     

    
	@Test
	public void testAddPage() {
		// Testing addPage() method
		dashboard = new Dashboard();

		dashboard.addPage(1, "first page");

		assertEquals(1, dashboard.getPages().size());
		assertEquals(1, dashboard.getDashboardPage(1).getId());
		assertEquals("first page", dashboard.getDashboardPage(1).getName());

		dashboard.addPage(2, "second page");
		dashboard.addPage(3, "third page");
		assertEquals(3, dashboard.getPages().size()); // 3 pages in dashboard
		// test names of pages
		assertArrayEquals(new String[] { "first page", "second page", "third page", },
				dashboard.getPageNames().toArray());

	}

    @Test
    public void testDeletePage() {
	// Testing deletePage() method
	dashboard = new Dashboard();

	dashboard.addPage(1, "one");
	dashboard.addPage(2, "two");
	dashboard.addPage(3, "three");
	
	dashboard.deletePage(1);
	assertEquals(2, dashboard.getPages().size()); // 2 pages in dashboard
	
	dashboard.deletePage(3);
	assertArrayEquals(new String[] {"two"}, dashboard.getPageNames().toArray());

	dashboard.deletePage(2);
	assertEquals(0, dashboard.getPages().size());
    }
	

	@Test
	public void testGetPages() {
		dashboard = new Dashboard();
		// empty list of pages
		assertEquals(0, dashboard.getPages().size());

		// one page
		dashboard.addPage(1, "first page");
		assertEquals(1, dashboard.getPages().size());

		// two pages
		dashboard.addPage(2, "second page");
		dashboard.addPage(3, "third page");
		assertEquals(3, dashboard.getPages().size());

		// check they are page objects
		for (int i = 0; i < dashboard.getPages().size(); i++) {
			assertTrue(dashboard.getPages().get(i) instanceof Page);
		}
	}

	@Test
	public void testGetPageNames() {
		dashboard = new Dashboard();
		// empty list of page names
		assertEquals(0, dashboard.getPageNames().size());

		// one page, name: "first page"
		dashboard.addPage(1, "first page");
		assertArrayEquals(new String[] { "first page" }, dashboard.getPageNames().toArray());

		dashboard.addPage(2, "second page");
		dashboard.addPage(2, "third page");
		String[] names = new String[] { "first page", "second page", "third page" };
		assertArrayEquals(names, dashboard.getPageNames().toArray());
	}

	@Test
	public void testGetDashboardPage() {
		dashboard = new Dashboard();

		// no such page with id 1 exists
		assertNull(dashboard.getDashboardPage(1));

		// get page id 1
		dashboard.addPage(1, "first");
		assertEquals("first", dashboard.getDashboardPage(1).getName());
		// no such page with id 2 exists
		assertNull(dashboard.getDashboardPage(2));

		dashboard.addPage(2, "second");
		dashboard.addPage(3, "third");
		assertEquals("second", dashboard.getDashboardPage(2).getName());
		assertEquals("third", dashboard.getDashboardPage(3).getName());
	}

}
